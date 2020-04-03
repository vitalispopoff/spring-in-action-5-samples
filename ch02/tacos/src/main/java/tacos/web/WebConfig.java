package tacos.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry
                .addViewController("/")
                .setViewName("home");
    }
}

/*
*   @Configuration
*       .
*
*   @Override
*       .
*
*   WebMvcConfigurer
*       .
*
*   addViewController()
*       do wybranego obiektu registry dodaje kontekst:
*           pośredni adres url (tuta: "/")
*           oraz obsługę (?) raportów połaczenia HTTP
*       powyższe łączy z nazwą stosownego pliku html z katalogu resources (tutaj: home.html)
*
* */