# Distance Calculator

Make a web service that accepts two distances (numbers) and returns the total distance (sum of both).

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

If you want to run it your own desired port, then change the `application.properties` file :

```
server.port=8090 
```

There are several ways to run a Spring Boot application on your local machine.
One way is to execute the `main` method in the `assignment.AssignmentApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Some Endpoints

I used postman to test endpoints. Here are some endpoints you can call:

#### Get all available Units

```
GET: /api/v1/distance/units
Accept: application/json

Response:
[
    "Meters",
    "Yards"
]
```

#### Get distance calculator

```
POST: /api/v1/distance/calculate
Accept: application/json
Content-Type: application/json

Reqeust Body:
{
    "firstDistance": {
        "distance": 3,
        "unit": "Yards"
    },
    "secondDistance": {
        "distance": 5,
        "unit": "Meters"
    },
    "expectedResultUnit": "Meters"
}

Response:
7.74 Meters
```

#### Validation case (Wrong expected unit input)
```
POST: /api/v1/distance/calculate
Accept: application/json
Content-Type: application/json

Reqeust Body:
{
    "firstDistance": {
        "distance": 3,
        "unit": "Yards"
    },
    "secondDistance": {
        "distance": 5,
        "unit": "Meters"
    },
    "expectedResultUnit": "Met"
}

Response:
{
    "message": "Wrong expected unit! Unit should be either: Meters/Yards",
    "dateTime": "2023-06-04T12:40:41.784433"
}
```

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
