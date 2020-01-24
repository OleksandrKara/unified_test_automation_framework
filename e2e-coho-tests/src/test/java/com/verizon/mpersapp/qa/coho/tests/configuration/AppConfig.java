
package com.verizon.mpersapp.qa.coho.tests.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("com.verizon.mpersapp.qa.coho")
@PropertySources({
        @PropertySource("classpath:env/${COHO_ENV:pre-prod}.properties"),
        @PropertySource("classpath:endpoints/endpoints.properties"),
        @PropertySource("classpath:app/app.properties"),
})
public class AppConfig {
    @Autowired
    private Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public RestTemplate restTemplate1() {
        return new RestTemplate();
    }
}
