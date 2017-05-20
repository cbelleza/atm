## Synopsis

**ATM** - Expose and receive all ING ATMs.

This application is based on Spring Boot framework and generates a WAR file including all dependencies.

There's a public ING RESTful service on Internet to feed this application, so this URI can be set up manually by the operator later.

To visualize all ATMs you can address the web page **http://localhost:8080/atm/atms**

The REST API exposed is located at **http://localhost:8080/atm/api/v1/atms**

HTTP methods supported by ATM API are:

- **Get all ATMs**
URI: http://localhost:8080/atm/api/v1/atms

- **Filter ATMs by criteria**
For example, to get all ATMs of Beilen city
URI: http://localhost:8080/atm/api/v1/atms?filter=city::Beilen

## API Security
The ATM API uses Basic Authentication as default method. The default values are **user** and **password**.

Those values can be replaced by application property. 

## Build Instructions

Install the Maven client (version 3.* or better). Then clone from GIT and then use Maven:
```
$ git clone ...
$ mvn clean package
```
## Optional settings for application

Define RestFul service using Camel http4 format
```
--camel.atm-uri=http4://www.ing.nl/api/locator/atms/
```
The default log level is "info", case needed it can be changed by the property
```
--logging.level.com.backbase.atm=<level>
```
Change default user authentication
```
--security.user.name=user=new_user
```
```
Change default password authentication
```
--security.user.password=new_password
```

## Deployment process
```
After Maven execution, there will be a new artifact called "atm-1.0.0.war" in folder "/target".

To execute in the WebServer, you must copy this artifact to deployment folder of Tomcat or Wildfly. 
```
## Test classes

- AtmApplicationTests