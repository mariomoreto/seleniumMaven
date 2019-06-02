pipeline{
    agent any
    parameters{
      choice(
            name:'typeTest',
            choices:'todos\nlogin\nupload',
            description:'What test do you wanna execute?'
        )
    }
    stages{
        stage ('Compile'){
            steps{
                withMaven(maven:'MAVEN_HOME'){
                    bat 'mvn clean compile'
                }
            }
        }

        stage('Executing Test'){
            steps{
                echo "Executing test: ${params.typeTest}"
                script{
                        try{
                            withMaven(maven:'MAVEN_HOME'){
                                if(params.typeTest=='todos'){
                                          bat 'mvn test'
                                }else{
                                          bat "mvn test -Dcucumber.options=\"--tags @${params.typeTest}\""
                                }
                            }
                        }catch(err){
                            echo "Ocorreu um erro ao executar o test"
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
    }
}