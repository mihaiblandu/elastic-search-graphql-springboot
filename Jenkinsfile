pipeline {
  agent any
  stages {
    stage('System') {
      steps {
        sh 'cat ./mvnw'
        sh 'echo $HOME;'
        sh 'docker --version;'
        sh 'java -version'
        sh 'ls -la'
        sh './mvnw clean install'
      }
    }

    stage('Build') {
      steps {
        sh 'ls -la'
        sh './mvnw install'
        archiveArtifacts(artifacts: '**/target/*.jar', fingerprint: true)
      }
    }

    stage('Deploy') {
      parallel {
        stage('Deploy') {
          steps {
            sh 'ls ./target/*.jar'
            sh './mvnw test'
            echo 'Deploying...'
          }
        }

        stage('Docker') {
          steps {
            sh 'docker ps -a'
          }
        }

      }
    }

    stage('Final Step') {
      steps {
        sh 'echo "Some crap goes here"'
      }
    }

  }
  triggers {
    pollSCM('* * * * *')
  }
}