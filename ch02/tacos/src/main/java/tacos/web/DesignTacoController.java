package tacos.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.Taco;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
                new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
                new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
                new Ingredient("CARN", "Carnitas", Type.PROTEIN),
                new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new Ingredient("LETC", "Lettuce", Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Type.CHEESE),
                new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
                new Ingredient("SLSA", "Salsa", Type.SAUCE),
                new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );
        Type[] types = Ingredient.Type.values();
        for (Type type : types)
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
    }

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("design", new Taco());
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors, Model model) {
        if (errors.hasErrors()) return "design";
        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}

/*
*   @Slf4j
*       .
*
*   @Controller
*       adnotacja definiuje klasę jako kontroler w rozumieniu wzorca architektonicznego VMC
*
*   @RequestMapping("/design")
*       Adnotacja łączy klasę z podkatalogiem /design
*
*   @ModelAttribute
*
*   addIngredientModel()
*       przekształca stworzoną (hardcoded) listę dodatków składników na tabelę,
*       której zawartość iterując kolejno przekształca i dodaje do objektu model
*       wywołanego jako parametr wejściowy
*
*   showDesignForm()
*       metoda dodaje do wskazanego modelu (hashmap ?) puste taco pod hasłem "design"
*       i zwraca nazwę
* */

/*
 *  AD 1.
 *   addAttribute()
 *      po weryfikacji prawidłowego zainicjalizowania paremetrów wejściowych (Assert.notNull())
 *      metoda dopisuje je instancji klasy (hashmap) wg schematu
 *          param 1 => klusz,
 *          param 2 => wartość
 * */

/*      źródło package org.springframework.ui: : class ConcurrentModel extends ConcurrentHashMap<String, Object> implements Model

    public ConcurrentModel addAttribute(String attributeName, @Nullable Object attributeValue) {
        Assert.notNull(attributeName, "Model attribute name must not be null");
        Assert.notNull(attributeValue, "ConcurrentModel does not support null attribute value");
        this.put(attributeName, attributeValue);
        return this;
    }*/


