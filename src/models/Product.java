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
    public void set_shippableBehavior(ShippableBehavior shippableBehavior) {
        this.shippableBehavior = shippableBehavior;
    }
    public void set_expirationBehavior(ExpirationBehavior expirationBehavior) {
        this.expirationBehavior = expirationBehavior;
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
     public String getWeight() {
        if (isShippable()) {
            return shippableBehavior.getweight();
        }
        return "Not shippable";
    }
   
    public boolean isShippable() {
        return shippableBehavior != null;
    }
   
    public ShippableItem asShippableItem() {
        if (!isShippable()) return null;
        return new ShippableItem() {
            @Override
            public String getName() {
                return Product.this.name;
            }
            @Override
            public double getWeight() {
                try {
                    // Use Weight.getWeightInKg() for correct conversion to kilograms
                    return Product.this.shippableBehavior.getWeightObject().getWeightInKg();
                } catch (Exception e) {
                    return 0.0;
                }
            }
        };
    }
}

