FROM openjdk:8u191-jre-alpine3.8

WORKDIR /usr/share/selenium-docker

ADD target/selenium-docker.jar             selenium-docker.jar
ADD target/selenium-docker-tests.jar       selenium-docker-tests.jar
ADD target/libs						       libs
ADD Configuration                          Configuration
ADD DDTFiles                               DDTFiles
ADD Drivers								   Drivers
ADD ImageRepository                        ImageRepository

ADD TestNGWindows.xml            TestNGWindows.xml  
ADD TestNGWeb.xml		         TestNGWeb.xml
ADD TestNGMobile.xml		     TestNGMobile.xml
ADD TestNGElectron.xml		     TestNGElectron.xml
ADD TestNGApi.xml		         TestNGApi.xml

ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE




