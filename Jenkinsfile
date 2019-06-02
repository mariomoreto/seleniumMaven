pipeline{
    agent any
    parameters{choice(choices: ['todos', 'login', 'upload'], description: '', name: 'TAG')}
    stages{
        stage ('Checkout'){
            checkout([$class: 'GitSCM', branches: [[name: '*/R0-TestJenkins']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/mariomoreto/seleniumMaven.git']]])
        }
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
                                     if(params.TAG=='todos')
                                     {
                                        bat 'mvn test'
                                     }else{
                                        bat 'mvn test -Dcucumber.options='--tags ${params.TAG}''
                                     }
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
    }
}