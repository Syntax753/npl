# Use an official OpenJDK runtime as a parent image
FROM openjdk:23-jdk

# Set the working directory in the container
WORKDIR /app

# RUN mvnw.cmd clean package

# Copy the executable JAR file to the working directory
COPY npl-1.0-SNAPSHOT.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
