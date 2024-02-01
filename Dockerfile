
# Use a imagem oficial do OpenJDK com Java 17 como base
FROM maven:3.8.4-openjdk-17-slim AS build

# Copie o arquivo pom.xml e baixe as dependências
COPY pom.xml /build/
WORKDIR /build
RUN mvn dependency:go-offline

# Copie todo o código-fonte para o contêiner
COPY src /build/src

# Compile o projeto e crie o JAR
RUN mvn package

# Use the official OpenJDK 11 image as the base image
FROM openjdk:17-alpine

# Diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o JAR construído do estágio de compilação anterior
COPY --from=build /build/target/*.jar /app/app.jar

# Expõe a porta que o aplicativo Spring Boot está ouvindo
EXPOSE 8081

# Comando para executar o aplicativo Spring Boot
CMD ["java", "-jar", "app.jar"]