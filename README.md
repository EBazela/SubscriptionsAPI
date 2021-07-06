# SubscriptionsAPI

Overview
This is the API created for the purpose of interview. The coding challenge required to build an API and client library to manage subscriptions.
The API will be developed with Java 15+, Spring Boot Framework, Swagger and Maven.
All additional dependencies can be found in POM.

How to install the project?

Simply clone the project from the repository and let Maven finish installing all dependencies. There is no need for any other externals or dB, since it was meant to be a mocked/in memory database.

How to use the project?

The best point to start is using a swagger documentation, to see the details and how to use API. Since the project is using a custom port ("2137" - which can be modified in application.properties),
the general link for local machine would be: "http://localhost:2137/swagger-ui/#/". Here is the list of all exposed endpoints, the details of expected JSON input, as well as the description of models.
It is also a good place to send some sample requests in order to quickly test particular endpoint.
