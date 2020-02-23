#!/bin/bash
export GRAALVM_HOME=/home/bucker/Documentos/Aplicativos/graalvm/graalvm-latest
JAVA_HOME=${GRAALVM_HOME}

${GRAALVM_HOME}/bin/gu install native-image


#./mvnw package -Pnative
./mvnw package -Pnative -Dquarkus.native.container-build=true