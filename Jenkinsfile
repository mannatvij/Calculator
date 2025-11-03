pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK21'
    }

    environment {
        MAVEN_OPTS = "-Dmaven.repo.local=.m2/repository"
        SERVER_PORT = "8081"
    }

    stages {
        stage('Checkout') {
            steps {
                echo '🔄 Checking out code...'
                git branch: 'master', url: 'https://github.com/mannatvij/Calculator.git'
            }
        }

        stage('Build') {
            steps {
                echo '⚙️ Building project...'
                bat 'mvn clean compile -q'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Running tests...'
                bat 'mvn test -q'
            }
        }

        stage('Package') {
            steps {
                echo '📦 Packaging application...'
                bat 'mvn package -q'
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 Starting Spring Boot app on port 8081...'
                bat 'start /B mvn spring-boot:run -Dserver.port=%SERVER_PORT%'
                echo '✅ Application started successfully at http://localhost:8081'
            }
        }
    }

    post {
        always {
            echo '🧹 Cleaning up temporary processes...'
            // Gracefully stop running app before cleaning workspace
            bat 'taskkill /F /IM java.exe || echo "No Java process to stop"'
        }

        success {
            echo '🎉 Pipeline executed successfully!'
        }

        failure {
            echo '💥 Pipeline failed!'
        }
    }
}
