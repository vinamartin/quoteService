# Integration Testing with [Testcontainers](https://www.testcontainers.org/)
With Testcontainers, we can spin up a docker container during tests to run a real instance of Cassandra. 
This allows us to test our application as if it were actually running in production.
The Cassandra container only spins up once for all of the tests we want to run. 
This is more efficient than [embedded cassandra](https://github.com/jsevellec/cassandra-unit) which spins up and tears down per test method.
The trade off is making sure we clean up between tests or design our tests with this in mind.

## @SpringBootTest Annotation
Starts up spring application for test.

## Generic Container
```new GenericContainer("cassandra:3")```
Gives us a Cassandra container.

## Initializer
Configures our app given the container host and port.

## MockMvc
Allows us to interact with our application's endpoints similar to how we would hit them in production.

# CQuoteIntegrationTest
## public void testPost()
Posts a quote to the service (/addQuote) and then verifies that we get the quote back (/getQuotes)
