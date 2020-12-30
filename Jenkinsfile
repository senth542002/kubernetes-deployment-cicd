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
                	dockerImage = docker.build "KubeDeployment-0.0.1-SNAPSHOT.jar"
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