FROM eclipse-temurin:21-jdk
EXPOSE $SERVER_PORT
WORKDIR /app
COPY target/*.jar users-backend.jar
ENTRYPOINT java -Xms64m -Xmx128m -jar /app/users-backend.jar
