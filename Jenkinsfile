node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/ralphmcneal/spring-boot-hello.git'
      // Get the Maven tool.
      mvnHome = tool 'M3'
   }

   stage('Package') {
         sh "'${mvnHome}/bin/mvn' clean package"
   }

   stage('Build Docker Image') {
         sh "'${mvnHome}/bin/mvn' docker:build -DpushImage"
   }

   stage('Deploy to Kubernetes') {
       // delete pod to get the image to repull, since dev version does not change (to eliminate this, tag the snapshots with a build number)
      sh '''
            kubectl apply -f k8s-deployment.yml
            kubectl delete po -l app=test
        '''
   }

}