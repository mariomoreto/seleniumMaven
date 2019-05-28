pipeline{
    agent any
    parameters{
            choice(
                        choices: ['todos', 'login', 'upload'],
                    description: 'Escolha qual teste deseja executar.',
                    name: 'TAG')
    }
    stages{
        stage('Checkout'){
            steps{
                    git 'https://github.com/mariomoreto/seleniumMaven.git/'
                }
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