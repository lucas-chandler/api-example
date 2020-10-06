# API Example

A simple JAX-RS REST service.

## Building

The Jar and War can be built using maven. Execute the following at the project root.

    mvn clean install

The docker is built using the docker-maven-plugin. After the war has been packaged navigate to
 the service module root and execute the maven command:
 
    mvn docker:build

## Executing

### jetty-maven-plugin

The war can be executed by itself using the [jetty-maven-plugin](https://www.eclipse.org/jetty/documentation/current/jetty-maven-plugin.html).
Note that the base url of the assessment service is configured via the environment variable
 BASE_ASSESSMENT_URL.

## docker-maven-plugin

The docker image can also be executed via maven. The pom contains configuration for the ports and
 environment variables so that the following command can be executed to run via maven from the
  service module root:
  
    mvn docker:run

### Docker only

I wasn't counting on everyone to have maven and java installed on their machines in order to run
 this so I built and tagged an image on docker hub. The image has a different name so that I
  could upload it to an existing docker hub namespace that already existed.
   
  The image can be pulled and executed with the docker commands:
 
    docker pull l2lucidream/api-example-service:latest
    docker run -it -p 127.0.0.1:8080:8080/tcp -eBASE_ASSESSMENT_URL=https://assessment-service.liquidfish.xyz l2lucidream/api-example-service:latest

## Swagger

The REST endpoints should be documented via swagger. Once the image is running the swagger
 UI is available at http://127.0.0.1:8080/meta/swagger/ui .

