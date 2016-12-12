#!/usr/bin/groovy
def localItestPattern = ""
try {
  localItestPattern = ITEST_PATTERN
} catch (Throwable e) {
  localItestPattern = "*KT"
}

def localFailIfNoTests = ""
try {
  localFailIfNoTests = ITEST_FAIL_IF_NO_TEST
} catch (Throwable e) {
  localFailIfNoTests = "false"
}

def versionPrefix = ""
try {
  versionPrefix = VERSION_PREFIX
} catch (Throwable e) {
  versionPrefix = "1.4"
}

def canaryVersion = "${versionPrefix}.${env.BUILD_NUMBER}"

def fabric8Console = "${env.FABRIC8_CONSOLE ?: ''}"
def utils = new io.fabric8.Utils()

node {
  def envStage = utils.environmentNamespace('staging')
  def envProd = utils.environmentNamespace('production')

  git 'http://gogs.fabric8.172.16.5.60.nip.io/gogsadmin/ipservice.git'

  echo 'NOTE: running pipelines for the first time will take longer as build and base docker images are pulled onto the node'
  kubernetes.pod('buildpod').withImage('vpclub/maven-builder:1.0.6')
          .withPrivileged(true)
          .withHostPathMount('/var/run/docker.sock', '/var/run/docker.sock')
          .withEnvVar('DOCKER_CONFIG', '/home/jenkins/.docker/')
          .withEnvVar('KUBERNETES_MASTER', 'kubernetes.default')
          .withSecret('jenkins-docker-cfg', '/home/jenkins/.docker')
          .withSecret('jenkins-maven-settings', '/root/.m2')
          .withServiceAccount('jenkins')
          .inside {

    stage 'Canary Release'

    version = canaryVersion
    // evaluate the body block, and collect configuration into the object
    def config = [:]

    def flow = new io.fabric8.Fabric8Commands()

    sh "git checkout -b ${env.JOB_NAME}-${config.version}"
    sh "mvn org.codehaus.mojo:versions-maven-plugin:2.2:set -U -DnewVersion=${config.version}"
    sh "mvn clean -e -U deploy -DskipTests"

    def s2iMode = flow.isOpenShiftS2I()
    echo "s2i mode: ${s2iMode}"

    if (flow.isSingleNode()) {
      echo 'Running on a single node, skipping docker push as not needed'
      def m = readMavenPom file: 'pom.xml'
      def groupId = m.groupId.split('\\.')
      def user = groupId[groupId.size() - 1].trim()
      def artifactId = m.artifactId

      if (!s2iMode) {
        kubernetes.image().withName("${user}/${artifactId}:${config.version}").tag().inRepository("${env.FABRIC8_DOCKER_REGISTRY_SERVICE_HOST}:${env.FABRIC8_DOCKER_REGISTRY_SERVICE_PORT}/${user}/${artifactId}").withTag("${config.version}")
      }
    } else {
      if (!s2iMode) {
        retry(3) {
          sh "mvn fabric8:push -Ddocker.push.registry=${env.FABRIC8_DOCKER_REGISTRY_SERVICE_HOST}:${env.FABRIC8_DOCKER_REGISTRY_SERVICE_PORT}"
        }
      }
    }

    if (flow.hasService("content-repository")) {
      try {
        sh 'mvn site site:deploy -DskipTests'
      } catch (err) {
        // lets carry on as maven site isn't critical
        echo 'unable to generate maven site'
      }
    } else {
      echo 'no content-repository service so not deploying the maven site report'
    }
  }
}


