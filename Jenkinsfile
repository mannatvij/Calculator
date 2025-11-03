
pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK21'
    }
environment {
    MAVEN_OPTS = "-Dmaven.repo.local=.m2/repository"
}
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/mannatvij/Calculator.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }



        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }
        stage('Deploy') {
            steps {
                bat 'mvn spring-boot:run'
            }
        }

    }

    post {

        always {
            cleanWs()
        }

        success {
            echo 'Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}

