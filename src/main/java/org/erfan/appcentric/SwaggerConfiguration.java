package org.erfan.appcentric;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


@Configuration
@EnableSwagger2WebMvc
@Import({SpringDataRestConfiguration.class})
public class SwaggerConfiguration {
    @Bean
    public Docket CustomerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Customer")
                .select()
                .apis(RequestHandlerSelectors.basePackage(
                        "org.erfan.appcentric.controller.customer"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("Customer Information")
                                .description("Customer Information REST API")
                                .version("0.0.1")
                                .license("© Md Erfan Ullah Bhuiyan")
                                .licenseUrl("http://appcentric.github.io")
                                .contact(
                                        new Contact(
                                                "Md Erfan Ullah Bhuiyan",
                                                "http://appcentric.github.io",
                                                "mderfan2@gmail.com"))
                                .build());
    }

    @Bean
    public Docket UserApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Order")
                .select()
                .apis(RequestHandlerSelectors.basePackage(
                        "org.erfan.appcentric.controller.order"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("Customer Information")
                                .description("Customer Information REST API")
                                .version("0.0.1")
                                .license("© Md Erfan Ullah Bhuiyan")
                                .licenseUrl("http://appcentric.github.io")
                                .contact(
                                        new Contact(
                                                "Md Erfan Ullah Bhuiyan",
                                                "http://appcentric.github.io",
                                                "mderfan2@gmail.com"))
                                .build());
    }
}
