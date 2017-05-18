pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat(script: 'gradle clean build', returnStatus: true)
      }
    }
    stage('Test') {
      steps {
        bat(script: 'gradle test', returnStatus: true)
      }
    }
    stage('CodeAnalytic') {
      steps {
        bat 'echo "sonar"'
      }
    }
    stage('Deploy') {
      steps {
        bat 'echo "Deploy UAT"'
      }
    }
  }
}