import behaviour.*;
import models.*;


public class main {
    public static void main(String[] args) {
      
        // Example usage of the classes
        Product apple = new Product("Apple", 0.5, 100);
        apple.set_shippableBehavior(new ShippableBehavior("1", "kg"));
        
        Customer customer = new Customer("John Doe", 50.0, null);
        CartItem cartItem = new CartItem(apple, 5);

        customer.addToCart(cartItem);
        customer.checkout();
    }

}
