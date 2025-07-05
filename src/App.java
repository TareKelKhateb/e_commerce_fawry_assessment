import behaviour.*;
import models.*;


public class App {
    public static void main(String[] args) {
     
        Product cheese = new Product("Cheese", 200, 400);
        cheese.set_shippableBehavior(new ShippableBehavior("400", "g"));

        Product biscuits = new Product("Biscuits", 150, 700);
        biscuits.set_shippableBehavior(new ShippableBehavior("700", "g"));

        Product chocolate = new Product("Chocolate", 100, 10); // Not shippable

        Customer customer = new Customer("John Doe", 1000.0, null);

        CartItem cheeseItem = new CartItem(cheese, 2);
        CartItem biscuitsItem = new CartItem(biscuits, 1);
        CartItem chocolateItem = new CartItem(chocolate, 3);

        customer.addToCart(cheeseItem);
        customer.addToCart(biscuitsItem);
        customer.addToCart(chocolateItem);

        customer.checkout();
    }

}
