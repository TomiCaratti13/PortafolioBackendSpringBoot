FROM amazoncorretto:11-alpine-jdk
MAINTAINER TRC
COPY target/trc-0.0.1-SNAPSHOT.jar trc-app.jar
ENTRYPOINT ["java","-jar","/trc-app.jar"]
