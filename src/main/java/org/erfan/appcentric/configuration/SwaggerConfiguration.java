package org.erfan.appcentric.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Arrays;



@Configuration
@EnableSwagger2WebMvc
@Import({SpringDataRestConfiguration.class})
public class SwaggerConfiguration {
    public static final String AUTH_SERVER = "http://localhost:8083/oauth";
    public static final String CLIENT_ID = "fooClientIdPassword";
    public static final String CLIENT_SECRET = "secret";
    @Bean
    public Docket UserApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("User")
                .select()
                .apis(RequestHandlerSelectors.basePackage(
                        "org.erfan.appcentric.controller.user"))
                .paths(PathSelectors.any())
                .build().securitySchemes(Arrays.asList(securityScheme()))
                .securityContexts(Arrays.asList(securityContext()))
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("User Information")
                                .description("User Information REST API")
                                .version("0.0.1")
                                .license("© Md Erfan Ullah Bhuiyan")
                                .licenseUrl("http://erfanu25.github.io")
                                .contact(
                                        new Contact(
                                                "Md Erfan Ullah Bhuiyan",
                                                "http://erfanu25.github.io",
                                                "mderfan2@gmail.com"))
                                .build());
    }

    @Bean
    public Docket OrderApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Order")
                .select()
                .apis(RequestHandlerSelectors.basePackage(
                        "org.erfan.appcentric.controller.order"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(
                        new ApiInfoBuilder()
                                .title("Order Information")
                                .description("Order Information REST API")
                                .version("0.0.1")
                                .license("© Md Erfan Ullah Bhuiyan")
                                .licenseUrl("http://erfanu25.github.io")
                                .contact(
                                        new Contact(
                                                "Md Erfan Ullah Bhuiyan",
                                                "http://erfanu25.github.io",
                                                "mderfan2@gmail.com"))
                                .build());
    }


    @Bean
    public SecurityConfiguration security() {
        return SecurityConfigurationBuilder.builder()
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_SECRET)
                .scopeSeparator(" ")
                .useBasicAuthenticationWithAccessCodeGrant(true)
                .build();
    }

    private SecurityScheme securityScheme() {
        GrantType grantType = new AuthorizationCodeGrantBuilder()
                .tokenEndpoint(new TokenEndpoint(AUTH_SERVER + "/token", "oauthtoken"))
                .tokenRequestEndpoint(
                        new TokenRequestEndpoint(AUTH_SERVER + "/authorize", CLIENT_ID, CLIENT_SECRET))
                .build();

        SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
                .grantTypes(Arrays.asList(grantType))
                .scopes(Arrays.asList(scopes()))
                .build();
        return oauth;
    }

    private AuthorizationScope[] scopes() {
        AuthorizationScope[] scopes = {
                new AuthorizationScope("read", "for read operations"),
                new AuthorizationScope("write", "for write operations"),
                new AuthorizationScope("foo", "Access foo API") };
        return scopes;
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(
                        Arrays.asList(new SecurityReference("spring_oauth", scopes())))
                .forPaths(PathSelectors.regex("/user.*"))
                .build();
    }
}
