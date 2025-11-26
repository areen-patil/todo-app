pipeline {
    agent any
    
    tools {
        // We will configure this name 'Maven3' in Jenkins later
        maven 'Maven3' 
        // We will configure this name 'jdk17' in Jenkins later
        jdk 'jdk17'
    }

    environment {
        // Ensure this ID matches what you create in Jenkins Credentials
        DOCKER_CREDENTIALS_ID = 'dockerhub-creds'
        DOCKER_IMAGE = 'areenpatil/todo-app' 
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    bat "docker build -t %DOCKER_IMAGE%:%BUILD_NUMBER% ."
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: DOCKER_CREDENTIALS_ID, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                        bat "docker login -u %DOCKER_USER% -p %DOCKER_PASS%"
                        bat "docker push %DOCKER_IMAGE%:%BUILD_NUMBER%"
                    }
                }
            }
        }
    }
}