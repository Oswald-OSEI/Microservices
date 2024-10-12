# Use a Java 21 image
FROM openjdk:21-jre-slim

# Set the working directory
WORKDIR /ApiGateway

# Copy the built JAR file from the target directory
COPY target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway.jar

# Expose the port
EXPOSE 8082

# Run the API Gateway
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]