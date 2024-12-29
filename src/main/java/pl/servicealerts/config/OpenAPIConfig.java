package pl.servicealerts.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Contact contact = new Contact();
        contact.setEmail("nut.t@icloud.com");
        contact.setName("Timur S.");
        contact.setUrl("https://tsimursh.github.io/personal-website/");

        Info info = new Info();
        info.title("Service Alerts API Manager");
        info.version("1.0");
        info.contact(contact);
        info.description("Service-alert api allow you to provide updates whenever there is disruption on the network. " +
                "Delays and cancellations of individual trips should usually be communicated using Trip updates.");

        SecurityScheme securityScheme = new SecurityScheme();
        securityScheme.setType(SecurityScheme.Type.HTTP);
        securityScheme.setScheme("basic");
        securityScheme.setDescription("Basic Authentication");

        Components authentication = new Components().addSecuritySchemes("basicAuth", securityScheme);

        OpenAPI openApi = new OpenAPI();
        openApi.setComponents(authentication);
        openApi.info(info);
        return openApi;
    }
}
