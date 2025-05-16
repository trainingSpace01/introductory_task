FROM openjdk:23
ARG JAR_FILE=target/SpringBootRestService-1.0.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]