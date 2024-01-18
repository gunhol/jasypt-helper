# Jasypt Helper

Decrypt Spring Boot Jasypt V2 & V3 Secrets via REST

Jasypt `PooledPBEStringEncryptor` configured according to https://github.com/ulisesbocchio/jasypt-spring-boot

### Get it running

- Run the application with `./gradlew bootRun`
- Open the [swagger-ui](http://localhost:8080/swagger-ui.html)
- Call either `/jasypt/decrypt` or `/jasypt/encrypt` and provide
    - input
    - secret
    - version (`V2` or `V3`)

### Dependencies

- Spring Boot (Web)
- springdoc-openapi
- Jasypt
- Lombok