FROM amazoncorretto:18
EXPOSE 8080
ADD target/common-tasks-service.jar common-tasks-service.jar
ENTRYPOINT ["java","-jar","/common-tasks-service.jar"]