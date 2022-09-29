pipeline {
  agent any

  environment {
    // git will be available in entire pipeline
    git = "PIPELINE"
  }

  stages {
    stage("local") {
      environment {
        // BAR will only be available in this stage
        demo = "STAGE"
      }
      steps {
        sh 'echo "git is $git and demo is $demo"'
      }
    }
    stage("global") {
      steps {
          sh 'echo "git is $git and demo is $demo"'
      }
    }
  }
}
