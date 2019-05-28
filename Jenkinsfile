pipeline{
    agent any
    stages{
        stage ('Compile'){
            steps{
                withMaven(maven:'MAVEN_HOME'){
                    bat 'mvn clean compile'
                }
            }
        }

         stage ('Test'){
                    steps{
                        withMaven(maven:'MAVEN_HOME'){
                            bat 'mvn test'
                        }
                    }
         }

         stage ('Cucumber Reports'){
            steps{
                cucumber buildStatus: "UNSTABLE",
                fileIncludePattern:"**/cucumber.json",
                jsonReportDirectory: 'target'
            }
         }
    }
}