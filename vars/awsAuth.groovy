def call(String awsCreds, String clusterName, String region) {
    echo "Authenticating for cluster: ${clusterName}"
    withCredentials([usernamePassword(credentialsId: awsCreds, 
                                     usernameVariable: 'AWS_ACCESS_KEY_ID', 
                                     passwordVariable: 'AWS_SECRET_ACCESS_KEY')]) {
        sh "aws eks update-kubeconfig --region ${region} --name ${clusterName}"
        sh "docker build -t ${dockerUser}/${imageName}:latest ${dockerfileDir}"
    }
}