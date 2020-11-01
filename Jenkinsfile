pipeline{
   agent any
   stages {
        stage('Git') {
            steps {
                echo "Getting Project from Git";
                git "https://github.com/Sam8892/timesheet.git";
            }
        }
        
         stage('Clean') {
            steps {
                echo "Maven Tests";
                bat "mvn clean";
            }
        }
        
        stage('Tests') {
            steps {
                echo "Maven Tests";
                bat "mvn test";
            }
        }
         stage('Sonar') {
            steps {
                echo "Sonar";
                bat "mvn sonar:sonar";
            }
        }
        stage('Compile') {
            steps {
                echo "Compile";
                bat "mvn compile";
            }
        }
        stage('Package') {
            steps {
                echo "Package";
                bat "mvn package";
            }
        }
       stage('Deploiement') {
            steps {
                echo "deploying the code";
                bat "mvn clean package deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=timesheet -Dversion=1.2 -DgeneratePom=true -Dpackaging=jar  -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet-1.2.jar";
            }
        }
        
    }
   
}
