pipeline {
    agent any
    stages {
        stage("Compile") {
            steps {
                sh "./mvnw clean compile"
            }
        }
        stage("Unit test") {
            steps {
                sh "./mvnw test"
            }
        }
    }
}