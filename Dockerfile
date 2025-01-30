FROM maven:3.8.5-openjdk AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/Login_in-0.0.1-SNAPSHOT.jar Login_in.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","Login_in.jar"]
