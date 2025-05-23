FROM maven:3.8-amazoncorretto-21 AS builder

WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn package -DskipTests

FROM amazoncorretto:21

COPY --from=builder /app/target/npl-*-exec.jar npl-tools.jar

# Run the web service on container startup.
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/npl-tools.jar"]

