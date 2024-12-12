FROM gradle:8.11-jdk17 AS builder

WORKDIR /app
COPY settings.gradle .
COPY gRPC-proto ./gRPC-proto
COPY gRPC-server ./gRPC-server


WORKDIR /app/gRPC-server
RUN gradle build --no-daemon --exclude-task spotlessJava --exclude-task spotlessJavaCheck

# Final stage
FROM openjdk:17
WORKDIR /app
COPY --from=builder /app/gRPC-server/build/libs/*.jar /app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]
