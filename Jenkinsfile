node {

    stage('Git clone backend') {
        git 'https://github.com/TheLibraryGroup/TheLibrary-backend.git'
    }
    
    stage('Maven package'){
        def mvnHome = tool name: 'maven', type: 'maven'
        sh "${mvnHome}/bin/mvn package"
    }
    
    stage('SSH publisher back'){
        sshPublisher(
            publishers: [
                sshPublisherDesc(
                    configName: 'vps778813.ovh.net', 
                    transfers: [
                        sshTransfer(
                            cleanRemote: false, 
                            excludes: '', 
                            execCommand: '', 
                            execTimeout: 120000, 
                            flatten: false, 
                            makeEmptyDirs: false, 
                            noDefaultExcludes: false, 
                            patternSeparator: '[, ]+', 
                            remoteDirectory: '/docker/thelibrary/build/back',
                            remoteDirectorySDF: false,
                            removePrefix: 'microservice/target',
                            sourceFiles: 'microservice/target/microservice-0.0.1-SNAPSHOT.jar'
                        ),
                        sshTransfer(
                            cleanRemote: false,
                            excludes: '',
                            execCommand: '',
                            execTimeout: 120000,
                            flatten: false,
                            makeEmptyDirs: false,
                            noDefaultExcludes: false,
                            patternSeparator: '[,]+',
                            remoteDirectory: '/docker/thelibrary/db',
                            remoteDirectorySDF: false,
                            removePrefix: 'microservice/src/main/resources/database', 
                            sourceFiles: 'microservice/src/main/resources/database/'
                        ),
                        sshTransfer(
                            cleanRemote: false,
                            excludes: '',
                            execCommand: '',
                            execTimeout: 120000,
                            flatten: false,
                            makeEmptyDirs: false,
                            noDefaultExcludes: false,
                            patternSeparator: '[,]+',
                            remoteDirectory: '/docker/thelibrary/build/back',
                            remoteDirectorySDF: false,
                            removePrefix: '', 
                            sourceFiles: 'Dockerfile'
                        ),
                        sshTransfer(
                            cleanRemote: false,
                            excludes: '',
                            execCommand: '',
                            execTimeout: 120000,
                            flatten: false,
                            makeEmptyDirs: false,
                            noDefaultExcludes: false,
                            patternSeparator: '[,]+',
                            remoteDirectory: '/docker/thelibrary',
                            remoteDirectorySDF: false,
                            removePrefix: '', 
                            sourceFiles: 'docker-compose.yml'
                        ),
                    ], 
                    usePromotionTimestamp: false, 
                    useWorkspaceInPromotion: false, 
                    verbose: false
                )
            ]
        )
    }
    
    stage('Clean workspace'){
        cleanWs()
    }
    
    
    stage('Git clone frontend') {
          git 'https://github.com/TheLibraryGroup/TheLibrary-frontend.git'
    }
    stage('SSH publisher front'){
        sshPublisher(
            publishers: [
                sshPublisherDesc(
                    configName: 'vps778813.ovh.net', 
                    transfers: [
                        sshTransfer(
                            cleanRemote: false, 
                            excludes: '', 
                            execCommand: '', 
                            execTimeout: 120000, 
                            flatten: false, 
                            makeEmptyDirs: false, 
                            noDefaultExcludes: false, 
                            patternSeparator: '[, ]+', 
                            remoteDirectory: '/docker/thelibrary/build/front', 
                            remoteDirectorySDF: false, 
                            removePrefix: '', 
                            sourceFiles: '**/*'
                        )
                    ], 
                    usePromotionTimestamp: false, 
                    useWorkspaceInPromotion: false, 
                    verbose: false
                )
            ]
        )
    }
    
    stage('SSH command docker run'){
        sshPublisher(
            publishers: [
                sshPublisherDesc(
                    configName: 'vps778813.ovh.net',
                    transfers: [
                        sshTransfer(
                            cleanRemote: false,
                            excludes: '',
                            execCommand: 'cp /etc/letsencrypt/live/jenkins.mypoc.online/fullchain.pem /opt/docker/thelibrary/build/front/ssl/fullchain.pem && cp /etc/letsencrypt/live/jenkins.mypoc.online/privkey.pem /opt/docker/thelibrary/build/front/ssl/privkey.pem',
                            execTimeout: 300000,
                            flatten: false,
                            makeEmptyDirs: false,
                            noDefaultExcludes: false,
                            patternSeparator: '[, ]+',
                            remoteDirectory: '/docker/thelibrary',
                            remoteDirectorySDF: false,
                            removePrefix: '',
                            sourceFiles: ''
                        ),
                        sshTransfer(
                            cleanRemote: false,
                            excludes: '',
                            execCommand: 'cd /opt/docker/thelibrary && docker-compose build',
                            execTimeout: 300000,
                            flatten: false,
                            makeEmptyDirs: false,
                            noDefaultExcludes: false,
                            patternSeparator: '[, ]+',
                            remoteDirectory: '/docker/thelibrary',
                            remoteDirectorySDF: false,
                            removePrefix: '',
                            sourceFiles: ''
                        ),
                        sshTransfer(
                            cleanRemote: false,
                            excludes: '',
                            execCommand: 'cd /opt/docker/thelibrary && docker-compose up -d',
                            execTimeout: 300000,
                            flatten: false,
                            makeEmptyDirs: false,
                            noDefaultExcludes: false,
                            patternSeparator: '[, ]+',
                            remoteDirectory: '/docker/thelibrary',
                            remoteDirectorySDF: false,
                            removePrefix: '',
                            sourceFiles: ''
                        )
                    ],
                    usePromotionTimestamp: false,
                    useWorkspaceInPromotion: false,
                    verbose: false
                )
            ]
        )
    }


}
