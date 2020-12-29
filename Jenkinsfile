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
            steps {
                withDockerRegistry(credentialsId: 'docker-hub', url: 'https://hub.docker.com/') {
                    sh 'docker push senth542002/kubernetes-deployment'
                }

            }
        }
    }
}