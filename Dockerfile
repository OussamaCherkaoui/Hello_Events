FROM openjdk:21
EXPOSE 8081
ADD target/hello_event-0.0.1-SNAPSHOT.jar helloevent.jar
ENTRYPOINT ["java","-jar","/helloevent.jar"]