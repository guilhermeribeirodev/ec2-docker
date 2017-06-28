node {
    echo 'Starting'
    checkout scm
    sh 'ls'
    def java = docker.image('java');
    stage('Build'){
        
        java.inside{
            sh 'java -version'
            sh 'ls'
        }
    }
}