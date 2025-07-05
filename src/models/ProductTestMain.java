package models;
import behaviour.ExpirationBehavior;
import behaviour.ShippableBehavior;
public class ProductTestMain {
    public static void main(String[] args) {
        Product p = new Product("Laptop", 1500.0, 10);

        System.out.println("Name: " + p.getName());
        System.out.println("Price: " + p.getPrice());
        System.out.println("Quantity: " + p.getQuantity());
        System.out.println("Has Expiration: " + p.hasExpiration());
        System.out.println("Is Expired: " + p.isExpired());
        System.out.println("Expiration Date: " + p.getExpirationDate());
        System.out.println("Is Shippable: " + p.isShippable());
        System.out.println("Weight: " + p.getWeight());

        Product p2 = new Product("Milk", 2.5, 20);
        p2.set_expirationBehavior(new ExpirationBehavior("2023-10-31"));
        p2.set_shippableBehavior(new ShippableBehavior("1", "kg"));
        System.out.println("\nName: " + p2.getName());
        System.out.println("Price: " + p2.getPrice());
        System.out.println("Quantity: " + p2.getQuantity());
        System.out.println("Has Expiration: " + p2.hasExpiration());
        System.out.println("Is Expired: " + p2.isExpired());
        System.out.println("Expiration Date: " + p2.getExpirationDate());
        System.out.println("Is Shippable: " + p2.isShippable());
        System.out.println("Weight: " + p2.getWeight());
        System.out.println("Is Shippable: " + p2.isShippable());

    }
}