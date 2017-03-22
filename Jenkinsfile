node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/ralphmcneal/spring-boot-hello.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.
      mvnHome = tool 'M3'
   }

   stage('Package') {
         sh "'${mvnHome}/bin/mvn' clean package"
   }

   stage('Build and Push Image') {
         sh "'${mvnHome}/bin/mvn' docker:build -DpushImage"
   }

   stage('Deploy to Kubernetes') {
      sh "kubectl apply -f k8s-deployment.yml"
   }

}