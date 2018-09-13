# MicroServicesApp-Repository [Spring boot app made with netflix stack]

This microservice will be the repository layer. It will be in charge of accessing the database and extracting the information.

1. Import the project as maven project in STS/Eclipse or your favourite IDE.
2. Before running it be sure that Eureka microservice is running (you can download from this repository: https://github.com/arturogj92/MicroServicesApp-EurekaServer)
3. Import the .sql database and modify the application properties as you wish. You just need to change the database configuration:

```java
    spring.datasource.url = jdbc:mysql://localhost:3306/savethislittle
    spring.datasource.username = root
    spring.datasource.password = admin
```



