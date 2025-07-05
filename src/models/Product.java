package models;
import behaviour.ExpirationBehavior;
import behaviour.ShippableBehavior;





public class Product {
    private String name;
    private double price;
    private int quantity;
    private ExpirationBehavior expirationBehavior;
    private ShippableBehavior shippableBehavior;


    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public boolean hasExpiration() {
        return expirationBehavior != null;
    }
    public boolean isExpired() {
        if (hasExpiration()) {
            return expirationBehavior.isExpired();
        }
        return false;
    }
    public String getExpirationDate() {
        if (hasExpiration()) {
            return expirationBehavior.getExpirationDate();
        }
        return "No expiration date";
    }
   
    public boolean isShippable() {
        return shippableBehavior != null;
    }
    public String getWeight() {
        if (isShippable()) {
            return shippableBehavior.getweight();
        }
        return "Not shippable";
    }
}

