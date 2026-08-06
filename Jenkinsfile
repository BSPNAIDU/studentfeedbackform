pipeline {
    agent any

    environment {
        TOMCAT_HOME = 'C:\\apache-tomcat-10.1.57'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Source code checked out from GitHub.'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Archive WAR') {
            steps {
                archiveArtifacts artifacts: 'target/*.war', fingerprint: true
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                bat """
                if exist "%TOMCAT_HOME%\\webapps\\StudentFeedbackPortal" rmdir /S /Q "%TOMCAT_HOME%\\webapps\\StudentFeedbackPortal"
                if exist "%TOMCAT_HOME%\\webapps\\StudentFeedbackPortal.war" del /F /Q "%TOMCAT_HOME%\\webapps\\StudentFeedbackPortal.war"

                copy /Y target\\StudentFeedbackPortal.war "%TOMCAT_HOME%\\webapps\\"

                call "%TOMCAT_HOME%\\bin\\shutdown.bat"

                timeout /t 5

                call "%TOMCAT_HOME%\\bin\\startup.bat"
                """
            }
        }
    }

    post {

        success {
            echo 'Student Feedback Portal deployed successfully.'
        }

        failure {
            echo 'Deployment failed.'
        }
    }
}