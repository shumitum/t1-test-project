package com.t1.testproject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "API тестового задания для Т1",
                version = "1.0"),

        servers = @Server(
                description = "Test Server",
                url = "http://localhost:8080"
        )
)
public class OpenApiConfig {
}
