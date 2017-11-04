//need utility plugin for readProperties

pipeline {
    agent any

    tools {
        maven 'maven'
    }

    environment {
        DOCKER_IMAGE_NAME = "-img"
    }

    stages {
        stage('Prepare') {
            steps {
                script {
                    properties = readProperties file: 'Jenkinsfile.properties'
                    properties.each{ k, v -> env."${k}"="${v}" }
                }
                hello "Ready"
            }
        }
        stage('Package') {
            steps {
                sh "printenv | sort"
                sh "build/build.sh"
                //sh "mvn clean package"
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "echo deploy here"
                //sh "mvn -Dbuild.tag=${env.BUILD_TAG} docker:build -DpushImage"
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh "echo deploy here"
                //sh "sed -i.bak 's#:latest#:${env.BUILD_TAG}#' k8s-deployment.yml"
                //sh "kubectl apply -f k8s-deployment.yml"
            }
        }
    }
}