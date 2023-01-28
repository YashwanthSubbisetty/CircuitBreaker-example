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

