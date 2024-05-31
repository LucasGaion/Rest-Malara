pipeline {
    agent any
    environment {
        MAVEN_HOME = "/opt/homebrew/bin/mvn"
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/LucasGaion/Rest-Malara.git'
            }
        }
        stage('Build') {
            steps {
                script {
                    sh "${env.MAVEN_HOME} clean install"
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh "${env.MAVEN_HOME} test"
                }
            }
        }
    }
}
