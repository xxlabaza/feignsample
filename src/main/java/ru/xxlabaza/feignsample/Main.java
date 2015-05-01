package ru.xxlabaza.feignsample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource;

/**
 *
 * @author Artem Labazin
 *
 * @since May 1, 2015 | 8:03:40 PM
 *
 * @version 1.0.0
 */
@EnableHystrix
@EnableEurekaClient
@EnableFeignClients
@EnableOAuth2Resource
@SpringBootApplication
public class Main {

    public static void main (String[] args) {
        new SpringApplicationBuilder(Main.class)
                .web(true)
                .run(args);
    }
}
