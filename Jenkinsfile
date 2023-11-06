pipeline {
    agent none
    stages {
        stage('Build') {
            agent {
                dockerContainer { 
                    image 'jenkins/inbound-agent-with-maven'
                    }
            }
            steps {
                // checkout source code from Github
                checkout scm

                sh 'ls -lrt'

                // build
                sh 'mvn package'

                // package
                withRun('-p 1234:1234') {
                        sh 'java -jar ./target/simpleApp.jar'
            }
        }
    }
}
}