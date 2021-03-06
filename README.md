# ATM Core

## Synopsis

The goal of this application is to expose and receive all ATMs from ING bank.

This application is based on Spring Boot framework and generates a WAR file including all dependencies.

There's a public ING RESTful service on the Internet that feeds this application in background, so this URI can be set up manually by the administrator.

To visualize all ATMs you can address the web page **http://localhost:8080/atm/atms**

The REST API exposed supports the following HTTP methods:

- **GET - Find all ATMs**

  For example: http://localhost:8080/atm/api/v1/atms
  
- **GET - Find ATMs by criteria**

  For example, to find all ATMs from Beilen city: http://localhost:8080/atm/api/v1/atms?filter=city::Beilen

## HTTP status codes

- Success: 200
- Not found: 404

## Application security

The default security mechanism is username / password based making use of HTTP Basic Authentication for the authentication process.
 
The default credentials are:

- login: user
- password: user
 
Those values can be replaced by application property too. 

## Prerequisites

You need the following installed and available in your $PATH:

    - Java 8 (http://java.oracle.com)
    - Apache Maven 3.0.4 or greater (http://maven.apache.org/)

## To build from source

Clone remote repository from GitHub and then use Maven:
```
$ git clone ...
$ mvn clean package
```
## Optional properties in Spring Boot

Define external ING ATM RestFul address in Camel http4 format
```
--camel.atm-uri = http4://www.ing.nl/api/locator/atms/
```
The default log level is "info", case needed it can be changed by the property
```
--logging.level.com.backbase.atm = <level>
```
Change default user name in authentication
```
--security.user.name=user = new_user
```
Change default password in authentication
```
--security.user.password = new_password
```

## Deployment process (WAR file)

After Maven execution, there will be a new artifact called "atm-1.0.0.war" in the folder "/target".

To start the application in a WebServer, you must copy that artifact to deployment folder in Tomcat or Wildfly. 

## Test classes

- AtmApplicationTests
