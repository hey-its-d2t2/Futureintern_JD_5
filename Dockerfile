#FROM ubuntu:latest
#LABEL authors="DEEPAK"
#
#ENTRYPOINT ["top", "-b"]

FROM maven:3.6.3-openjdk-21 AS BUILD
COPY . .
RUN mn clean package -DskipTests

FROM openjdk:21-3.6.3-slim
COPY --from=build /target/PasswordGenerator-00.01-SNAPSHOT.jar PasswordGenerator.jar
EXPOSE 8080
ENTRYPOINT["java", "-jar","PasswordGenerator.jar"]
