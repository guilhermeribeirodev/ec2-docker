node {
    echo 'Starting'
    checkout scm
    def java = docker.image('java');
    stage('Build'){
        
        java.inside{
            sh 'java -version'
        }
    }
}