package ru.iorikimura.elitejavaapp.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfiguration {

    //Настройка Swagger для общих контроллеров, которые находятся в '/v1/**'
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("shop-public")
                .pathsToExclude("!/v1/**")
                .build();


    }
}
