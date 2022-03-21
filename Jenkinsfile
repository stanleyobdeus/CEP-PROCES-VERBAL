node{
  def app
  
  stage('Clone'){
    checkout scm
  }
  
  stage('Maven '){
    sh 'mvn clean package -DskipTests'
  }
  
  stage('Build image'){
    app= docker.build("cep-back-end")
  }
  
  stage("Run image"){
        sh 'docker container rm cep-back-end --force'
    
        sh 'docker run --network oni --name cep-back-end -p 8181:8181 -d cep-back-end'
  }

}
