#syntax=docker/dockerfile:1.3
FROM openjdk:17
EXPOSE 8080
COPY /spring-boot-3-todo-aplication/target/spring-boot-3-todo-aplication.jar spring-boot-3-todo-aplication.jar
ENTRYPOINT ["java", "-jar","/spring-boot-3-todo-aplication.jar"]

