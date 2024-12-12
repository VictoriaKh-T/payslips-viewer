FROM openjdk:17
WORKDIR /app
COPY --from=builder /app/gRPC-server/build/libs/*.jar /app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]
