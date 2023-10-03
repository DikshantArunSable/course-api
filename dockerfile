FROM openjdk:17-oracle
EXPOSE 8080
COPY target/course-model-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","/course-model-0.0.1-SNAPSHOT.jar"]