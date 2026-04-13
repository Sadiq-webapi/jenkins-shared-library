def call(String credentialsId, String clusterName, String region = 'ap-south-2') {
    echo "Authenticating for cluster: ${clusterName}"
    withCredentials([usernamePassword(
        credentialsId: credentialsId, 
        passwordVariable: 'AWS_SECRET_ACCESS_KEY', 
        usernameVariable: 'AWS_ACCESS_KEY_ID'
    )]) {
        // Use the clusterName variable here!
        sh "aws eks update-kubeconfig --region ${region} --name ${clusterName}"
        sh "aws sts get-caller-identity"
    }
}