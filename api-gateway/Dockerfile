FROM gradle:8.11-jdk18 AS builder

WORKDIR /app
COPY api-gateway .

RUN gradle build --no-daemon

FROM openjdk:18
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar /app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]