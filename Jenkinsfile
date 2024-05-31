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
                // Executar as metas Maven com withMaven
                withMaven(
                    maven: 'maven3', 
                    mavenSettingsConfig: 'my-maven-settings', 
                    mavenLocalRepo: '.repository'
                ) {
                    sh 'mvn clean install'
                }
            }
        }
        
        stage('Test') {
            steps {
                // Executar os testes com withMaven
                withMaven(
                    maven: 'maven3', 
                    mavenSettingsConfig: 'my-maven-settings', 
                    mavenLocalRepo: '.repository'
                ) {
                    sh 'mvn test'
                }
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
