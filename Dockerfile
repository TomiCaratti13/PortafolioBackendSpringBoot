# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM amazoncorretto:8-alpine-jdk

MAINTAINER TRC

COPY target/trc-0.0.1-SNAPSHOT.jar trc-app.jar

ENTRYPOINT ["java","-jar","/trc-app.jar"]