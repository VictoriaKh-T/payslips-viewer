FROM gradle:8.11-jdk17 AS builder

WORKDIR /app

COPY settings.gradle .

COPY gRPC-proto ./gRPC-proto
COPY gRPC-client ./gRPC-client


WORKDIR /app/gRPC-client
RUN gradle build --no-daemon

# Final stage
FROM openjdk:17
WORKDIR /app

COPY --from=builder /app/gRPC-client/build/libs/*.jar /app.jar

EXPOSE 8088
ENTRYPOINT ["java", "-jar", "app.jar"]