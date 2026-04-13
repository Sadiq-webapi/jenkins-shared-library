def call(String awsCreds, String clusterName, String region) {
    echo "Authenticating for cluster: ${clusterName}"
    withCredentials([usernamePassword(credentialsId: awsCreds, 
                                     usernameVariable: 'AWS_ACCESS_KEY_ID', 
                                     passwordVariable: 'AWS_SECRET_ACCESS_KEY')]) {
        // We use 'bat' because your logs show you are on Windows
        bat "aws eks update-kubeconfig --region ${region} --name ${clusterName}"
    }
}