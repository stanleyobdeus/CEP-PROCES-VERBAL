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
    
        sh 'docker run -p 8181:8181 cep-back-end'
  }

}
