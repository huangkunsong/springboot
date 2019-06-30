FROM java:8

MAINTAINER rookie

ARG JAR_FILE

ADD  ${JAR_FILE} /app.jar

EXPOSE 2000

ENTRYPOINT java -jar /app.jar

