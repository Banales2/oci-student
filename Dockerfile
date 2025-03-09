FROM openjdk:17-jdk-slim
WORKDIR /oci-student
COPY /target/*.jar oci-student.jar
COPY /src/main/resources/Wallet_javadev /oci-student/Wallet_javadev
ENV TNS_ADMIN=/oci-student/Wallet_javadev
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "oci-student.jar" ]