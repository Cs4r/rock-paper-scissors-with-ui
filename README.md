# Rock, Papper, Scissors

A program to play rounds of Rock, Paper, Scissors

## Requirements

- Java 11
- Gradle

## Executing

In order to start the application please run the following command from the command line:
```bash
./gradlew bootRun
```
and then open http://localhost:8080/rps/ in your browser.

To run the tests execute:
```bash
./gradlew test 
```

## Using docker

Build the image with the following command:

> docker build . -t rps

Then run a container with that image using: 

> docker run --name rps -p8080:8080 rps

