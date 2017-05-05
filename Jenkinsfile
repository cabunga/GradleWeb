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
        parallel(
          "CodeAnalytic": {
            bat 'echo "sonar"'
            
          },
          "Email": {
            echo 'Envio Correo'
            
          }
        )
      }
    }
    stage('Deploy') {
      steps {
        parallel(
          "Deploy": {
            bat 'echo "Deploy UAT"'
            
          },
          "Rollback": {
            echo 'En caso de Fallo'
            
          }
        )
      }
    }
  }
}