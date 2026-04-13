def call(String credentialsId, String region = 'ap-south-2') {
    echo "Authenticating with AWS in ${region}..."
    withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: credentialsId]]) {
        sh "aws eks update-kubeconfig --region ${region} --name clusters"
        // Verify identity to ensure no 'IncompleteSignature' errors
        sh "aws sts get-caller-identity"
    }
}