package com.thinknear.attribution.config;

import com.thinknear.attribution.web.dao.logfile.UserLocationDaoImpl;
import com.thinknear.attribution.web.dao.UserLocationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.*;


@EnableAutoConfiguration
@EnableAspectJAutoProxy
@EnableSwagger
@ComponentScan(basePackages = {"com.thinknear.attribution"})
@PropertySource({"classpath:application.properties" })
public class Application {

    @Autowired
    private Environment env;

    @Bean(name = "userLocationDao")
    public UserLocationDao userLocationDao() {
        return new UserLocationDaoImpl();
    }

    private SpringSwaggerConfig springSwaggerConfig;

    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }

    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
        //This info will be used in Swagger. See realisation of ApiInfo for more details.
                .apiInfo(new ApiInfo(
                        "Attribution API",
                        "This service captures attribution data",
                        null,
                        null,
                        null,
                        null
                        ))
                 //Here we disable auto generating of responses for REST-endpoints
                .useDefaultResponseMessages(false)
                //Here we specify URI patterns which will be included in Swagger docs. Use regex for this purpose.
                .includePatterns("/attribution.*");
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}