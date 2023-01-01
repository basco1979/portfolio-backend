FROM amazoncorretto:8-alpine-jdk
COPY target/Portfolio-0.0.1-SNAPSHOT.jar  Portfolio-0.0.1-SNAPSHOT.jar 
ENTRYPOINT ["java", "-jar", "/Portfolio-0.0.1-SNAPSHOT.jar"]
