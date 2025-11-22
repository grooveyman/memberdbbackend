# Use OpenJDK 17 as base
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper & pom.xml first to leverage caching
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (cache layer)
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Package the app
RUN ./mvnw package -DskipTests

# Expose port 8080
EXPOSE 8080

# Run the app
ENTRYPOINT ["java","-jar","target/your-backend-0.0.1-SNAPSHOT.jar"]
