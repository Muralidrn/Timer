# ===== Build stage =====
FROM gradle:8.8-jdk17 AS builder
WORKDIR /app

# Copy Gradle wrapper and project files
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Make Gradle wrapper executable
RUN chmod +x ./gradlew

RUN ./gradlew bootJar --no-daemon

# ===== Runtime stage =====
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/build/libs/TimerBackend-0.0.1-SNAPSHOT.jar

# Render assigns $PORT dynamically
ENV PORT=8080
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
