package br.com.seiya.barbershop.infraestrutura.configuracao;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	String path = "C:\\Users\\olivi\\OneDrive\\Área de Trabalho\\oli-barber\\seiya-barber-shop-springboot\\src\\main\\resources\\static\\dist";
        registry.addResourceHandler("/dist/**")
                .addResourceLocations(path);
    }

}

