node {

    stage('Git clone configuration-service') {
          git 'https://github.com/TheLibraryGroup/configuration-service.git'
        }

        stage('Maven package'){
            def mvnHome = tool name: 'maven', type: 'maven'
            sh "${mvnHome}/bin/mvn -f pom.xml package"
        }

        stage('SSH publisher configuration-service'){
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
                                remoteDirectory: '/docker/thelibrary-group/build',
                                remoteDirectorySDF: false,
                                removePrefix: '',
                                sourceFiles: 'configuration-service-0.0.1-SNAPSHOT.jar'
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
                                remoteDirectory: '/docker/thelibrary-group/build',
                                remoteDirectorySDF: false,
                                removePrefix: '',
                                sourceFiles: 'Dockerfile-configuration'
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

    stage('Git clone discovery-service') {
              git 'https://github.com/TheLibraryGroup/discovery-service.git'
        }

        stage('Maven package'){
            def mvnHome = tool name: 'maven', type: 'maven'
            sh "${mvnHome}/bin/mvn -f pom.xml package"
        }

        stage('SSH publisher discovery-service'){
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
                                remoteDirectory: '/docker/thelibrary-group/build',
                                remoteDirectorySDF: false,
                                removePrefix: '',
                                sourceFiles: 'discovery-service-0.0.1-SNAPSHOT.jar'
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
                                remoteDirectory: '/docker/thelibrary-group/build',
                                remoteDirectorySDF: false,
                                removePrefix: '',
                                sourceFiles: 'Dockerfile-discovery'
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

    stage('Git clone gateway-service') {
              git 'https://github.com/TheLibraryGroup/gateway-service.git'
        }

        stage('Maven package'){
            def mvnHome = tool name: 'maven', type: 'maven'
            sh "${mvnHome}/bin/mvn -f pom.xml package"
        }

        stage('SSH publisher gateway-service'){
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
                                remoteDirectory: '/docker/thelibrary-group/build',
                                remoteDirectorySDF: false,
                                removePrefix: '',
                                sourceFiles: 'gateway-service-0.0.1-SNAPSHOT.jar'
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
                                remoteDirectory: '/docker/thelibrary-group/build',
                                remoteDirectorySDF: false,
                                removePrefix: '',
                                sourceFiles: 'Dockerfile-gateway'
                            )
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


    stage('Git clone monitoring-service') {
              git 'https://github.com/TheLibraryGroup/monitoring-service.git'
        }

        stage('Maven package'){
            def mvnHome = tool name: 'maven', type: 'maven'
            sh "${mvnHome}/bin/mvn -f pom.xml package"
        }

        stage('SSH publisher monitoring-service'){
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
                                remoteDirectory: '/docker/thelibrary-group/build',
                                remoteDirectorySDF: false,
                                removePrefix: '',
                                sourceFiles: 'monitoring-service-0.0.1-SNAPSHOT.jar'
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
                                remoteDirectory: '/docker/thelibrary-group/build',
                                remoteDirectorySDF: false,
                                removePrefix: '',
                                sourceFiles: 'Dockerfile-monitoring'
                            )
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

    stage('Git clone dashboard-service') {
                  git 'https://github.com/TheLibraryGroup/dashboard-service.git'
            }

            stage('Maven package'){
                def mvnHome = tool name: 'maven', type: 'maven'
                sh "${mvnHome}/bin/mvn -f pom.xml package"
            }

            stage('SSH publisher dashboard-service'){
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
                                    remoteDirectory: '/docker/thelibrary-group/build',
                                    remoteDirectorySDF: false,
                                    removePrefix: '',
                                    sourceFiles: 'dashboard-service-0.0.1-SNAPSHOT.jar'
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
                                    remoteDirectory: '/docker/thelibrary-group/build',
                                    remoteDirectorySDF: false,
                                    removePrefix: '',
                                    sourceFiles: 'Dockerfile-dashboard'
                                )
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

    stage('Git clone book-service') {
             git 'https://github.com/TheLibraryGroup/microservice-book.git'
        }

        stage('Maven package'){
            def mvnHome = tool name: 'maven', type: 'maven'
            sh "${mvnHome}/bin/mvn -f pom.xml package"
        }

        stage('SSH publisher book-service'){
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
                                remoteDirectory: '/docker/thelibrary-group/build',
                                remoteDirectorySDF: false,
                                removePrefix: '',
                                sourceFiles: 'microservice-book-0.0.1-SNAPSHOT.jar'
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
                                remoteDirectory: '/docker/thelibrary-group/build',
                                remoteDirectorySDF: false,
                                removePrefix: '',
                                sourceFiles: 'Dockerfile-book'
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
          git 'https://github.com/TheLibraryGroup/angular-app.git'
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
                                remoteDirectory: '/docker/thelibrary-group/build/angular-app',
                                remoteDirectorySDF: false,
                                removePrefix: '',
                                sourceFiles: '**/*'
                            ),
                            sshTransfer(
                                cleanRemote: false,
                                excludes: '',
                                execCommand: 'cp /etc/letsencrypt/live/jenkins.mypoc.online/fullchain.pem /opt/docker/thelibrary-group/build/angular-app/ssl/fullchain.pem && cp /etc/letsencrypt/live/jenkins.mypoc.online/privkey.pem /opt/docker/thelibrary-group/build/angular-app/ssl/privkey.pem',
                                execTimeout: 300000,
                                flatten: false,
                                makeEmptyDirs: false,
                                noDefaultExcludes: false,
                                patternSeparator: '[, ]+',
                                remoteDirectory: '/docker/thelibrary-group/',
                                remoteDirectorySDF: false,
                                removePrefix: '',
                                sourceFiles: ''
                            ),
                        ],
                        usePromotionTimestamp: false,
                        useWorkspaceInPromotion: false,
                        verbose: false
                    )
                ]
            )
        }

    stage('Git clone docker-compose') {
             git 'https://github.com/TheLibraryGroup/docker.git'
        }

        stage('SSH publisher docker-compose'){
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
                                remoteDirectory: '/docker/thelibrary-group/',
                                remoteDirectorySDF: false,
                                removePrefix: '',
                                sourceFiles: 'docker-compose.yml'
                            ),
                            sshTransfer(
                                cleanRemote: false,
                                excludes: '',
                                execCommand: '',
                                execTimeout: 120000,
                                flatten: false,
                                makeEmptyDirs: false,
                                noDefaultExcludes: false,
                                patternSeparator: '[, ]+',
                                remoteDirectory: '/docker/thelibrary-group/sh',
                                remoteDirectorySDF: false,
                                removePrefix: '',
                                sourceFiles: 'sh/wait-for-it.sh'
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

}
