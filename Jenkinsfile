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
        bat 'echo "test"'
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