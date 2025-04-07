pipeline {
    agent any
    options {
        timestamps()
    }
    environment {
        JAVA_HOME = '/usr/lib/jvm/java-21'
        PATH = "$JAVA_HOME/bin:$PATH"        
    }
    stages {
        stage('Compile Check') {
            steps{
                script {
                    def resp = sh(
                        script: 'mvn clean compile -DskipTests',
                        returnStdout: true
                    ) 
                    println 'resp: ' + resp
                }
            }
        }
        stage('Checkmarx AST Scanner') {
            steps {
                checkmarxASTScanner branchName: "${env.BRANCH_NAME}", 
                    checkmarxInstallation: 'CXAST CLI', 
                    projectName: 'azmex/servicios-comunes/arquetipo-nuevo-spring' 
                    /*
                        El valor de projectName se tiene que cambiar por el proyecto correspondiente
                        El valor de projectName se genera a partir de la url de git, es decir,
                            se toma el texto a partir de "azmex" hasta antes del ".git"
                        Ejemplo:
                            - url de git: https://gitlab.com/azmex/aplicaciones-internas/simuladores-web/sim-plus.git
                            - projectName: azmex/aplicaciones-internas/simuladores-web/sim-plus
                    */
            }
        }
    }
    post {
        always {
            node(null) {
                cleanWs()

                emailext (
                    subject: "${currentBuild.currentResult}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                    body: """<p>RESULT: ${currentBuild.currentResult}</p><p>JOB NAME: ${env.JOB_NAME}</p><p>BUILD NUMBER: ${env.BUILD_NUMBER}</p><p>CHECK CONSOLE OUTPUT AT: <a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>""",
                    to: '$DEFAULT_RECIPIENTS'
                )
            }
        }
    }
}
