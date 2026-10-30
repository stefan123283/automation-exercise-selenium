FROM maven:3.9.16-eclipse-temurin-21

# Install Google Chrome and required system packages
RUN apt-get update && apt-get install -y --no-install-recommends \
    ca-certificates \
    wget \
    && wget -q https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
       -O /tmp/google-chrome.deb \
    && apt-get install -y --no-install-recommends /tmp/google-chrome.deb \
    && rm -f /tmp/google-chrome.deb \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY pom.xml .

RUN mvn -B dependency:go-offline

COPY . .

CMD ["mvn", "-B", "clean", "test"]
