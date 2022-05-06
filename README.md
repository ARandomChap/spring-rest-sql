# Spring RESTful App using MySQL

This Application allows me to explore the Spring framework, this interation has included the ability to allows manipulation of a database, MySQL.

## Usage

The API is currently configure for `localhost:8080`, and provides the following endpoints:

GET mappings:

```
/users
/users/{id}
```

POST mappings:

```
/users/
```

PUT mappings:

```
/users/{id}
```

DELETE mappings:

```
/users/{id}
```

## MySQL pre-requisites

MySQL will need configuring, ideally this would be automated, until solution is figured out these are the steps needed:

```
CREATE DATABASE spring;

CREATE TABLE spring.users(
id BINARY(16) NOT NULL primary key DEFAULT (UUID_TO_BIN(UUID())), 
first_name VARCHAR(50) NOT NULL, 
last_name VARCHAR(50) NOT NULL);
```

You will also need to update the `./src/main/resources/application.properties` file to the endpoint and user for your DB.