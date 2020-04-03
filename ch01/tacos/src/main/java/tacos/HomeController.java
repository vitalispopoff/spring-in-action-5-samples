package tacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}

/*
*   @Controller
*       wyspecjalizowana wersja adnotacji @Component umożliwiająca auomatyczne rozpoznanie klasy
*       jako kontrolera w rozumieniu wzorca MVC (model-view-controller), tzn. że oznaczona klasa
*       przyjmuje dane wejściowe od użytkownika i w odpowiedzi na nie inicjuje stosowne reakcje.
*
*       Klasy z adnotacją @Controller posiadają zazwyczaj metody oznaczane adnotacją z rodziny
*       @RequestMapping
*
*
*   @GetMapping
*       zaktualizowana wersja adnotacji @RequestMapping(method=RequestMethod.GET)
*       na potrzeby uproszczenia kodu funkcje pierwotnego @RequestMapping
*       przejęły wyspecjalizowane:
*               @GetMapping,
*               @PostMapping,
*               @PutMapping,
*               @DeleteMapping,
*               @PatchMapping,
*       które stosowane są w odniesieniu do stosownych typów żądań HTTP
*
*   home()
*       metoda jest wywoływana (przez adnotację @GetMapping) w odpowiedzi
*       na żądanie GET przekazuje ciąg znaków potrzebny do wygenerowania
*       przekierowania żądania na właściwy plik html
*       (w tym przypadku "home" na home.html)
*
* */