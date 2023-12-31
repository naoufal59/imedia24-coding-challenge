# iMedia24 Coding challenge

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Official Kotlin documentation](https://kotlinlang.org/docs/home.html)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.3/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.3/gradle-plugin/reference/html/#build-image)
* [Flyway database migration tool](https://flywaydb.org/documentation/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

## Running the Application with Docker

1. Build the Docker image:

    ```bash
    docker build -t shop .
    ```

2. Run the Docker container:

    ```bash
    docker run -p 8080:8080 -d shop
    ```

3. Access the application:

    Open your web browser and navigate to [http://localhost:8080](http://localhost:8080).

4. Stop the container (optional):

    ```bash
    docker stop $(docker ps -q --filter ancestor=shop)
    ```


