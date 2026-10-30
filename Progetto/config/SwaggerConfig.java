package main.postgresserver.springboot.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.*;


@Configuration
@OpenAPIDefinition
public class SwaggerConfig {
    /**
     * Configura un'istanza personalizzata di OpenAPI.
     *
     * @return Un oggetto OpenAPI configurato con titolo, versione e descrizione delle API.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Nome del Tuo Server API")
                        .version("1.0")
                        .description("Descrizione delle tue API"));
    }
}
