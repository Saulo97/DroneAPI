
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests

FROM openjdk:17-alpine
COPY --from=build /target/*.jar drones.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "drones.jar"]