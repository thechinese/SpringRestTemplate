#!/usr/bin/env bash

BASE=
APP_NAME=template
APP_LATEST=latest
APP_VERSION=0.0.1-SNAPSHOT
APP_PORT=8080
HOST_PORT=8080

# Build the service JAR.
gradle_build() {
  ./gradlew clean test build --info;
}

# Cleanup function to remove unused containers and dangling images, volumes and networks.
docker_cleanup() {
  docker container stop $(docker container ls -aq);
  docker container rm $(docker container ls -aq);
  docker image prune --force;
  docker volume prune --force;
  docker network prune --force;
}

docker_build() {
  docker build --tag ${BASE}/${APP_NAME}:${APP_LATEST} \
               --tag ${BASE}/${APP_NAME}:${APP_VERSION} .
}
# Runs and logs the built container.
docker_run() {
  docker run --detach \
             --name ${APP_NAME} \
             --publish ${APP_PORT}:${HOST_PORT} \
             ${BASE}/${APP_NAME}:${APP_LATEST};
  docker logs --follow ${APP_NAME};
}
# Step 1: Build the service JAR
gradle_build;

# Step 2: Clean up the local Docker files before building.
docker_cleanup;

# Step 3: Build the Docker Container image:
docker_build

# Step 4: Cleanup again after the build.
#docker_cleanup;

# Step 5: Run and log the container.
# docker_run;

#docker-compose up -d && docker-compose logs -f transformation-service;

kamikaze() {
  docker container stop $(docker container ls --all --quiet) \
    && docker container rm $(docker container ls --all --quiet) \
    && docker image prune --all --force \
    && docker volume prune --force \
    && docker network prune --force
}

# Written down terminal cleanup to stop test run.
z() {
  docker container stop $(docker container ls -aq) \
    && docker container rm $(docker container ls -aq) \
    && docker image prune --force \
    && docker volume prune --force \
    && docker network prune --force
}
