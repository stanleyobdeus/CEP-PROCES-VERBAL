FROM openjdk:11 as build
EXPOSE 8181
ADD /target/cep-0.0.1-SNAPSHOT.jar process-verbal-api-cep.jar
ENTRYPOINT ["java", "-jar", "process-verbal-api-cep.jar"]


#java.net.UnknownHostException: nis.hti.dermalog.site