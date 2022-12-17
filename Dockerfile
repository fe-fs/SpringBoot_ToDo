FROM openjdk:17
EXPOSE 8080
ADD spring-boot-3-todo-aplicationtarget/spring-boot-3-todo-aplication.jar spring-boot-3-todo-aplication.jar
ENTRYPOINT ["java", "-jar","/spring-boot-3-todo-aplication.jar"]