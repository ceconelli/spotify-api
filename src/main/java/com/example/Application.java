package com.example;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "Spotify App",
                version = "1.0",
                description = "Spotify API"))
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}