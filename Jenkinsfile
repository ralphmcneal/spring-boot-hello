pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Package') {
            steps {
                sh "mvn clean package"
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "mvn -Dbuild.tag=${env.BUILD_TAG} docker:build -DpushImage"
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh "sed -i.bak 's#:latest#:${env.BUILD_TAG}#' k8s-deployment.yml"
                sh "kubectl apply -f k8s-deployment.yml"
            }
        }
    }
}