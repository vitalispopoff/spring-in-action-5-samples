package tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }
}

/*
*   @SpringBootApplication
*      Adnotacja jest równoważnikiem kombinacji trzech głónych adnotacji rozruchowych SpringBooota (?)
*           @Configuration
*           @EnableAutoConfiguration
*           @ComponentScan (skanowanie pakietów projektu począwszy od pakietu z tą adnotacją)
*       z domyślnymi wartościami ich parametrów.
*
*   SpringApplication.run()
*       Domyślna metoda rozruchowa frameworku Spring (?).
*
* */