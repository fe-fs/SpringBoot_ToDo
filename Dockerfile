#syntax=docker/dockerfile:1.3
FROM openjdk:17
EXPOSE 8080
RUN /target/spring-boot-3-todo-aplication.jar spring-boot-3-todo-aplication.jar
ENTRYPOINT ["java", "-jar","/target/spring-boot-3-todo-aplication.jar"]


