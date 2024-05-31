pipeline {
    agent any
    environment {
        MAVEN_HOME = '/opt/homebrew/opt/maven/libexec'
        PATH = "${MAVEN_HOME}/bin:${env.PATH}"
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
