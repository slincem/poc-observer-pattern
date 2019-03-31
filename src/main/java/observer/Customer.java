package observer;

import lombok.Data;
import model.Product;

import java.util.Observable;
import java.util.Observer;

@Data
public class Customer implements Observer {

    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void wantToBeNotifiedOf(Product product){
        System.out.println("Now " + name + " is subcribed to: " + product.getName());
        product.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        Product productWithDiscount = (Product) arg;

        buyProduct(productWithDiscount);
    }

    private void buyProduct(Product productWithDiscount) {
        productWithDiscount.setQuantity(productWithDiscount.getQuantity() - 1);
        System.out.println("Customer: " + name + " bought: " + productWithDiscount);
    }
}
