# 1. Setup spring project
- go to [start.spring.io](start.spring.io) to generate a project. Dependencies = spring web. and click generate
- import with eclipse
- helps you build production ready apps quickly
- spring boot starter project: Rest API, unit testing depencencies grouped together. Present in pom.xml `spring-boot-starter-web` . Convinient dependency descriptors.
- spring boot auto configuration: automatic configuration. properties are defined in application.properties file. for example, we can change the log level. Whitelabel error page: ErrorMvcAutoConfiguration.
- DevTools: we want to build the applications very very fast, we don't need to restart the server each time we change the code
1. Manage application configuration using profiles: enable to profile environment specific configurations. dev, qa, stage, prod...By default the application does not make use of profiles. We can activate the profiles in the application.properties file
2. Configuration properties: we need to write a class to define the values with _@ConfigurationProperties_ and then specify the vales from the application.properties file.
3. Simplify deployment with embedded servers: The server is already part of the jar file. Run ` mvn clean install `, it will build a jar file. With this jar, we can now run the application.
4. Monitoring: spring boot actuator, beans endpoint, health endpoint, metrics endpoint, mappings endpoint. we have to add these in pom.xml as dependency. you then can go to localhost:8080/actuator. Features can be added via the application properties file.

# 2. Building rest apis
- go to start.spring.io to generate a project
- annotations: @RestController, @RequestMapping, @GetMapping
- Beans: returning a bean gives a json response
- what is happening in the background? we will enable debug logging in the application.conf file.
    + All our requests are going to a DispatcherServlet  - is the first thing that the request goes to.
    + Once received, it will map the request to the right controller
    + AutoConfiguration: this has matched
    + How does the bean get converted to json? @Response body + JacksonHttpMessageConverters
    + Error mapping by default is the result of auto configuration, [ErrorMVCAutoConfiguration](ErrorMVCAutoConfiguration)
    + How are all the jars available to us? Because of starter projects, with spring starter web
- path parameters: @PathVariable annotation
## build a social media application
- create a rest api based on users and posts
- users:
    + retrieve all users: GET /users
    + create a user: POST /users -> use @RequestBody annotation to retrieve the information from the body of the request
    + retrieve one user: GET /users/{id}
    + delete a user: DELETE /users/{id}  -> use @DeleteMapping annotation
- posts:
    + retrieve all posts for a user: get /users/{id}/posts
    + create post for a user: post /users/{id}/posts
    + retrieve details of a post: get /users/{id}/posts/{post_id}
## Return a different status from the default:
```
return ResponseEntity.created(null).build();
```

## Return the uri of the created object:
1. Save the created object in a variable
2. Use the ServletUriComponentsBuilder.fromCurrentRequest().path("").buildAndExpand(savedObject.getId).toUri();
3. fill the location in the ResponseEntity.created(__location__).build();


## Exception handling
1. Modify the findOne function to include the `orElse(null)` directive
2. add error handling into the desired api call with `throw new UserNotFoundException`
3. create the UserNotFoundException class, inheriting from _RuntimeException_
4. Use the @ResponseStatus decorator to modify the return status code

## Custom exception structure
1. Create a custom class to manage the exception, with the structure needed.
2. We want to overwrite the _ResponseEntity<Object>_ defined by default by Spring, for this we have to write a class that extends it.
3. Use the @ExceptionHandler decorator
4. Use the @ControllerAdvice decorator

## Validations
1. We need an additional dependency in the pom.xml file, _spring-boot-starter-validation_
2. We need to use @Valid annotation which will validate that the fields are passed in the query body
3. Annotation: @Size, @Past
4. We can define our own ResponseEntity<Object>

## Documentation
1. Manually maintain documentation
2. Generate from code:
    - Swagger: Swagger specification and swagger tools. Swagger UI. We need to include the dependency and then we can go ahead to localhost:8080/swagger-ui/index.html
    - Open API Specification (based os swagger)

## Content negotiation:
- Different representations of data can be possible: XML, Json,... For xml it is needed to send a header application/xml
- Multiple languages support
- Dependency: jackson-dataformat-xml
,
## Internationalization:
- Use HTTP Request Header: Accept-Language to specify the language
- Define a file _messages.properties_ for each language and use MessageSource + locale

## Versioning
- URL: have different @GetMappings for each version with different URLs
- Request parameter: Add the _params_ argument to the @GetMapping annotation
- Header: Add the _headers_ argument to the @GetMapping annotation
- Media type: Add the _produces_ argument to the @GetMapping annotation

## Hypermedia as the engine of application state
- give information to perform subsequent actions
- custom format and implementation -> is very difficult to mantain
- use some standard -> Json hypertext application language
- _spring-boot-starter-hateoas_
- we want to add a couple links
- entityModel
- WebMvcLinkBuilder

## Customize api responses
- Customize field names in a response: _@JsonProperty_
- Static filtering: _@JsonIgnore_
- Dynamic filtering: MappingJacksonValue & FilterProvider

## Monitoring apis
- Spring boot actuator
- by default, only the health of the application is exposed

## HAL Explorer
- view the apis in a graphical way
- _spring-data-rest-hal-explorer_
