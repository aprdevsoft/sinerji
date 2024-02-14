# Usar uma imagem base do JDK 11
FROM openjdk:21-jdk-slim
ENTRYPOINT ["top", "-b"]

# Variáveis de ambiente para o diretório do aplicativo
ARG APP_DIR=/app
ARG APP_FILE=target/sinerji-0.0.1-SNAPSHOT.jar
# Criar o diretório do aplicativo no container
RUN mkdir -p $APP_DIR

# Definir o diretório de trabalho
WORKDIR $APP_DIR

# Copiar o JAR do aplicativo para o container
COPY $APP_FILE $APP_DIR/app.jar

# Expõe a porta 8080 para acessar a aplicação
EXPOSE 8288

# Comando para iniciar a aplicação
ENTRYPOINT ["java","-jar","app.jar"]
