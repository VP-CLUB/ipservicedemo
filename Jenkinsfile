#!/usr/bin/groovy
def failIfNoTests = ""
try {
  failIfNoTests = ITEST_FAIL_IF_NO_TEST
} catch (Throwable e) {
  failIfNoTests = "false"
}

def localItestPattern = ""
try {
  localItestPattern = ITEST_PATTERN
} catch (Throwable e) {
  localItestPattern = "*KT"
}


def versionPrefix = ""
try {
  versionPrefix = VERSION_PREFIX
} catch (Throwable e) {
  versionPrefix = "1.0"
}

def canaryVersion = "${versionPrefix}.${env.BUILD_NUMBER}"

node {
  git 'http://gogs.fabric8.172.16.5.60.nip.io/gogsadmin/ipservice.git'

  echo 'NOTE: running pipelines for the first time will take longer as build and base docker images are pulled onto the node'
  kubernetes.pod('buildpod').withImage('vpclub/maven-builder:1.0.0')
          .withPrivileged(true)
          .withHostPathMount('/var/run/docker.sock','/var/run/docker.sock')
          .withEnvVar('DOCKER_CONFIG','/home/jenkins/.docker/')
          .withEnvVar('KUBERNETES_MASTER','kubernetes.default')
          .withSecret('jenkins-docker-cfg','/home/jenkins/.docker')
          .withSecret('jenkins-maven-settings','/root/.m2')
          .withServiceAccount('jenkins')
          .inside {

    stage 'Deploy'
    sh 'mvn clean install -U org.apache.maven.plugins:maven-deploy-plugin:2.8.2:deploy'
  }
}
