node {
    echo 'Starting'
    def slackMessage = '';
    def color = '#005EFF'
    checkout scm
    //git url: 'https://github.com/guilhermeribeirodev/ec2-docker'

    def java = docker.image('maven');

    stage('Build'){

        try{
            slackMessage +=  "Build Started: Job: ${env.JOB_NAME} Build # ${env.BUILD_NUMBER}\n"
            java.inside{
                sh 'java -version'
                echo 'listing files inside docker'
                dir('sample'){
                    sh 'mvn clean install'
                    //sh 'ls'
                }
            }

            slackMessage += "Build successfully done: commit ${env.GIT_COMMIT} @ branch:${env.GIT_BRANCH}"    

        } finally {
            
            slackSend message: "Build not successfully done: commit ${env.GIT_COMMIT} @ branch:${env.GIT_BRANCH}" , color: '#FF0000'
        }

        slackSend message: message , color: color
        
    }
    
}