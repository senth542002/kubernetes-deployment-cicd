pipeline {
	environment {
	    registry = "senth542002/kubernetes-deployment"
	    registryCredential = 'docker-hub'
	    dockerImage = ''
	    PROJECT_ID = 'say-hello-project'
        LOCATION = 'CLUSTER-LOCATION'
        CREDENTIALS_ID = 'say-hello'
        CLUSTER_NAME = 'say-hello-cluster'
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
                	dockerImage = docker.build registry + ":$BUILD_NUMBER"
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
        
        stage('Deploy App to GKE') {
	      steps {
	        script {
	          sh "sed -i 's/kubernetes-deployment:latest/kubernetes-deployment:$BUILD_NUMBER/g' sayhello.yml"
	          step([$class: 'KubernetesEngineBuilder', projectId: env.PROJECT_ID, cluster: env.CLUSTER_NAME, location: env.LOCATION, manifestPattern: 'sayhello.yaml', credentialsId: env.CREDENTIALS_ID, verifyDeployments: true])
	        }
	      }
	    }
    }
}