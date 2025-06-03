FROM openjdk:23
ARG JAR_FILE=employee_service/target/employee_service-1.0.jar
COPY ${JAR_FILE} employee_service.jar
ENTRYPOINT ["java", "-jar", "/employee_service.jar"]