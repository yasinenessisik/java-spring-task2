FROM openjdk:21 AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:21
WORKDIR account-api
COPY --from=build target/*.jar reservation-api.jar
ENTRYPOINT ["java", "-jar", "reservation-api.jar"]