FROM openjdk:17-oracle
COPY target/course-model-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","/course-model-0.0.1-SNAPSHOT.jar"]