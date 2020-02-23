# Tradutor de Números Inteiros

Consiste em traduzir um número inteiro entre -99999 e 99999 
para 0 português, escrito por extenso.

Este projeto usar Quarkus, o Supersonic Subatomic Framework Java

Para conhecer mais sobre o Quarkus, visite o website: https://quarkus.io/ .

## Rodando o programa em modo desenvolvimento

```
./mvnw quarkus:dev
```

## Empacotar 

```
./mvnw package
```

O camando cria o executável `traduzir-numero-1.0-SNAPSHOT-runner.jar` 
localizado no diretório `/target`.

Este não é um _über-jar_ as dependencias são copiadas para o diretório `target/lib`.

## Executando

```
java -jar target/traduzir-numero-1.0-SNAPSHOT-runner.jar
```

# Criando Aplicação nativa

O Quarkus permite compilar de forma nativa a aplicação usando o GraalVM.
A compilação nativa tem a vantagem de subir o serviço de forma muito mais rápida que JVM padrão do Java,
para isto você precisa baixar inicialmente o VM do Graal:

###Linux
Download: https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.0.0/graalvm-ce-java8-linux-amd64-20.0.0.tar.gz

###Windows
Download: https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-20.0.0/graalvm-ce-java8-windows-amd64-20.0.0.zip


## Criando um executável nativo

```
export GRAALVM_HOME=graalvm/graalvm-latest
export JAVA_HOME=${GRAALVM_HOME}
./mvnw package -Pnative
```

## Criando um container Docker com o executável nativo

```
export GRAALVM_HOME=graalvm/graalvm-latest
export JAVA_HOME=${GRAALVM_HOME}
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

## Executando o binário nativo

```
./target/traduzir-numero-1.0-SNAPSHOT-runner
```

## Script para preparar compilar nativo

No diretório raiz existe o script shell `compile-native.sh`, execute o script para compilar
de forma nativa o executável.

Não esqueça de alterar a variável `GRAALVM_HOME` dentro do arquivo, apontando para o local
onde foi feito o download e descompactado.

Para saber mais sobre criar executáveis nativos consulte o website: https://quarkus.io/guides/building-native-image-guide .


# Comparação entre um Container criado com Quarkus e outro com o Jar comum

## Quarkus

**started in 1.616s.**

```
docker run -p 3000:3000 quarkus/traduzir-numero-jvm

exec java -Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager -XX:+UseParallelGC -XX:GCTimeRatio=4 -XX:AdaptiveSizePolicyWeight=90 -XX:MinHeapFreeRatio=20 -XX:MaxHeapFreeRatio=40 -XX:+ExitOnOutOfMemoryError -cp . -jar /deployments/app.jar
2020-02-23 21:35:21,601 INFO  [io.quarkus] (main) traduzir-numero 1.0-SNAPSHOT (running on Quarkus 1.2.1.Final) started in 1.616s. Listening on: http://0.0.0.0:3000
2020-02-23 21:35:21,604 INFO  [io.quarkus] (main) Profile prod activated. 
2020-02-23 21:35:21,605 INFO  [io.quarkus] (main) Installed features: [cdi, resteasy, resteasy-jackson]
```

## JVM Java com Spring Boot

**Started NumextensoApplication in 3.482 seconds (JVM running for 4.24)**

```
docker run -p 3000:3000 bucker/traduzir-numero-jvm

exec java -XX:+UseParallelGC -XX:GCTimeRatio=4 -XX:AdaptiveSizePolicyWeight=90 -XX:MinHeapFreeRatio=20 -XX:MaxHeapFreeRatio=40 -XX:+ExitOnOutOfMemoryError -cp . -jar /deployments/app.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.4.RELEASE)

2020-02-23 21:37:35.533  INFO 1 --- [           main] b.c.b.numextenso.NumextensoApplication   : Starting NumextensoApplication v0.0.1-SNAPSHOT on 34c2eda5f176 with PID 1 (/deployments/app.jar started by ? in /deployments)
2020-02-23 21:37:35.539  INFO 1 --- [           main] b.c.b.numextenso.NumextensoApplication   : No active profile set, falling back to default profiles: default
2020-02-23 21:37:37.521  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 3000 (http)
2020-02-23 21:37:37.543  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-02-23 21:37:37.543  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.30]
2020-02-23 21:37:37.630  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2020-02-23 21:37:37.630  INFO 1 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1973 ms
2020-02-23 21:37:37.966  INFO 1 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-02-23 21:37:38.286  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 3000 (http) with context path ''
2020-02-23 21:37:38.291  INFO 1 --- [           main] b.c.b.numextenso.NumextensoApplication   : Started NumextensoApplication in 3.482 seconds (JVM running for 4.24)
```
