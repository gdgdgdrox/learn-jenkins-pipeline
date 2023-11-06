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

                sh 'ls -lrt'

                // build
                sh 'mvn package'

                // package
                script {
                    def container = docker.image('gdgdgdrox94/gd-image:jenkins-inbound-agent-with-maven').run('-p 1234:1234', '-d')
                    try {
                        sh "docker exec ${container.id} java -jar ./target/simpleApp.jar"
                    } finally {
                        container.stop()
                    }
                }
            }
        }
    }
}
