pipeline {
  agent any
  environment {
    DOCKERHUB_CREDS = credentials('dockerhub')
  }
  stages {
    stage('Clone Repo'){
      steps{
        echo 'Copy Repository...'
        checkout scmGit(branches: [[name: '*/dev']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/fitrianinasir/SampleCode-for-Pipeline-testing']])
        sh 'ls *'
      }
    }
    stage('Build Image'){
      steps {
        echo 'Start building the image...'
        sh 'docker build -t fitrianinasir/first-docker:$BUILD_NUMBER ./target/'
      }
    }
    stage('Docker Login'){
      steps{
        echo 'Start login...'
        sh 'echo $DOCKERHUB_CREDS_PSW | docker login -u $DOCKERHUB_CREDS_USR --password-stdin'
      }
    }
    stage('Docker Push'){
      steps{
        sh 'docker push fitrianinasir/first-docker:$BUILD_NUMBER'
      }
    }
  }
  post {
    always{
      sh 'docker logout'
    }
  }
}