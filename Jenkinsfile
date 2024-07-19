pipeline {
     agent {label 'any'}
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/shivakumar2020/TechnicalTestForm.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'reports/*.html', allowEmptyArchive: true
            junit 'target/surefire-reports/*.xml'
        }
    }
}