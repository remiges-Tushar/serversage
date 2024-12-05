# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the application JAR and OpenTelemetry agent to the container
COPY target/bankapp-0.0.1-SNAPSHOT.jar /app/app.jar
COPY opentelemetry-javaagent.jar /app/opentelemetry-javaagent.jar

# Expose the Prometheus metrics port
EXPOSE 9464

# Command to run the Java application
ENTRYPOINT ["java", "-javaagent:/app/opentelemetry-javaagent.jar", "-jar", "/app/app.jar"]
