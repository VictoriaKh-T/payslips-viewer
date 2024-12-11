FROM gradle:8.0.0-jdk18 AS builder

WORKDIR /app
COPY organization .

RUN gradle build --no-daemon

# Stage 2: Final image
FROM openjdk:18
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar /app.jar

EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]