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

                             }
                         }

                    }
        }

          stage ('Cucumber Reports'){
                 steps{
                       cucumber buildStatus: "UNSTABLE",
                       fileIncludePattern:"**/*.json",
                       jsonReportDirectory: 'target'
                 }
          }


        post {
            always {
                emailext body: 'A Test EMail - Ignore email', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
                ${FILE,path="target/cucumber/index.html"} <script> ${FILE,path="target/cucumber/formatter.js"} </script> <script> ${FILE,path="target/cucumber/jquery-1.8.2.min.js"} </script> <script> ${FILE,path="target/cucumber/report.js"} </script> <style> ${FILE,path="target/cucumber/style.css"} </style>
            }
        }

    }
}