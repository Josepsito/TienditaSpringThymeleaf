package com.deconfort.tiendavirtual.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Config {

    @Bean
    public List<String> categorias(){

        return List.of("Niños y bebes","Tecnologia","Cocina","Dormitorio","Bebidas","Limpieza",
                "Mascotas","Hogar","Deporte","Ropa","Cuidado y Belleza");
    }
}
