package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Observable;

@Data
@AllArgsConstructor
@Builder
public class Product extends Observable {

    private String name;
    private double price;
    private int quantity;
    private Double discountPercentage;

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
        setChanged();
        notifyObservers(this);
    }

    public double getPrice() {
        return discountPercentage != null ? (price - (price * discountPercentage)):(price);
    }

}
