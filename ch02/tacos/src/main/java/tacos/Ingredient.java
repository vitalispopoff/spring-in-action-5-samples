package tacos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {

    private final String
            id,
            name;
    private final Type type;

    public static enum Type {
        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE
    }
}

/*
*   @Data (https://projectlombok.org/features/Data)
*       Adnotacja, która łącząc funkcje adnotacji
*           @ToSTring
*           @EqualsAndHshCode
*           @Getter / @Setter
*           @RequiredArgsConstructor
*       wymusza generowanie boilerplate'u
*
*   @RequiredArgsConstructor
*       adnotacja wymurza wygenerowanie konstruktora z ustalonymi argumentami,
*       które są dekretowane jako final. lub final z dodatkowymi adnotacjami, np @NonNull
* */