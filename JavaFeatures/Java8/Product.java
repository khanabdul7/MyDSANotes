package JavaFeatures.Java8;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

//This class contain Java 8 excercises.
public class Product {

    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static void main(String args[]) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(101, "Laptop1", 40000f));
        productList.add(new Product(102, "Laptop2", 30000f));
        productList.add(new Product(103, "Laptop3", 28000f));
        productList.add(new Product(104, "Laptop4", 28000f));
        productList.add(new Product(105, "Laptop5", 45000f));

        //making stream of products, filtering , mapping and printing
        productList.stream().filter(p->p.price>30000).map(p->p.name).forEach(System.out::println);

        //making stream of products, filtering , mapping, collecting and printing
        List<String> productNames = productList.stream().filter(p->p.price>30000).map(p->p.name).collect(Collectors.toList());
        System.out.println(productNames);

        //Using Consumer Interface to display values
        Consumer<String> display = a -> System.out.println(a);

        //calling display (Since consumer interface have accept() method)
        display.accept("Abdul");

        
    }

}
