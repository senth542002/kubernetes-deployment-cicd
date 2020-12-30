pipeline {
    agent any
    
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh './gradlew assemble'
            }
        }
        stage('Test'){
            steps {
                sh './gradlew test'
            }
        }
        stage('BuildDocker') {

            steps {
                sh './gradlew docker'
            }
        }
        stage('Push'){
        
                docker.withRegistry('https://registry.hub.docker.com', 'docker-hub') {
                    sh 'docker push senth542002/kubernetes-deployment'
                }

        }
    }
}