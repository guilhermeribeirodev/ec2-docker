node {
    echo 'Starting'
    def slackMessage = '';
    def color = '#00EE11'
    def errorMsg = ''
    checkout scm
    //git url: 'https://github.com/guilhermeribeirodev/ec2-docker'
    def java = docker.image('maven');

    def branch = env.GIT_BRANCH
    def commit = env.GIT_COMMIT

    gitCommit = sh(returnStdout: true, script: 'git rev-parse HEAD').trim()
    slackSend message: "Build Started: Job: ${env.JOB_NAME} Build # ${env.BUILD_NUMBER}\n commit: " + gitCommit , color: '#ffff00'

    stage('Build'){

        try{
            slackMessage +=  "Build Started: Job: ${env.JOB_NAME} Build # ${env.BUILD_NUMBER}\n" + gitCommit
            java.inside{
                sh 'java -version'
                echo 'listing files inside docker'
                dir('sample'){
                    //sh 'mvn clean install'
                    sh 'ls'
                }
            }

            slackMessage += "Build successfully done: commit ${commit} @ branch:${branch}"    
        } catch(e){
    
            errorMsg += e.getStackTrace()
            color = '#FF0000'
            slackMessage = "Build not successfully done see more at "+
            "http://ec2-52-26-192-142.us-west-2.compute.amazonaws.com:8007/me/my-views/view/all/job/car-service/${env.BUILD_NUMBER}/console" 

        } finally {
            
            slackSend message: slackMessage , color: color

        }

    }
    
}