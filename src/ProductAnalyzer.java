
import java.util.*;
import java.util.stream.Collectors;

class Product {

    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + " (" + category + ", " + price + "₮)";
    }
}

public class ProductAnalyzer {

    public static Map<String, List<Product>> analyze(List<Product> products) {
        return products.stream()
                .filter(p -> p.getPrice() > 1000)
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public static void main(String[] args) {
        List<Product> items = Arrays.asList(
                new Product("Gutal", 1500, "Huvtsas"),
                new Product("Togloom", 800, "Togloom"),
                new Product("Tsamts", 1200, "Huvtsas"));

        Map<String, List<Product>> result = analyze(items);
        result.forEach((cat, list) -> {
            System.out.println("Category: " + cat);
            list.forEach(System.out::println);
        });
    }
}
