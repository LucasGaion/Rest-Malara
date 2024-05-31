pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/LucasGaion/Rest-Malara.git'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
    }
}
