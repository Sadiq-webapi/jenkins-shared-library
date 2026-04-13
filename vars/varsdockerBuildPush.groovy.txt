def call(String imageName, String dockerHubUser) {
    echo "Building and Pushing Docker Image: ${imageName}"
    sh "docker build -t ${dockerHubUser}/${imageName}:latest ."
    sh "docker push ${dockerHubUser}/${imageName}:latest"
}