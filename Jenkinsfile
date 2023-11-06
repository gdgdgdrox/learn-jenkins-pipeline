pipeline {
    stages {
        stage('Build') {
            agent {
                docker { image 'jenkins/inbound-agent-with-maven' }
            }
            steps {
                // checkout source code from Github
                sh 'git pull ...'

                sh 'ls -lrt'

                // build
                sh 'mvn package'

                // package
                sh 'java -jar ./target/simpleApp.jar'
            }
        }
        // stage('Deploy') {
        //     agent {
        //         docker { image 'node:20.9.0-alpine3.18' }
        //     }
        //     steps {
        //         sh 'node --version'
        //     }
        // }
    }
}