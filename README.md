# demo-portal-backend
Spring Boot application to be used by frontend web application

## Before building

``` bash
# file src/main/resources/application.properties was omitted from version control. This file must be created manually.
# It should contain the following lines for the MySql database connection
spring.datasource.url=jdbc:mysql://xxxxx/xxxxx
spring.datasource.username=xxxxx
spring.datasource.password=xxxxx
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
server.port = 8090

spring.jpa.show-sql=true
```