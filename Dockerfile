FROM gradle:jdk11
ADD src src
ADD gradle gradle
ADD build.gradle .
ADD gradle.properties .
ADD settings.gradle .

EXPOSE 8080
ENTRYPOINT gradle bootRun
