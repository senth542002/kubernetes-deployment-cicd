FROM openjdk:11
ARG JAR_FILE
RUN echo JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080/tcp