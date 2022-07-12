FROM openjdk:17-jdk as build
RUN microdnf install findutils

WORKDIR /build

COPY app/build.gradle app/build.gradle
COPY gradle ./gradle
COPY gradlew settings.gradle ./

RUN ./gradlew -v

COPY app ./app
RUN ./gradlew --stacktrace clean build
RUN mv ./app/build/distributions/app.tar /


FROM openjdk:17-jdk
RUN microdnf install findutils
WORKDIR /

ARG STAGE=dev \
    REGION=local
ENV STAGE=$STAGE \
    REGION=$REGION

COPY --from=build /app.tar .
RUN tar -xvf app.tar

ENTRYPOINT /app/bin/app server /app/config-$STAGE.$REGION.yml