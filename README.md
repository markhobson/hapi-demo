# HTML API Demo

## Running locally

1. Build the project:

    ```bash
    mvn clean install
    ```

1. Run the server:

    ```bash
    mvn --projects :hapi-demo-server spring-boot:run
    ```

1. Run the client:

    ```bash
    java -jar client/target/hapi-demo-client-0.1.0-SNAPSHOT.jar
    ```
