pipeline {
    agent none
    stages {
        stage('Build') {
            agent {
                docker { 
                    image 'jenkins/inbound-agent-with-maven' 
                    ports '1234:1234'
                    }
            }
            steps {
                // checkout source code from Github
                checkout scm

                sh 'ls -lrt'

                // build
                sh 'mvn package'

                // package
                sh 'java -jar ./target/simpleApp.jar'
            }
        }
    }
}