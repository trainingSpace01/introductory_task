FROM openjdk:23
ARG JAR_FILE=company_service/target/company_service-1.0.jar
COPY ${JAR_FILE} company_service.jar
ENTRYPOINT ["java", "-jar", "/company_service.jar"]