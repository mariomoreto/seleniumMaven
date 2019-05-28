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
                        try{
                            withMaven(maven:'MAVEN_HOME'){
                            bat 'mvn test'
                           }
                        }finally{
                             stage ('Cucumber Reports'){
                                         steps{
                                             cucumber buildStatus: "UNSTABLE",
                                             fileIncludePattern:"**/cucumber.json",
                                             jsonReportDirectory: 'target'
                                         }
                             }
                        }
                    }
         }


    }
}