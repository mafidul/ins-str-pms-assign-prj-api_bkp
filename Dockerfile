FROM openjdk:8-jdk-alpine
MAINTAINER baeldung.com
COPY target/ins-str-pms-assign-prj-api-*.jar /ins-str-pms-assign-prj-api.jar
ENTRYPOINT ["java","-jar","/ins-str-pms-assign-prj-api.jar"]