//properties = null;
pipeline {
    agent any

    tools {
        maven 'maven'
    }

    stages {
        stage('Prepare') {
            steps {
                script {
//                    properties = readProperties file: 'Jenkinsfile.properties'
//                    echo "Immediate one ${properties.project_name}"
//                }
            }
        }
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
                sh "echo deploy here"
                //sh "sed -i.bak 's#:latest#:${env.BUILD_TAG}#' k8s-deployment.yml"
                //sh "kubectl apply -f k8s-deployment.yml"
            }
        }
    }
}