def call(String microserviceName, String repoUrl, String branch) {
    def workingDir = "${env.WORKSPACE}/${microserviceName}"
    
    // Clone the repository
    bat "git clone ${repoUrl} ${workingDir}"
    
    // Checkout the specified branch
    bat "git -C ${workingDir} checkout ${branch}"
    
    return workingDir
}