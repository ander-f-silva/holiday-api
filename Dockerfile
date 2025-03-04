FROM amazoncorretto:21 AS build

WORKDIR /app

COPY . ./

RUN ./mvnw clean package -DskipTests

FROM amazoncorretto:21

WORKDIR /app

COPY --from=build /app/target/holiday-api-0.1.jar holiday-api.jar

ENTRYPOINT ["java", "-jar", "holiday-api.jar"]