FROM maven as builder
WORKDIR /carapp
COPY . /carapp/.
RUN mvn -f /carapp/pom.xml clean package -Dmaven.test.skip=true

FROM eclipse-temurin
WORKDIR /carapp
COPY --from=builder /carapp/target/*.jar /carapp/*.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "/carapp/*.jar"]