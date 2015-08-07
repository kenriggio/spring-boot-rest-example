package com.thinknear.attribution.config;

//import io.undertow.Undertow.Builder;
//import io.undertow.server.HttpHandler;
//import io.undertow.server.HttpServerExchange;
//import io.undertow.util.Headers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
//import org.springframework.boot.context.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import javax.servlet.Filter;

@Configuration
public class WebConfig {

	static final Logger logger = LoggerFactory.getLogger(WebConfig.class);
	@Bean
    public Filter shallowETagHeaderFilter() {
        return new ShallowEtagHeaderFilter();
    }

    
/*
    @Bean
    public UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {
        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
        factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {

            @Override
            public void customize(Builder builder) {
            	logger.info("customize");
            	/**
            	builder.addHttpListener(9090, "localhost").setHandler(new HttpHandler() {
            		  
                      public void handleRequest(final HttpServerExchange exchange)
                              throws Exception {
                    	  logger.info("handler");
                          exchange.getResponseHeaders().put(Headers.ETAG,
                                  "1234");                
                      }
                  }).build();
            }

        });
        return factory;
    }
  */
}
