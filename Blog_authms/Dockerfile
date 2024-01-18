FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /Blog-Micro-services
COPY ./src ./src
COPY ./pom.xml .
RUN mvn clean package
FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} blog_auth.jar
ENTRYPOINT ["java","-jar","/blog_auth.jar"]