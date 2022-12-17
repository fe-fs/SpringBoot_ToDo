#syntax=docker/dockerfile:1.3
FROM openjdk:17
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/target/spring-boot-3-todo-aplication.jar"]
RUN target/spring-boot-3-todo-aplication.jar spring-boot-3-todo-aplication.jar

