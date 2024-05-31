```groovy
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
                // Limpar o projeto
                sh 'mvn clean'
                // Compilar e instalar o projeto
                sh 'mvn install'
            }
        }
        
        stage('Test') {
            steps {
                // Executar os testes
                sh 'mvn test'
            }
        }
        
        stage('Deploy') {
            steps {
                // Coloque aqui os passos para implantar seu aplicativo
            }
        }
    }
}
```
