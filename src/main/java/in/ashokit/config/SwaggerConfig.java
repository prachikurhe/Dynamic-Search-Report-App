package in.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("REST Dynamic Search Reports API")
                        .version("1.0.0")
                        .description("API documentation for the REST Dynamic Search Reports application"));
//                        .termsOfService("http://swagger.io/terms/")
//                        .contact(new Contact()
//                                .name("Your Name")
//                                .url("http://yourwebsite.com")
//                                .email("your-email@domain.com"))
//                        .license(new License()
//                                .name("Apache 2.0")
//                                .url("http://springdoc.org")));
    }
}


//http://localhost:8080/swagger-ui.html FOR Swagger Doc