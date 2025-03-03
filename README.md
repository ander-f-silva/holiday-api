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
- `docker-compose.yml`: Contains the configuration for Docker Compose to set up the application along with PostgreSQL and Redis services.

## Building the Project

To build the project, use the following command:

```sh
./mvnw clean package
```

## Running the Application

To run the application, you can use the Docker image built from the Dockerfile:

```sh
docker build -t holiday-api .
docker run -p 8080:8080 holiday-api
```

or

```sh
docker-compose up --build
```

The application will be accessible at `http://localhost:8080`.

## Testing

To run the tests, use the following command:

```sh
./mvnw test
```

## License

This project is licensed under the MIT License.