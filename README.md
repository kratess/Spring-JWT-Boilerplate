
# Spring-JWT-Boilerplate

Boilerplate for Spring authentication server using JWT. Feel free to use this boilerplate for your projects.

## Tech Stack

* Java 21
* Spring Boot 3.1.4
* jjwt 0.11.2
* Maven
* lombok
* PostgreSQL (by default)

## Installation

1. Clone or download this project into your machine.
2. Open it with your favourite IDE
3. Install dependencies using maven
4. Edit application.properties file with the data to access database and key signature for jwt
5. Start the project

## Documentation

#### DAO (Data Access Object)

This is the package containing all request and response objects plus the *ResponseHandler*. The *ResponseHandler* always return an *ResponseEntity\<Object\>* as follow:

```
{
    "data": {},
    "status": 200
}
```

or

```
{
    "error": "Internal Server Error",
    "status": 500
}
```

or

```
{
    "error": "Unauthorized",
    "message": "You don't have the required role to perform this action",
    "status": 401
}
```

or

```
{
    "error": "BadRequest",
    "fields": {
        "email": "must not be blank"
    }
    "status": 400
}
```

#### Config

This package contains the JwtAuthenticationFilter and the SecurityConfiguration and the default handlers for BadRequest, Forbidden, NotFound and Unauthorized.

#### Model

Model is the package where all the models/entities are stored.

#### Repository

Contains all the JPA repositories that integrates with the database.

#### Service

Contains all the services. In this repository you will find the jwt service and user service.

#### Controller

Here are stored all the controllers of the application.

#### Util

Provides the *StringUtil* with the sole method of toPascalCase (from underscore names like HttpStatus are) and *HibernateNamingStrategy* that extends the *CamelCaseToUnderscoresNamingStrategy* so that all the names follow the strategy to snake_case expect ID that must be all uppercase.

## Contributing

Contributions are always welcome!

This project is open source and anyone can make a fork or open an issue.

Surely there are things than can be changed or added. For example this project only uses an access jwt token and not refresh token at all. Or even there is not any test already written. So feel free to contribute!

## Authors

- [@kratess](https://www.github.com/kratess)
