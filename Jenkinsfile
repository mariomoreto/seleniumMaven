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
                        script{
                            try{
                                 withMaven(maven:'MAVEN_HOME'){
                                   bat 'mvn test'
                                 }

                            } catch (err) {
                                echo err
                             }
                         }
                         echo currentBuild.result
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