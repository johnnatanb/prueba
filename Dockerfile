FROM maven:3.8.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml package

FROM openjdk:17-oracle
COPY --from=build /home/app/target/neoris-0.0.1-SNAPSHOT.jar neoris-0.0.1-SNAPSHOT.jar
#COPY target/neoris-0.0.1-SNAPSHOT.jar neoris-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","neoris-0.0.1-SNAPSHOT.jar"]