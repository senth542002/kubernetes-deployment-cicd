FROM openjdk:11
ARG JAR_FILE
RUN echo ${JAR_FILE}
COPY "build/libs/KubeDeployment-0.0.1-SNAPSHOT.jar" app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080