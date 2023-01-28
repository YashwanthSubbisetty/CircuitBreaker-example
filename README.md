# CircuitBreaker-example
Implementing Circuit Breaker Design pattern

In this Repository there are two services:
1)Foo
2)Spring boot Sample Service

In Foo I have implemented Circuit Breaker design Pattern. Circuit Breaker maintains three states
1)	Closed
2)	Open
3)	Partially Open

![CircuitBreaker](https://user-images.githubusercontent.com/123811765/215273821-17f7791f-a223-4419-b167-6b5e2494d437.png)

From Foo we are calling the sample service i.e., springboot-sample-service. Depending on the status of sample service whether it is up or down. Circuit breaker will come into action and will act accordingly as shown in the above picture.

When the sample service is up i.e., http://localhost:8083/test

<img width="336" alt="sampleserviceup" src="https://user-images.githubusercontent.com/123811765/215274012-12c2fa93-1ee6-4576-96dd-82ecba1a6292.png">

and when we hit http://localhost:8080/foo in the browser it will return the response from the sample service as shown below:

<img width="262" alt="Testserviceup" src="https://user-images.githubusercontent.com/123811765/215274042-12330c85-e3b2-4cec-987e-259fd86c3073.png">

Then if we see the health of foo where circuit breaker is implemented by hitting http://localhost:8080/actuator/health in postman, we can see the status of Circuit Breaker as closed because the two service are running and the requests are getting successful.

![closed](https://user-images.githubusercontent.com/123811765/215274076-73bdf9ac-6fba-41fe-ac93-b2c14ea0dafe.jpg)

When the sample service is down, 

<img width="300" alt="sampleservicedown" src="https://user-images.githubusercontent.com/123811765/215274152-835ad32a-9616-4b52-bb83-29db642b4f3d.png">

If we don’t have a fallback method Foo will throw a 500 internal server error when we hit http://localhost:8080/foo ,but in Foo I have implemented a fallback method which will return the status of sample service is down as shown below.

<img width="304" alt="fallback" src="https://user-images.githubusercontent.com/123811765/215274345-a8c191bc-3691-4629-8e78-89c16f74c1bb.png">

When the threshold value(failureRateThreshold) exceeds the value set in application.yml file in Foo the state of Circuit Breaker will be Open. And the failed calls(minimumNumberOfCalls) are more than the value set in application.yml file the state of Circuit Breaker will be Half Open.

<img width="313" alt="open" src="https://user-images.githubusercontent.com/123811765/215274389-2efdbc44-d73a-4c96-932a-472456b0512a.png">

So, From Half Open state if the permissible half open calls set in the application.yml file are successful then it will go into Closed state otherwise it will again go into Open state.
