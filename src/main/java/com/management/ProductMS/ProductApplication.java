package com.management.ProductMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2

public class ProductApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
	@Bean
    public Docket CustomerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
               .select()

               .apis(RequestHandlerSelectors.basePackage("com.management.ProductMS"))
               .build().apiInfo(apiDetails());
    }
 
 private ApiInfo apiDetails() {
        ApiInfo apiInfo = new ApiInfo(
                "Product API",
                "This API will provide information about Product details",
                "1.0.0",
                "Free to use",
                "prod@org.com",
                "API license: Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0.html");

        return apiInfo;
    }
}