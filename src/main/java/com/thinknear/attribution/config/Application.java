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

@EnableAutoConfiguration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.thinknear.attribution"})
@PropertySource({"classpath:application.properties" })
public class Application {

    @Autowired
    private Environment env;

    @Bean(name = "userLocationDao")
    public UserLocationDao userLocationDao() {
        return new UserLocationDaoImpl();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}