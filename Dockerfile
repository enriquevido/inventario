# Etapa 1 Build con Gradle (compilación)
FROM gradle:8.10-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle build --no-daemon

# Etapa 2 Imagen ligera de runtime (producción)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]