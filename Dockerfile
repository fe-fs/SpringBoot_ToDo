FROM openjdk:17
EXPOSE 8080
COPY target/spring-boot-3-todo-aplication.jar spring-boot-3-todo-aplication.jar
ENTRYPOINT ["java", "-jar","/spring-boot-3-todo-aplication.jar"]