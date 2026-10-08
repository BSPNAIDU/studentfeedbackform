pipeline {
    agent any

    environment {
        // ==============================
        // TOMCAT CONFIGURATION
        // ==============================
        TOMCAT_HOME = 'C:\\apache-tomcat-10.1.57'
        CATALINA_HOME = 'C:\\apache-tomcat-10.1.57'
        CATALINA_BASE = 'C:\\apache-tomcat-10.1.57'

        // ==============================
        // JAVA CONFIGURATION
        // ==============================
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-21.0.10'
        JRE_HOME = 'C:\\Program Files\\Java\\jdk-21.0.10'

        // ==============================
        // APPLICATION
        // ==============================
        APP_NAME = 'StudentFeedbackPortal'
    }

    stages {

        // ==========================================
        // CHECKOUT
        // ==========================================
        stage('Checkout') {
            steps {
                echo '=============================================='
                echo 'CHECKOUT SOURCE CODE'
                echo '=============================================='
                echo 'Source code checked out from GitHub.'
            }
        }

        // ==========================================
        // BUILD
        // ==========================================
        stage('Build') {
            steps {
                echo '=============================================='
                echo 'BUILDING APPLICATION'
                echo '=============================================='

                bat 'mvn clean package'
            }
        }

        // ==========================================
        // ARCHIVE WAR
        // ==========================================
        stage('Archive WAR') {
            steps {
                echo '=============================================='
                echo 'ARCHIVING WAR FILE'
                echo '=============================================='

                archiveArtifacts artifacts: 'target/StudentFeedbackPortal.war',
                                 fingerprint: true
            }
        }

        // ==========================================
        // STOP TOMCAT
        // ==========================================
        stage('Stop Tomcat') {
            steps {
                echo '=============================================='
                echo 'STOPPING TOMCAT'
                echo '=============================================='

                bat '''
                    echo JAVA_HOME=%JAVA_HOME%
                    echo JRE_HOME=%JRE_HOME%
                    echo CATALINA_HOME=%CATALINA_HOME%

                    echo.
                    echo Sending shutdown command to Tomcat...

                    call "%CATALINA_HOME%\\bin\\shutdown.bat"

                    echo.
                    echo Waiting for Tomcat to stop...

                    ping 127.0.0.1 -n 6 >nul

                    echo Tomcat shutdown wait completed.
                '''
            }
        }

        // ==========================================
        // DEPLOY WAR
        // ==========================================
        stage('Deploy WAR') {
            steps {
                echo '=============================================='
                echo 'DEPLOYING WAR TO TOMCAT'
                echo '=============================================='

                bat '''
                    echo Removing old application directory...

                    if exist "%TOMCAT_HOME%\\webapps\\%APP_NAME%" (
                        rmdir /S /Q "%TOMCAT_HOME%\\webapps\\%APP_NAME%"
                    )

                    echo Removing old WAR file...

                    if exist "%TOMCAT_HOME%\\webapps\\%APP_NAME%.war" (
                        del /F /Q "%TOMCAT_HOME%\\webapps\\%APP_NAME%.war"
                    )

                    echo.
                    echo Copying new WAR file...

                    copy /Y "target\\%APP_NAME%.war" "%TOMCAT_HOME%\\webapps\\%APP_NAME%.war"

                    if errorlevel 1 (
                        echo ERROR: WAR deployment failed.
                        exit /b 1
                    )

                    echo.
                    echo WAR deployment completed successfully.
                '''
            }
        }

        // ==========================================
        // START TOMCAT
        // ==========================================
        stage('Start Tomcat') {
            steps {
                echo '=============================================='
                echo 'STARTING TOMCAT'
                echo '=============================================='

                bat '''
                    echo Starting Tomcat...

                    call "%CATALINA_HOME%\\bin\\startup.bat"

                    echo.
                    echo Waiting for Tomcat to start...

                    ping 127.0.0.1 -n 11 >nul

                    echo Tomcat startup wait completed.
                '''
            }
        }

        // ==========================================
        // DEPLOYMENT VERIFICATION
        // ==========================================
        stage('Deployment Verification') {
            steps {
                echo '=============================================='
                echo 'VERIFYING DEPLOYMENT'
                echo '=============================================='

                bat '''
                    echo Checking WAR file...

                    if exist "%TOMCAT_HOME%\\webapps\\%APP_NAME%.war" (
                        echo WAR file exists successfully.
                    ) else (
                        echo ERROR: WAR file was not found.
                        exit /b 1
                    )

                    echo.
                    echo Checking deployed application directory...

                    if exist "%TOMCAT_HOME%\\webapps\\%APP_NAME%" (
                        echo Application directory exists.
                    ) else (
                        echo WARNING: Application directory is not available yet.
                    )
                '''

                echo '=============================================='
                echo 'APPLICATION DEPLOYED'
                echo '=============================================='
                echo 'Application URL: http://localhost:9090/StudentFeedbackPortal/'
                echo 'Tomcat URL: http://localhost:9090/'
            }
        }
    }

    // ==========================================
    // POST ACTIONS
    // ==========================================
    post {

        success {
            echo '''
==============================================
       CI/CD PIPELINE SUCCESS
==============================================

GitHub
   |
   v
Jenkins
   |
   v
Maven Build
   |
   v
WAR File
   |
   v
Stop Tomcat
   |
   v
Deploy WAR
   |
   v
Start Tomcat
   |
   v
Application Running

==============================================
Student Feedback Portal
==============================================

Application:
http://localhost:9090/StudentFeedbackPortal/

Tomcat:
http://localhost:9090/

==============================================
'''
        }

        failure {
            echo '''
==============================================
          CI/CD PIPELINE FAILED
==============================================

Check the Jenkins Console Output
for the failed stage.

==============================================
'''
        }
    }
}