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

1. Call the API:

    ```bash
    curl http://127.0.0.1:8080/
    ```
