pipeline {
    agent none
    stages {
        stage('Build') {
            agent {
                dockerContainer { 
                    image 'gdgdgdrox94/gd-image:jenkins-inbound-agent-with-maven'
                    }
            }
            steps {
                // checkout source code from Github
                checkout scm

                // build
                sh 'mvn package'

                // stash
                stash includes: 'target/*.jar', name: 'myjar'
            }
        }
        stage ('Run ls'){
            agent any
            steps {
                 unstash 'myjar'

                 sh 'ls -lrt'
            }
        }
    }
}
