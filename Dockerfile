# --- ETAPA 1: Construcción del JAR ---
FROM gradle:8.5-jdk21 AS build
WORKDIR /app

# Copiamos los archivos de configuración de Gradle y el código fuente
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle
COPY src ./src

# Compilamos la aplicación omitiendo las pruebas para agilizar el proceso
RUN ./gradlew bootJar -x test --no-daemon

# --- ETAPA 2: Ejecución ligera de la aplicación ---
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app

# Copiamos el JAR generado desde la etapa de compilación
COPY --from=build /app/build/libs/*.jar app.jar

# Puerto predeterminado en el que escucha Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]