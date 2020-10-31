node{
   stage('git'){
      git 'https://github.com/Sam8892/timesheet.git'
   }
   stage('Compile-Package'){
      def mvnHome= tool name: 'maven-3', type: 'maven'
      sh "${mvnHome}/bin/mvn package"
   }
   
}
