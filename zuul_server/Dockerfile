FROM openjdk:23
ARG JAR_FILE=zuul_server/target/gateway-1.0.jar
COPY ${JAR_FILE} gateway.jar
ENTRYPOINT ["java", "-jar", "/gateway.jar"]