
# build
FROM maven:3.9.9-amazoncorretto-23-al2023 as build

WORKDIR /build


COPY  . .

RUN mvn clean package -DskipTests

# run

FROM amazoncorretto:23
WORKDIR  /app

COPY  --from=build ./build/target/*.jar ./library.jar

EXPOSE 8080
EXPOSE 9090

ENV DATASOURCE_URL=''
ENV DATASOURCE_USERNAME=''
ENV DATASOURCE_PASSWORD=''
ENV GOOGLE_CLIENT_ID='${GOOGLE_CLIENT_ID}'
ENV GOOGLE_CLIENT_SECRET='${GOOGLE_CLIENT_SECRET}'
ENV SPRING_PROFILES_ACTIVE='production'
ENV TZ='Americs/Sao_Paulo'  

ENTRYPOINT java -jar library.jar