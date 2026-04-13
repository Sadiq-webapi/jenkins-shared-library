def call(String awsCreds, String clusterName, String region) {
    echo "Authenticating for cluster: ${clusterName}"
    withCredentials([aws(credentialsId: awsCreds, 
                        accessKeyVariable: 'AWS_ACCESS_KEY_ID', 
                        secretKeyVariable: 'AWS_SECRET_ACCESS_KEY')]) {
        // Run the command directly, do NOT call awsAuth() here
        sh "aws eks update-kubeconfig --region ${region} --name ${clusterName}"
    }
}