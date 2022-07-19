pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11'
            args '-v /root/.m2:/root/.m2'
        }
    stages {
        stage("Compile") {
            steps {
                sh "mvn -B -DskipTests clean package"
            }
        }
        stage("Unit test") {
            steps {
                sh "mvn test"
            }
        }
    }
}