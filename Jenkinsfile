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
    
    docker.image('cep-back-end').withRun('-p 8181:8181'){ c->
      sh 'docker ps'
      
    }
  }

}
