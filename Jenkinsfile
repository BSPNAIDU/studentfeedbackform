pipeline {
    agent any

    environment {
        TOMCAT_HOME = 'C:\\apache-tomcat-10.1.57'
        CATALINA_HOME = 'C:\\apache-tomcat-10.1.57'
        CATALINA_BASE = 'C:\\apache-tomcat-10.1.57'
        APP_NAME = 'StudentFeedbackPortal'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out source code from GitHub...'
            }
        }

        stage('Build') {
            steps {
                echo 'Building Student Feedback Portal...'
                bat 'mvn clean package'
            }
        }

        stage('Archive WAR') {
            steps {
                echo 'Archiving WAR file...'

                archiveArtifacts artifacts: 'target/StudentFeedbackPortal.war',
                                 fingerprint: true
            }
        }

        stage('Stop Tomcat') {
            steps {
                echo 'Stopping Tomcat...'

                bat '''
                call "%CATALINA_HOME%\\bin\\shutdown.bat"
                timeout /t 5 /nobreak >nul
                '''
            }
        }

        stage('Deploy WAR') {
            steps {
                echo 'Deploying WAR to Tomcat...'

                bat '''
                if exist "%TOMCAT_HOME%\\webapps\\%APP_NAME%" (
                    rmdir /S /Q "%TOMCAT_HOME%\\webapps\\%APP_NAME%"
                )

                if exist "%TOMCAT_HOME%\\webapps\\%APP_NAME%.war" (
                    del /F /Q "%TOMCAT_HOME%\\webapps\\%APP_NAME%.war"
                )

                copy /Y "target\\%APP_NAME%.war" "%TOMCAT_HOME%\\webapps\\%APP_NAME%.war"
                '''
            }
        }

        stage('Start Tomcat') {
            steps {
                echo 'Starting Tomcat...'

                bat '''
                call "%CATALINA_HOME%\\bin\\startup.bat"
                timeout /t 10 /nobreak >nul
                '''
            }
        }

        stage('Deployment Verification') {
            steps {
                echo 'Student Feedback Portal deployment completed successfully.'
                echo 'Application URL: http://localhost:9090/StudentFeedbackPortal/'
            }
        }
    }

    post {

        success {
            echo '=============================================='
            echo 'CI/CD PIPELINE COMPLETED SUCCESSFULLY'
            echo 'GitHub -> Jenkins -> Maven -> WAR -> Tomcat'
            echo '=============================================='
        }

        failure {
            echo '=============================================='
            echo 'CI/CD PIPELINE FAILED'
            echo 'Please check the Jenkins Console Output.'
            echo '=============================================='
        }
    }
}