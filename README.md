Weather service
---

### Introduction

This is a simple application that requests its data from [OpenWeather](https://openweathermap.org/) and stores the result in a database.

### Running the application locally

One way to run the application locally is to execute the main method in the com.assignment.spring.Application class from your IDE.
<br>
In order to decrypt the database credentials, you will need to edit the run configuration by setting VM options as follows:
```
-Djasypt.encryptor.password=coding-dojo
```

### Endpoint

http://localhost:8080/weather

### Sample GET endpoint

http://localhost:8080/weather?city=bucharest
