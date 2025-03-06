FROM amazoncorretto:21 AS build

WORKDIR /app

COPY . ./

RUN ./mvnw clean package -DskipTests

FROM amazoncorretto:21

WORKDIR /app

COPY --from=build /app/target/holiday-api-0.1.jar holiday-api.jar

ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005","-jar","holiday-api.jar"]