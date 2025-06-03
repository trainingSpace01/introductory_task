FROM openjdk:23
ARG JAR_FILE=eureka_service/target/eureka_service-1.0.jar
COPY ${JAR_FILE} eureka_service.jar
ENTRYPOINT ["java", "-jar", "/eureka_service.jar"]