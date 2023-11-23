package ru.iorikimura.elitejavaapp.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "token")
public class TokenProperties {

    private String secret;

    private String timeToLive;
}
