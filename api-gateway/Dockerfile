FROM openjdk:17
LABEL authors="Viсtoria"

COPY build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]