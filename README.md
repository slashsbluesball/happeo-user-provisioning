# happeo-user-provisioning

## About
This repository contains a Proof of Concept application for Happeo user provisiong feature

When a new user is created in the external identity system, it POSTs user data into the
users endpoint of configured targets (similar to a webhook). The external identity
system pushes users to the target system one at a time on an endpoint using a schema it
defines.

## Used technology
Application uses Java 17 with Spring boot framework to expose the REST API.
Mongo DB servers as a database and its build by maven. 
Application and its database is fully dockerized.

## Prerequisites
- Java 17
- maven
- docker + docker-compose


## Local development
To run or develop the application locally you need a running mongodb container. 
Then you can build and start the application from your IDE or command line.

Reach the [welcome page](http://localhost:8080/api/msg/hello) via web browser.


```
$ docker run -d -p 27017:27017 --name demo2-mongodb-local mongo:latest
9ccd2ecbf3db2ea77da75190f93112ec896061368da10c93f7a44c6e3b64d64f
$ docker ps
CONTAINER ID   IMAGE          COMMAND                  CREATED       STATUS       PORTS                                           NAMES
9ccd2ecbf3db   mongo:latest   "docker-entrypoint.s…"   2 hours ago   Up 2 hours   0.0.0.0:27017->27017/tcp, :::27017->27017/tcp   demo2-mongodb-local
$
```

You can stop and start DB container and the data will persist. If you need to fully wipe the DB and start from scratch, you can stop and delete the container.
```
$ docker stop demo2-mongodb-local 
demo2-mongodb-local
$ docker start demo2-mongodb-local 
demo2-mongodb-local
$

$ docker stop demo2-mongodb-local 
demo2-mongodb-local
$ docker rm demo2-mongodb-local 
demo2-mongodb-local
$ docker ps -a
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES
$
```


## Build and run
You can build compiled jar file using maven in your IDE or from command line.

These commands will compile the code and generate .jar file in target directory.

```
$ mvn wrapper:wrapper
$ ./mvnw clean install

...
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 8.499 s - in com.happeo.userprovisioning.demo2api.Demo2ApiApplicationTests
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] 
[INFO] --- maven-jar-plugin:3.3.0:jar (default-jar) @ demo2-api ---
[INFO] Building jar: /home/svasuada/git-repos/happeo-user-provisioning/demo2-api/demo2-api/target/demo2-api-0.0.1-SNAPSHOT.jar
[INFO] 
[INFO] --- spring-boot-maven-plugin:3.0.6:repackage (repackage) @ demo2-api ---
[INFO] Replacing main artifact with repackaged archive
[INFO] 
[INFO] --- maven-install-plugin:3.0.1:install (default-install) @ demo2-api ---
[INFO] Installing /home/svasuada/git-repos/happeo-user-provisioning/demo2-api/demo2-api/pom.xml to /home/svasuada/.m2/repository/com/happeo/userprovisioning/demo2-api/0.0.1-SNAPSHOT/demo2-api-0.0.1-SNAPSHOT.pom
[INFO] Installing /home/svasuada/git-repos/happeo-user-provisioning/demo2-api/demo2-api/target/demo2-api-0.0.1-SNAPSHOT.jar to /home/svasuada/.m2/repository/com/happeo/userprovisioning/demo2-api/0.0.1-SNAPSHOT/demo2-api-0.0.1-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  20.896 s
[INFO] Finished at: 2023-05-19T17:12:44+03:00
[INFO] ------------------------------------------------------------------------
$ 
$ ls target/demo2-api-0.0.1-SNAPSHOT.jar
target/demo2-api-0.0.1-SNAPSHOT.jar
$
```

This jar file will be start an application and expose on [http://localhost:8080](http://localhost:8080).
```
$ java -jar target/demo2-api-0.0.1-SNAPSHOT.jar 

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.6)


...
```


## Docker compose
Alternativelly you can build the and spin up release version of an application using docker compose.

You need to build a compiled jar file as described above.
This jar file will be used to build an application docker image.

```
$ mvn wrapper:wrapper
$ ./mvnw clean install 
$ ls target/demo2-api-0.0.1-SNAPSHOT.jar
target/demo2-api-0.0.1-SNAPSHOT.jar
$

```

When jar file is build, you can build and run the stack by docker compose and access the [welcome page](http://localhost:8080/api/msg/hello) via web browser.
You can stop and start the stack for data to survive or cleanup completely by docker compose down command.

```
$ docker compose build --no-cache
$ docker compose up -d
[+] Running 3/3
 ✔ Network demo2-api_default  Created
 ✔ Container demo2-mongodb    Started
 ✔ Container demo2-api        Started  
$
$ docker ps
CONTAINER ID   IMAGE             COMMAND                  CREATED         STATUS         PORTS                                           NAMES
1d8d4b4f91f1   demo2api:latest   "/bin/sh -c 'exec ja…"   6 minutes ago   Up 6 minutes   0.0.0.0:8080->8080/tcp, :::8080->8080/tcp       demo2-api
dd2356cbc7fe   mongo:latest      "docker-entrypoint.s…"   6 minutes ago   Up 6 minutes   0.0.0.0:27017->27017/tcp, :::27017->27017/tcp   demo2-mongodb
$

$ docker compose stop
$ docker ps -a
CONTAINER ID   IMAGE             COMMAND                  CREATED          STATUS                            PORTS     NAMES
bb98add2a54b   demo2api:latest   "/bin/sh -c 'exec ja…"   2 minutes ago    Exited (143) About a minute ago             demo2-api
4d366069620a   mongo:latest      "docker-entrypoint.s…"   2 minutes ago    Exited (0) About a minute ago               demo2-mongodb
$
$ docker compose start
$ docker compose down
[+] Running 3/3
 ✔ Container demo2-api        Removed
 ✔ Container demo2-mongodb    Removed
 ✔ Network demo2-api_default  Removed
$
```

## REST API usage
You can use web browser to verify the [welcome page](http://localhost:8080/api/msg/hello) is working but for other usecases Postman or curl might be more useful.

Currently implemented endpoints you can see in built-in [swagger UI](http://localhost:8080/swagger-ui/index.html)
- GET /api/msg/hello
- GET /api/organisation/{orgId}/users
- POST /api/organisation/{orgId}/provisioner/{provId}/users
- POST /api/organisation/{orgId}/provisioner/{provId}/users


## TODO list
Missing features are:
- JWT Token authentication implementation
- Connection to DB broken in docker-compose deployment (WiP: to be tested)
