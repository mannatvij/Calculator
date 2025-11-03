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

        stage('Build & Unit Test') {
            steps {
                echo "Running build and unit tests..."
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
                echo " Deploying application (simulated)..."
                bat 'echo "App deployed successfully to local server!"'
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
