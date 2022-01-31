# Server part of the project

___

**Here are the steps of the project development:**

* Initial stage
* Alloy API call:
    * RestClient -> reactive WebClient ->  Feign Client
* Project builder:
    * Maven -> Gradle
* Database integration:
    * MongoDB
    * Embedded mongoDB for testing
* Global Exception handler @ControllerAdvice
* Described DTOs for requests and responses + mappings
* Added transaction implementation on mongo db
* Implemented integration/unit tests with embedded mongo db
* Mocked all External call API connected tests and added request validation
* Test coverage - 86%
* OpenApi integration, project structure refactoring