# Use Java 17 runtime
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the JAR file into the container


# Expose your Spring Boot port (change if needed)
EXPOSE 7070

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
