pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK21'
    }

    environment {
        // Cache dependencies locally for faster builds
        MAVEN_OPTS = "-Dmaven.repo.local=${WORKSPACE}/.m2/repository"
    }

    stages {
        stage('Checkout') {
            steps {
                echo ' Checking out code...'
                git branch: 'master', url: 'https://github.com/mannatvij/Calculator.git'
            }
        }

        stage('Build & Test') {
            parallel {
                stage('Build') {
                    steps {
                        echo ' Building project...'
                        bat 'mvn clean compile -DskipTests'
                    }
                }
                stage('Test') {
                    steps {
                        echo ' Running tests...'
                        bat 'mvn test'
                    }
                }
            }
        }

        stage('Package') {
            steps {
                echo ' Packaging application...'
                bat 'mvn package -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                echo ' Deploying application...'
                // Run app in background, so Jenkins doesn’t hang forever
                bat 'start /B mvn spring-boot:run'
                echo ' Application started successfully!'
            }
        }
    }

    post {
        always {
            echo ' Cleaning workspace...'
            cleanWs()
        }

        success {
            echo ' Pipeline executed successfully!'
        }

        failure {
            echo ' Pipeline failed!'
        }
    }
}
