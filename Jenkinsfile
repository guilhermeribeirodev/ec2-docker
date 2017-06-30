node {
    echo 'Starting'
    def slackMessage = '';
    checkout scm
    //git url: 'https://github.com/guilhermeribeirodev/ec2-docker'

    def java = docker.image('maven');
    stage('Build'){
        slackMessage +=  "Build Started: Job: ${env.JOB_NAME} Build # ${env.BUILD_NUMBER}\n"
        java.inside{
            sh 'java -version'
            echo 'listing files inside docker'
            sh 'cd sample'
            sh 'ls'
            
        slackMessage += "Build successfully done: commit ${env.GIT_COMMIT} @ branch:${env.GIT_BRANCH}"    
          
        }
    }
    slackSend message: slackMessage, color: '#005EFF'
}