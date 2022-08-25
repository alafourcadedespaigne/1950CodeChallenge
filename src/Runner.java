import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {


    /**
     *
     * @return
     */
    private static List<Marbles> exampleSubsetOfBobMarbles() {
        return new ArrayList() {{
            add(new Marbles(1, "blue", "Bob", 0.5));
            add(new Marbles(2, "red", "John Smith", 0.25));
            add(new Marbles(3, "violet", "Bob O'Bob", 0.5));
            add(new Marbles(4, "indigo", "Bob Dad-Bob", 0.75));
            add(new Marbles(5, "yellow", "John", 0.5));
            add(new Marbles(6, "orange", "Bob", 0.25));
            add(new Marbles(7, "blue", "Smith", 0.5));
            add(new Marbles(8, "blue", "Bob", 0.25));
            add(new Marbles(9, "green", "Bobb Ob", 0.75));
            add(new Marbles(10, "blue", "Bob", 0.5));
        }};
    }

    public static boolean isPalindromeIgnoringCapitalizationAndPunctuation(String text) {
        String clean = text.trim().replaceAll("[^A-Za-z]+", "").toLowerCase();
        StringBuilder plain = new StringBuilder(clean);
        StringBuilder reverse = plain.reverse();
        return (reverse.toString()).equals(clean);
    }

    static List<Marbles> orderedListOfMarbles(List<Marbles> exampleList) {



        List<Marbles> resultList = exampleList;
        List<String> definedOrder = // define your custom order
                Arrays.asList("red", "orange", "yellow", "green", "blue", "indigo", "violet");
        Comparator<Marbles> marblesComparator =
                Comparator.comparing(c -> definedOrder.indexOf(c.getColor()));
        resultList.sort(marblesComparator);

        return resultList;


    }

    public static void main(String[] args) {

        boolean a = isPalindromeIgnoringCapitalizationAndPunctuation("Bob Dad-Bob");

        // Cargar la data de ejemplo proporcionada en el documento
        List<Marbles> itemsInit = exampleSubsetOfBobMarbles();

        // Se retorna la misma lista filtrada por las siguientes reglas.
        // 1 - Solo los que tengan peso mayor igual a 0.5
        // 2- Solo los que contengan Nombre palíndrome
        itemsInit = itemsInit.stream().filter((item)
                -> item.getWeight() >= 0.5 && isPalindromeIgnoringCapitalizationAndPunctuation(item.getName()))
                .collect(Collectors.toList());



        // Una vez filtrada la lista se ordena por colores en el siguiente orden (ROYGBIV)
        itemsInit = orderedListOfMarbles(itemsInit);

        // Se imprime por pantalla  finalmente la lista resultante una vez aplicadas
        // las reglas descritas en el enunciado del problema
        for (Marbles item : itemsInit) {
            System.out.println(item.getColor() + "->" + item.getWeight());
        }

    }
}
