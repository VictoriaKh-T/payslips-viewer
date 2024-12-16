FROM gradle:8.11-jdk17 AS builder

WORKDIR /app
COPY settings.gradle .
COPY gRPC-proto ./gRPC-proto
COPY gRPC-server ./gRPC-server
COPY gRPC-client ./gRPC-client
COPY . .

RUN gradle build --no-daemon --exclude-task spotlessJava --exclude-task spotlessJavaCheck

# Stage 2: Final image
FROM openjdk:17
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]