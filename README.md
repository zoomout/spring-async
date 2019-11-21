# Spring async method

Demo of Spring async methods

Example taken from: https://spring.io/guides/gs/async-method/

# To run the demo
```
./gradlew bootRun
```

# Test
Run curl command in CLI and measure total time. 
Total time should be around 1 second when async is enabled.
Otherwise it would take 3 seconds (1 seconds for each of 3 calls to the `Slow service`).
To disable async remove the @Async annotation from the async method.
```
time curl -X GET http://localhost:8080/getAsync
```