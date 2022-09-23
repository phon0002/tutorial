FROM adoptopenjdk/openjdk8:x86_64-alpine-jre8u232-b09

EXPOSE 8080
COPY build/libs/tutorial-0.0.1-SNAPSHOT.jar tutorial-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "tutorial-0.0.1-SNAPSHOT.jar"]