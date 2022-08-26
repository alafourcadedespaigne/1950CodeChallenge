import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {


    /**
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

        // Load the sample data provided in the document
        List<Marbles> itemsInit = exampleSubsetOfBobMarbles();

        //The same list is returned filtered by the following rules.
        // 1- Only those with a weight greater than 0.5
        // 2- Only those containing Name palindrome
        itemsInit = itemsInit.stream().filter((item)
                        -> item.getWeight() >= 0.5 && isPalindromeIgnoringCapitalizationAndPunctuation(item.getName()))
                .collect(Collectors.toList());


        // Once filtered, the list is sorted by colors in the following order (ROYGBIV)
        itemsInit = orderedListOfMarbles(itemsInit);

        //Finally, the resulting list is printed on the screen once applied
        //the rules described in the statement of the problem
        for (Marbles item : itemsInit) {
            System.out.println(item.getColor() + "->" + item.getWeight());
        }

    }
}
