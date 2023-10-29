FROM eclipse-temurin:17.0.8.1_1-jre-alpine
COPY build/libs/KeepALiveSIM--*-all.jar keepSim.jar
EXPOSE 8080
CMD java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar keepSim.jar
