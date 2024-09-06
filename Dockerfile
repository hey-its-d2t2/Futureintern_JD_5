#FROM ubuntu:latest
#LABEL authors="DEEPAK"
#
#ENTRYPOINT ["top", "-b"]
#
#FROM maven:3.6.3-openjdk-21 AS BUILD
#COPY . .
#RUN mn clean package -DskipTests
#
#FROM openjdk:21-3.6.3-slim
#COPY --from=build /out/artifacts/Futureintern_JD_5_jar/Futureintern-JD-5.jar PasswordGenerator.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "PasswordGenerator.jar"]
# Use a valid Maven image with OpenJDK 17 (or you can choose another valid version)
FROM maven:3.6.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Use OpenJDK 17 slim as the runtime environment
FROM openjdk:17-slim
COPY --from=build /path/to/your/target/Futureintern-JD-5.jar PasswordGenerator.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "PasswordGenerator.jar"]
