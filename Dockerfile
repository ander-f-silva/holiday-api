FROM openjdk:21-jdk-slim AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:21-jre-slim

WORKDIR /app

COPY --from=build /app/target/holiday-api-0.1.jar holiday-api.jar

ENTRYPOINT ["java", "-jar", "holiday-api.jar"]