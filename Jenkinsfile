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
        
	     	agent { dockerfile true }

            steps {
                sh './gradlew docker'
            }
        }
        stage('Push'){
            environment {
                DOCKER_HUB_LOGIN = credentials('docker-hub')
            }
            steps {
                sh 'docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
                sh './gradlew dockerPush'
                withDockerRegistry(credentialsId: 'docker-hub', url: 'https://hub.docker.com/') {
                    sh 'docker push senth542002/kubernetes-deployment'
                }

            }
        }
    }
}