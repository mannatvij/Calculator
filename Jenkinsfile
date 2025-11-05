pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK21'
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out code..."
                git branch: 'master', url: 'https://github.com/mannatvij/Calculator.git'
            }
        }

        stage('Compile') {
            steps {
                echo "Compiling the project..."
                bat 'mvn clean compile -T 1C'
            }
        }

        stage('Build & Test') {
            steps {
                echo "Running build and tests..."
                bat 'mvn test -T 1C'
            }
        }

        stage('Package') {
            steps {
                echo "Packaging application..."
                bat 'mvn package -DskipTests -T 1C'
            }
        }



        stage('Deploy') {
                   steps {
                       echo '🚀 Deploying application...'
                       // Run the packaged JAR directly instead of re-running Spring Boot plugin
                       bat 'start /B java -jar target/calculator_app-1.0-SNAPSHOT.jar --server.port=8082'
                       echo '🌐 Application deployed at http://localhost:8082'
                   }
               }
    }

    post {
        always {
            echo " Cleaning workspace..."
            cleanWs()
        }
        success {
            echo "All stages completed successfully!"
        }
        failure {
            echo " Build failed. Check logs!"
        }
    }
}
