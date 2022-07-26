FROM openjdk:17
EXPOSE 9095
ADD target/authorization-service.jar authorization-service.jar
ENTRYPOINT ["java", "-jar", "/authorization-service.jar"]