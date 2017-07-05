## Checking out from SCM (Git, SVN) and building on a pipeline.

Let's start from the last saved Jenkins pipeline.


```
node {
    echo 'Started my pipeline job'
    stage("Build") {
        echo 'Building code here ...'
    }
    stage("Deploy") {
        echo 'Deploying artifacts here ...'
    }
    stage("Test") {
        echo 'Run the tests ...'
    }
}
```

The plan is to checkout and build some application using the pipeline. This can be done with
a couple of lines on the build pipeline.

#### Before doing that we'll need to create a simple Java project.

1. Create a simple test case. This can be done using a Maven archetype. 

	$`mvn archetype:generate`

2. Choose a number of the wide list of projects. I'd suggest the #153 which is a very simple Java 1.8 test case.

3. Fill the required information. Navigate into the maven fresh generated folder and run the maven verify.

	$`mvn clean verify`

4. This will run the tests and build a jar file with the dependencies.

5. Now it's time to put it into a git repository. Skip to the next topic if you want to use the [existent one](https://github.com/guilhermeribeirodev/sample). 

6. If you followed the manual creation steps don't forget to ignore the builded files.

	$`touch .gitignore && echo target/ > .gitignore`


#### Checking out and building from the pipeline.

1. There are 2 ways to use a git repository within the pipeline. The simplest wat is to use the git word.

```
node {
    echo 'Started my pipeline job'
    stage("Build") {
        git 'https://github.com/guilhermeribeirodev/sample.git'
        echo 'Building code here ...'
    }
  
}
```

You might as well want to list the files by using a sh command as:

```
    stage("Build") {
        git 'https://github.com/guilhermeribeirodev/sample.git'
        sh 'ls'
        echo 'Building code here ...'
    }
```
If there are old files into Jenkins project workspace, you may have to delete them:
```
    stage("Build") {
        deleteDir()
        git 'https://github.com/guilhermeribeirodev/sample.git'
        sh 'ls'
        echo 'Building code here ...'
    }
```
2. Run the build using maven tools:

```
    stage("Build") {
        deleteDir()
        git 'https://github.com/guilhermeribeirodev/sample.git'
        sh 'mvn clean install'
        echo 'Building code here ...'
    }
```

There are many plugins available and many ways to use the Jenkins pipeline. This is the simplest way to test some pipeline tools. Although this way looks enough, it's a good practice to keep the scripts within a Jenkinsfile on the project repository as we will see in the [next example](scm-jenkinsfile.md).

[<- Back](README.md)
