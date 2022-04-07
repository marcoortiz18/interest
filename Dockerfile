FROM openjdk:17
EXPOSE 8080
ADD target/aplazo-boot-docker.jar aplazo-boot-docker.jar
ENTRYPOINT ["java","-jar","/aplazo-boot-docker.jar"]
