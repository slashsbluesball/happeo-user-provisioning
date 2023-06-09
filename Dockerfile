FROM openjdk:17-jdk-alpine
VOLUME /tmp

ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS

COPY target/demo2-api-0.0.1-SNAPSHOT.jar demo2api.jar

EXPOSE 8080
# ENTRYPOINT exec java $JAVA_OPTS -jar demo2api.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar demo2api.jar
