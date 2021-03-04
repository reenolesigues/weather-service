FROM adoptopenjdk:11-jre-hotspot as builder
ARG JAR_FILE=target/weatherhack-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} weather.jar
ENTRYPOINT ["java","-Xmx500m","-jar","/weather.jar"]