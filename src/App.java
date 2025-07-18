import behaviour.*;
import models.*;

/*  Note : only this part of the code  is generated by  AI (USE_CASES)
*/
// The rest of the code is provided by the ME 

// FOUR USE CASES
// 1. Working use case with valid products and customer checkout
// 2. Error: Cart is empty
// 3. Error: Insufficient balance
// 4. Error: Product out of stock
// 5. Error: Product expired

public class App {
    public static void main(String[] args) {
        // Working use case
        System.out.println("****=== Working use case ===****");
        Product cheese = new Product("Cheese", 200, 400);
        cheese.set_shippableBehavior(new ShippableBehavior("400", "g"));
        cheese.set_expirationBehavior(new ExpirationBehavior("2026-12-31"));

        Product biscuits = new Product("Biscuits", 150, 700);
        biscuits.set_shippableBehavior(new ShippableBehavior("700", "g"));
        biscuits.set_expirationBehavior(new ExpirationBehavior("2026-01-15"));

        Product chocolate = new Product("Chocolate", 100, 10); // Not shippable
        chocolate.set_expirationBehavior(new ExpirationBehavior("2026-11-30"));

        Customer customer = new Customer("John Doe", 1000.0, null);

        CartItem cheeseItem = new CartItem(cheese, 2);
        CartItem biscuitsItem = new CartItem(biscuits, 1);
        CartItem chocolateItem = new CartItem(chocolate, 3);

        customer.addToCart(cheeseItem);
        customer.addToCart(biscuitsItem);
        customer.addToCart(chocolateItem);

        customer.checkout();

        // Error 1: Cart is empty
        System.out.println("\n****=== Error 1: Cart is empty ===****");
        Customer emptyCartCustomer = new Customer("Jane Doe", 500.0, null);
        try {
            emptyCartCustomer.checkout();
        } catch (Exception e) {
            System.out.println("Caught error 1 (Cart is empty): " + e.getMessage());
        }

        // Error 2: Insufficient balance
        System.out.println("\n****=== Error 2: Insufficient balance ===****");
        Customer lowBalanceCustomer = new Customer("Richie Poor", 10.0, null);
        try {
            lowBalanceCustomer.addToCart(new CartItem(cheese, 1));
            lowBalanceCustomer.checkout();
        } catch (Exception e) {
            System.out.println("Caught error 2 (Insufficient balance): " + e.getMessage());
        }

        // Error 3: Product out of stock
        System.out.println("\n****=== Error 3: Product out of stock ===****");
        Product limitedStock = new Product("Rare Item", 50, 1);
        limitedStock.set_expirationBehavior(new ExpirationBehavior("2026-12-31"));
        try {
            Customer stockCustomer = new Customer("Stock Tester", 1000.0, null);
            stockCustomer.addToCart(new CartItem(limitedStock, 2)); // Only 1 in stock
        } catch (Exception e) {
            System.out.println("Caught error 3 (Product out of stock): " + e.getMessage());
        }

        // Error 4: Product expired
        System.out.println("\n****=== Error 4: Product expired ===****");
        Product expiredProduct = new Product("Old Milk", 10, 5);
        expiredProduct.set_expirationBehavior(new ExpirationBehavior("2020-01-01")); // Already expired
        try {
            Customer expiredCustomer = new Customer("Expired Tester", 1000.0, null);
            expiredCustomer.addToCart(new CartItem(expiredProduct, 1));
        } catch (Exception e) {
            System.out.println("Caught error 4 (Product expired): " + e.getMessage());
        }
    }

}
