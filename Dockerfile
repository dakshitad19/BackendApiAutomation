#base image
FROM openjdk:8

WORKDIR /src/test/java
COPY ./src /usr/
RUN ["javac", "RestAssured-1.0-SNAPSHOT.jar"]
ENTRYPOINT ["java","RestAssured-1.0-SNAPSHOT.jar"]