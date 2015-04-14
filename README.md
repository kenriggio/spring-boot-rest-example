
A skeleton project using Spring 4.x, Spring Boot, SpringMVC, Spring AOP, and Swagger.

This is a work in progress, but starts to illustrate the basics of Spring 4.x, using Spring MVC.

The package structure is not what I consider ideal. I would typically have two different models, one to represent the web model and one to represent the persistence model.  Along with a service that is not bound to Spring or SpringMVC, such that the API and its implementation is not bound to the web service bindings, but more on that later.

### TO RUN:

```
> mvn clean package
> java -jar target/attribution-service-1.0-SNAPSHOT.jar
```


- API Documentation:

```
http://localhost:8080/swagger/index.html
```

### References

1. [Building a Hypermedia-Driven RESTful Web Service](http://spring.io/guides/gs/rest-hateoas/)
2. [SpringMVC full config](https://samerabdelkafi.wordpress.com/2014/08/03/spring-mvc-full-java-based-config/)
3. [Spring HATEOAS](http://azagorneanu.blogspot.com/2013/06/hateoas-using-spring-framework.html)
4. [Swagger + Spring Boot](http://www.javacodegeeks.com/2015/03/spring-boot-swagger-ui.html)
5. [How To: Embedded Servlet Containers](http://docs.spring.io/spring-boot/docs/current/reference/html/howto-embedded-servlet-containers.html)

### References not used in this example, but useful

1. [Creating Asynchronous Methods](http://spring.io/guides/gs/async-method/)
 
 

