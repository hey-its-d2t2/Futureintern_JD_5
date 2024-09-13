FROM maven:3.6.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-slim
COPY --from=build /target/Futureintern-JD-5-0.0.1-SNAPSHOT.jar PasswordGenerator.jar
# /Futureintern_JD_5/target/Futureintern-JD-5-0.0.1-SNAPSHOT.jar PasswordGenerator.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "PasswordGenerator.jar"]
