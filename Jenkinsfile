pipeline {
    agent any

    environment {
        // Tomcat
        TOMCAT_HOME = 'C:\\apache-tomcat-10.1.57'
        CATALINA_HOME = 'C:\\apache-tomcat-10.1.57'
        CATALINA_BASE = 'C:\\apache-tomcat-10.1.57'

        // Java
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-21.0.10'
        JRE_HOME = 'C:\\Program Files\\Java\\jdk-21.0.10'

        // Application
        APP_NAME = 'StudentFeedbackPortal'
    }

    stages {

        stage('Checkout') {
            steps {
                echo '=============================================='
                echo 'CHECKOUT SOURCE CODE'
                echo '=============================================='
                echo 'Source code checked out from GitHub.'
            }
        }

        stage('Build') {
            steps {
                echo '=============================================='
                echo 'BUILDING APPLICATION'
                echo '=============================================='

                bat 'mvn clean package'
            }
        }

        stage('Archive WAR') {
            steps {
                echo '=============================================='
                echo 'ARCHIVING WAR FILE'
                echo '=============================================='

                archiveArtifacts artifacts: 'target/StudentFeedbackPortal.war',
                                 fingerprint: true
            }
        }

        stage('Stop Tomcat') {
            steps {
                echo '=============================================='
                echo 'STOPPING TOMCAT'
                echo '=============================================='

                bat '''
                    echo JAVA_HOME=%JAVA_HOME%
                    echo CATALINA_HOME=%CATALINA_HOME%

                    call "%CATALINA_HOME%\\bin\\shutdown.bat"

                    timeout /t 5 /nobreak >nul
                '''
            }
        }

        stage('Deploy WAR') {
            steps {
                echo '=============================================='
                echo 'DEPLOYING WAR TO TOMCAT'
                echo '=============================================='

                bat '''
                    echo Removing old application...

                    if exist "%TOMCAT_HOME%\\webapps\\%APP_NAME%" (
                        rmdir /S /Q "%TOMCAT_HOME%\\webapps\\%APP_NAME%"
                    )

                    if exist "%TOMCAT_HOME%\\webapps\\%APP_NAME%.war" (
                        del /F /Q "%TOMCAT_HOME%\\webapps\\%APP_NAME%.war"
                    )

                    echo Copying new WAR file...

                    copy /Y "target\\%APP_NAME%.war" "%TOMCAT_HOME%\\webapps\\%APP_NAME%.war"

                    echo WAR deployment completed.
                '''
            }
        }

        stage('Start Tomcat') {
            steps {
                echo '=============================================='
                echo 'STARTING TOMCAT'
                echo '=============================================='

                bat '''
                    echo Starting Tomcat...

                    call "%CATALINA_HOME%\\bin\\startup.bat"

                    timeout /t 10 /nobreak >nul

                    echo Tomcat startup command completed.
                '''
            }
        }

        stage('Deployment Verification') {
            steps {
                echo '=============================================='
                echo 'DEPLOYMENT VERIFICATION'
                echo '=============================================='

                bat '''
                    echo Checking deployed WAR...

                    if exist "%TOMCAT_HOME%\\webapps\\%APP_NAME%.war" (
                        echo WAR file successfully deployed.
                    ) else (
                        echo ERROR: WAR file was not deployed.
                        exit /b 1
                    )
                '''

                echo 'Application URL: http://localhost:9090/StudentFeedbackPortal/'
                echo 'Tomcat URL: http://localhost:9090/'
            }
        }
    }

    post {

        success {
            echo '''
==============================================
       CI/CD PIPELINE COMPLETED SUCCESSFULLY
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
Tomcat Stop
   |
   v
WAR Deployment
   |
   v
Tomcat Start
   |
   v
Student Feedback Portal

Application:
http://localhost:9090/StudentFeedbackPortal/

==============================================
'''
        }

        failure {
            echo '''
==============================================
          CI/CD PIPELINE FAILED
==============================================

Please check the Jenkins Console Output.

==============================================
'''
        }
    }
}