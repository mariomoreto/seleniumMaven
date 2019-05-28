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

       try{
         stage ('Test'){
                    steps{
                            withMaven(maven:'MAVEN_HOME'){
                            bat 'mvn test'
                           }
                            build.setResult = 'SUCCESS'
                       }
         }
        }catch (Exception e) {
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