FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

COPY --from=build /app/target/nth-max-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/excel/test1.xlsx /app/excel/test1.xlsx
COPY src/main/resources/excel/test2.xlsx /app/excel/test2.xlsx
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
