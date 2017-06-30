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

    stage('Build'){

        try{
            slackMessage +=  'Build Started: Job: ${env.JOB_NAME} Build # ${env.BUILD_NUMBER}\n' + gitCommit
            java.inside{
                sh 'java -version'
                echo 'listing files inside docker'
                dir('sample'){
                    sh 'mvn clean install'
                    //sh 'ls'
                }
            }

            slackMessage += "Build successfully done: commit ${commit} @ branch:${branch}"    
        } catch(e){
    
            errorMsg += e.getStackTrace()
        } finally {
            
            slackSend message: "Build not successfully done: commit ${env.GIT_COMMIT} @ branch:${env.GIT_BRANCH}\n"+errorMsg , color: '#FF0000'
        }

        slackSend message: message , color: color
        
    }
    
}