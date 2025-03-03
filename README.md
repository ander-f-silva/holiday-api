# holiday-api/README.md

# Holiday API

## Overview

The Holiday API is a Java-based application built using the Micronaut framework. It provides endpoints for managing holiday-related data and functionalities.

## Project Structure

- `src/main/java`: Contains the main Java source files for the application.
- `src/main/resources`: Contains resource files needed by the application, such as configuration files.
- `src/test/java`: Contains the Java source files for the test cases.
- `src/test/resources`: Contains resource files needed for testing.
- `pom.xml`: The Maven configuration file that specifies project dependencies, build configuration, and other settings.
- `Dockerfile`: Contains instructions to build a Docker image for the application.

## Building the Project

To build the project, use the following command:

```
./mvnw clean package
```

## Running the Application

To run the application, you can use the Docker image built from the Dockerfile:

```
docker build -t holiday-api .
docker run -p 8080:8080 holiday-api
```

The application will be accessible at `http://localhost:8080`.

## Testing

To run the tests, use the following command:

```
./mvnw test
```

## License

This project is licensed under the MIT License.

## Micronaut 4.7.6 Documentation

- [User Guide](https://docs.micronaut.io/4.7.6/guide/index.html)
- [API Reference](https://docs.micronaut.io/4.7.6/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/4.7.6/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Micronaut Maven Plugin documentation](https://micronaut-projects.github.io/micronaut-maven-plugin/latest/)
## Feature data-jdbc documentation

- [Micronaut Data JDBC documentation](https://micronaut-projects.github.io/micronaut-data/latest/guide/index.html#jdbc)


## Feature junit-platform-suite-engine documentation

- [https://junit.org/junit5/docs/current/user-guide/#junit-platform-suite-engine-setup](https://junit.org/junit5/docs/current/user-guide/#junit-platform-suite-engine-setup)


## Feature redoc documentation

- [Micronaut Redoc View documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/#redoc)

- [https://github.com/Redocly/redoc#generate-beautiful-api-documentation-from-openapi](https://github.com/Redocly/redoc#generate-beautiful-api-documentation-from-openapi)


## Feature openapi documentation

- [Micronaut OpenAPI Support documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

- [https://www.openapis.org](https://www.openapis.org)


## Feature maven-enforcer-plugin documentation

- [https://maven.apache.org/enforcer/maven-enforcer-plugin/](https://maven.apache.org/enforcer/maven-enforcer-plugin/)


## Feature security-jwt documentation

- [Micronaut Security JWT documentation](https://micronaut-projects.github.io/micronaut-security/latest/guide/index.html)


## Feature test-resources documentation

- [Micronaut Test Resources documentation](https://micronaut-projects.github.io/micronaut-test-resources/latest/guide/)


## Feature flyway documentation

- [Micronaut Flyway Database Migration documentation](https://micronaut-projects.github.io/micronaut-flyway/latest/guide/index.html)

- [https://flywaydb.org/](https://flywaydb.org/)


## Feature management documentation

- [Micronaut Management documentation](https://docs.micronaut.io/latest/guide/index.html#management)


## Feature tracing-opentelemetry-exporter-logging documentation

- [Micronaut OpenTelemetry Exporter Logging documentation](http://localhost/micronaut-tracing/guide/index.html#opentelemetry)

- [https://opentelemetry.io](https://opentelemetry.io)


## Feature assertj documentation

- [https://assertj.github.io/doc/](https://assertj.github.io/doc/)


## Feature jdbc-hikari documentation

- [Micronaut Hikari JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)


## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)


## Feature micronaut-aot documentation

- [Micronaut AOT documentation](https://micronaut-projects.github.io/micronaut-aot/latest/guide/)


