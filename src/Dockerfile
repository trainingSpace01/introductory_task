FROM openjdk:23
ARG JAR_FILE=Introductory_task.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM postgres:16

# Устанавливаем pg_cron
RUN apt-get update && apt-get install -y postgresql-16-cron \
    && rm -rf /var/lib/apt/lists/*

# Добавляем pg_cron в shared_preload_libraries
RUN echo "shared_preload_libraries = 'pg_cron'" >> /docker-entrypoint-initdb.d/pg_cron.conf

# Создаем базу и расширение при запуске
CMD ["postgres"]