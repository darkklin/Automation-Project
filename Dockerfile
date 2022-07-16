FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

WORKDIR /usr/share/selenium-docker

ADD target/selenium-docker.jar             selenium-docker.jar
ADD target/selenium-docker-tests.jar       selenium-docker-tests.jar
ADD target/libs						       libs
ADD Configuration                          Configuration
ADD DDTFiles                               DDTFiles
ADD Drivers								   Drivers
ADD ImageRepository                        ImageRepository

ADD windows-module.xml           windows-module.xml
ADD commerce-web-module.xml		 commerce-web-module.xml
ADD mobile-module.xml		     mobile-module.xml
ADD electron-module.xml		     electron-module.xml
ADD map-api-module.xml		     map-api-module.xml
ADD search-duck-module.xml       search-duck-module.xml
ADD commWeb-regression-module.xml   commWeb-regression-module.xml

ADD healthcheck.sh               healthcheck.sh
RUN dos2unix healthcheck.sh

ENTRYPOINT sh healthcheck.sh





