#base image
FROM openjdk:8

WORKDIR /Users/zc-dakshitad/Desktop/RestAssured
COPY src /Users/zc-dakshitad/Desktop/
COPY pom.xml /Users/zc-dakshitad/Desktop/
COPY config.properties /Users/zc-dakshitad/Desktop/
RUN mvn -f /Users/zc-dakshitad/Desktop/RestAssured/pom.xml clean test -D skipTests=false
