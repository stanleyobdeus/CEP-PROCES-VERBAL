node{
  def app
  
  stage('Clone'){
    checkout scm
  }
  
  stage('Build image'){
    app= docker.build("cep-back-end")
  }
  
  stage("Run image"){
    
    docker.image('cep-back-end').withRun('-p 8080:8080'){ c->
      sh 'docker ps'
      sh 'curl localhost'
      
    }
  }

}
