FROM java:8-jdk

LABEL name="tomcat-jmp-app" \
      maintainer="aliaksandr.babai@gmail.com"

ARG ROOT_DIR=/usr/workspace
ARG WORK_DIR=$ROOT_DIR/tomcat-jmp-app
ENV SERVER_PORT=8081

COPY . $WORK_DIR
WORKDIR $WORK_DIR

EXPOSE $SERVER_PORT
CMD ["./gradlew", "bootRun"]
