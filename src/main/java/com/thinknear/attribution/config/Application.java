package com.thinknear.attribution.config;

import com.thinknear.attribution.web.dao.logfile.UserLocationDaoImpl;
import com.thinknear.attribution.web.dao.UserLocationDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.hateoas.HypermediaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.*;

@EnableAutoConfiguration(exclude = {HypermediaAutoConfiguration.class})
@Configuration
@EnableAspectJAutoProxy
@EnableSwagger2
@ComponentScan(basePackages = {"com.thinknear.attribution"})
@PropertySource({"classpath:application.properties" })
public class Application {

    @Autowired
    private Environment env;
  
 
    @Bean(name = "userLocationDao")
    public UserLocationDao userLocationDao() {
        return new UserLocationDaoImpl();
    }

    @Bean
    public Docket swaggerSpringMvcPlugin() {
      return new Docket(DocumentationType.SWAGGER_2)
                  .apiInfo(apiInfo())
                  .select()
                  .paths(paths()) // and by paths
                  .build();
    }

    //Here is an example where we select any api that matches one of these paths
    private Predicate<String> paths() {
      return regex("/attribution/userlocation.*");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("UserLocation API")
                .description("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum " +
                        "has been the industry's standard dummy text ever since the 1500s, when an unknown printer "
                        + "took a " +
                        "galley of type and scrambled it to make a type specimen book. It has survived not only five " +
                        "centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                        "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum " +
                        "passages, and more recently with desktop publishing software like Aldus PageMaker including " +
                        "versions of Lorem Ipsum.")
                .termsOfServiceUrl("http://thinknear.com")
                .contact("ken")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("2.0")
                .build();
    }
   
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}