FROM openjdk:21-jdk

# Adicionar o JAR da aplicação ao container
COPY target/itau-0.0.1-SNAPSHOT.jar /app.jar

# Expor a porta onde a aplicação será executada
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]
