def call(String credentialsId, String region = 'ap-south-2') {
    echo "Authenticating with AWS in ${region} using Username/Password credentials..."
    
    // Paste the block here:
    withCredentials([usernamePassword(
        credentialsId: credentialsId, 
        passwordVariable: 'AWS_SECRET_ACCESS_KEY', 
        usernameVariable: 'AWS_ACCESS_KEY_ID'
    )]) {
        // These shell commands now use the variables defined above
        sh "aws eks update-kubeconfig --region ${region} --name clusters"
        sh "aws sts get-caller-identity"
    }
}