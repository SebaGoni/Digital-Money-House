FROM openjdk:17-alpine
ARG JAR_FILE=target/config-server.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8888