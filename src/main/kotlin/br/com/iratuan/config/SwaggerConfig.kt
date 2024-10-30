package br.com.iratuan.config

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import io.swagger.v3.oas.models.security.SecurityScheme.Type

@Configuration
class SwaggerConfig {
    @Bean
    fun publicApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("public-apis")
            .pathsToMatch("/**")
            .build()
    }

    @Bean
    fun customOpenApi(): OpenAPI {
        val contact = io.swagger.v3.oas.models.info.Contact()
        contact.name = "Iratuan Junior"
        contact.email = "iratuan@gmail.com"
        contact.url = "http://iratuan.com.br"

        return OpenAPI().info(
            Info().title("API DEMO REST AND SWAGGER")
                .version("API VERSION 1.0")
                .contact(contact)
        )
    }
}
