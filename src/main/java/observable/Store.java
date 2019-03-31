package observable;

import lombok.Data;
import model.Product;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Data
public class Store implements Runnable{

    private String name;
    private List<Product> products;

    public Store(String name) {
        this.name = name;

        products = Arrays.asList(
                Product.builder().name("S10").price(3000000).quantity(10).build(),
                Product.builder().name("Xs Max").price(3500000).quantity(20).build(),
                Product.builder().name("Airpods").price(650000).quantity(20).build(),
                Product.builder().name("Buds").price(500000).quantity(20).build());
    }

    public void run() {

        while(true) {
            Integer productPosition = new Random().nextInt(products.size());
            Product currentProduct = products.get(productPosition);

            System.out.println("Current product before the discount: " + currentProduct);
            currentProduct.setDiscountPercentage(10.0);
            System.out.println("Current product after the discount: " + currentProduct);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            products.get(productPosition).setDiscountPercentage(null);
        }

    }
}
