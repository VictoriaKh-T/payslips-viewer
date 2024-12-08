FROM openjdk:17
LABEL authors="Viсtoria"

COPY build/libs/gRPC-client-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]