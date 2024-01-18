def call(String microserviceName, String repoUrl, String branch) {
    def workingDir = "${env.WORKSPACE}/${microserviceName}"
    
    // Clone the repository
    sh "git clone ${repoUrl} ${workingDir}"
    
    // Checkout the specified branch
    sh "git -C ${workingDir} checkout ${branch}"
    
    return workingDir
}