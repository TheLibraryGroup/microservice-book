FROM openjdk:11
ADD /microservice-0.0.1-SNAPSHOT.jar /microservice-0.0.1-SNAPSHOT.jar
EXPOSE 8090
#CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=dev", "/microservice-0.0.1-SNAPSHOT.jar"]
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "microservice-0.0.1-SNAPSHOT.jar"]
#ENTRYPOINT ["java", "-jar", "microservice-0.0.1-SNAPSHOT.jar"]
#CMD java -jar microservice-0.0.1-SNAPSHOT.jar
