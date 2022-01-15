pipeline {
    agent any

    stages {
        stage('Compile stage') {
            steps {
                withMaven(maven: 'maven_3_8_4') {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test stage') {
            steps {
                withMaven(maven: 'maven_3_8_4') {
                    sh 'mvn test'
                }
            }
        }

        stage('Test stage') {
            steps {
                cucumber buildStatus: "UNSTABLE",
                fileIncludePattern: "**/cucumber.json",
                jsonReportDirectory: 'target'
            }
        }

    }
}