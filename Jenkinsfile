node {
    echo 'Starting'
    checkout scm
    sh 'ls'
    def java = docker.image('java');
    stage('Build'){
        
        java.inside{
            sh 'java -version'
            echo 'listing files inside docker'
            dir 'sample'
            sh 'ls'
        }
    }
}

git url: 'https://github.com/jfrogdev/project-examples.git'