pipeline{
    agent any 
    stages {
        stage('pull'){
            steps{
                git branch: 'dev', url: 'https://github.com/GH-Tejal/3tier-frontend.git'
            }
        }
        stage('build'){
            steps{
                sh '''
                    npm install
                    ng build 
                '''
            }
        }
        stage('deploy'){
            steps{
                sh '''
                    aws s3 cp --recursive dist/angular-frontend s3://new-cbz-frontend-project-bux
                '''
            }
        }
    }
}