FROM debian:bullseye-slim

# Install dependencies (e.g., curl, ca-certificates)
RUN apt-get update && apt-get install -y \
    curl \
    ca-certificates \
    && rm -rf /var/lib/apt/lists/*

# Download and install OpenJDK 25
RUN curl -L -o /tmp/openjdk.tar.gz https://download.java.net/openjdk/jdk25/ri/openjdk-25.0.1_linux-x64_bin.tar.gz \
    && mkdir /opt/java \
    && tar -xzf /tmp/openjdk.tar.gz -C /opt/java \
    && rm /tmp/openjdk.tar.gz

# Set JAVA_HOME environment variable
ENV JAVA_HOME=/opt/java/jdk-25.0.1
ENV PATH="${JAVA_HOME}/bin:${PATH}"

# Verify the Java version
RUN java -version

# Set working directory
WORKDIR /app

# Copy your application JAR or build artifacts
COPY memberdb-0.0.1-SNAPSHOT.jar /app/memberdb-0.0.1-SNAPSHOT.jar

# Expose the port your app will run on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "myapp.jar"]
