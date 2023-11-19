# Use the official OpenJDK 11 image as the base image
FROM openjdk:17-alpine

# Define a working directory for the application
WORKDIR /app

# Copy the JAR file into the container at /app
COPY *target/ola-devops* /app

# Expose the port that the application will run on
EXPOSE 8081

# Specify the command to run your application
CMD ["java", "-jar", "ola-devops-me-0.0.1.jar","ola-devops*"]
