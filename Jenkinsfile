pipeline {
    agent {
    	docker {
    		FROM openjdk:11
			ARG JAR_FILE
			COPY ${JAR_FILE} app.jar
			ENTRYPOINT ["java","-jar","/app.jar"]
    	}
    }
    
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
        stage('BuildDocker'){
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

            }
        }
    }
}