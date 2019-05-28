pipeline{
    agent any
    stages{
        stage ('Compile'){
            steps{
                withMaven(maven:'maven_3_5_0'){
                    sh 'mvn clean install'
                }
            }
        }

         stage ('Test'){
                    steps{
                        withMaven(maven:'maven_3_5_0'){
                            sh 'mvn test'
                        }
                    }
         }
    }
}