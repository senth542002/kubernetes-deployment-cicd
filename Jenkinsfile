pipeline {
	environment {
	    registry = "senth542002/kubernetes-deployment"
	    registryCredential = 'docker-hub'
	    dockerImage = ''
	  }
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
            	script {
                	dockerImage = ./gradlew docker
            	}
            }
        }
        stage('Push'){
            steps {
            	script {
					docker.withRegistry('https://registry.hub.docker.com', 'docker-hub') {
                    dockerImage.push()
                	}            	
            	}
            }
        }
    }
}