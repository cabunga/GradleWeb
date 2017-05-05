pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat 'echo "Build"'
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
        bat '"Deploy UAT"'
      }
    }
  }
}