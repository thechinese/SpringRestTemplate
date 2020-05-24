FROM openjdk:12.0.1-jdk
LABEL maintainer="viktor.krimstein@icloud.com"

# Change according to your service name
ARG APP_SOURCE=build/libs/transformation-service-0.0.1-SNAPSHOT.jar
ARG APP_NAME=app.jar
ARG VOLUME=/tmp
ARG PORT=8080

VOLUME ${VOLUME}
EXPOSE ${PORT}
ADD ${APP_SOURCE} ${APP_NAME}
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
