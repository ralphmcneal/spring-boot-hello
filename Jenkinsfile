node {
    def mvnHome
    stage('Preparation') {
        // Get some code from a GitHub repository
        git 'https://github.com/ralphmcneal/spring-boot-hello.git'
        // Get the Maven tool.
        mvnHome = tool 'M3'
    }

    stage('Package') {
        sh "'${mvnHome}/bin/mvn' clean package"
    }

    stage('Build Docker Image') {
        sh "'${mvnHome}/bin/mvn' -Dbuild.tag=${env.BUILD_TAG} docker:build -DpushImage"
    }

    stage('Deploy to Kubernetes') {
        sh "sed -i.bak 's#:latest#:${env.BUILD_TAG}#' k8s-deployment.yml"
        sh "kubectl apply -f k8s-deployment.yml"
    }
}