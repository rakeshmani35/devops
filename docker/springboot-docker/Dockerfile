FROM openjdk:17
WORKDIR /appContainer
COPY cert.txt /appContainer/cert.txtexi
COPY ./target/spring-docker.jar /appContainer
EXPOSE 8282
CMD ["java","-jar","spring-docker.jar"]