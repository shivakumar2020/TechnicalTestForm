pipeline {
     agent any
    stages {
        stage('Checkout') {
            steps {
                 git url: 'https://github.com/shivakumar2020/TechnicalTestForm.git',branch: 'main'
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
			archiveArtifacts artifacts: 'reports/AutomatonReport.html', allowEmptyArchive: true
            junit 'target/surefire-reports/*.xml'
            publishHTML (target : [allowMissing: false,
 				alwaysLinkToLastBuild: true,
 				keepAll: true,
				 reportDir: 'reports',
 				reportFiles: 'AutomationReport.html',
			    reportName: 'TestAutoamtion',
 				reportTitles: 'TTest Automation Report']) 
        }
    }
}