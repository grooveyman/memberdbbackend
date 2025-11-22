FROM debian:bullseye-slim

# Install dependencies (e.g., curl, ca-certificates)
RUN apt-get update && apt-get install -y \
    curl \
    ca-certificates \
    && rm -rf /var/lib/apt/lists/*

# Download OpenJDK 25 and verify
RUN curl -L -o /tmp/openjdk.tar.gz https://download.java.net/openjdk/jdk25/ri/openjdk-25.0.1_linux-x64_bin.tar.gz \
    && echo "Downloaded JDK file:" \
    && ls -lh /tmp/openjdk.tar.gz \
    && tar -xvf /tmp/openjdk.tar.gz -C /opt/java \
    && rm /tmp/openjdk.tar.gz

# Set JAVA_HOME environment variable
ENV JAVA_HOME=/opt/java/jdk-25.0.1
ENV PATH="${JAVA_HOME}/bin:${PATH}"

# Verify the Java version
RUN java -version
