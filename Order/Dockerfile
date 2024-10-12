# Start with a Java 21 image
FROM openjdk:21-jre-slim

# Set the working directory
WORKDIR /Order

# Copy the Maven build artifact
COPY target/EurekaServer-0.0.1-SNAPSHOT.jar EurekaServer.jar

# Expose port 8761 for Eureka dashboard
EXPOSE 8761

# Run the application
ENTRYPOINT ["java", "-jar", "EurekaServer.jar"]
