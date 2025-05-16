import java.util.*;
import java.util.function.*;

public class StringProcessor {

    public static void processStrings(List<String> strings,
            Predicate<String> filter,
            Function<String, String> transformer,
            Consumer<String> printer) {

        strings.stream()
                .filter(filter)
                .map(transformer)
                .forEach(printer);
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Programchlal", "Code");

        Predicate<String> filter = s -> s.length() > 4;

        Function<String, String> transformer = s -> {
            String reversed = new StringBuilder(s).reverse().toString();
            return reversed.substring(0, 1).toUpperCase() + reversed.substring(1).toLowerCase();
        };

        Consumer<String> printer = System.out::println;

        processStrings(words, filter, transformer, printer);
    }
}
