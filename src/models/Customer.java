package models;

public class Customer {
    private String name;
    private double  balance;
    private Cart cart;

    public Customer(String name, double  balance, Cart cart) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double  getBalance() {
        return balance;
    }
    public void setBalance(double  balance) {
        this.balance = balance;
    }

    // adding an item to the cart(customer)
    public void addToCart(CartItem item) {
        if (cart == null) {
            cart = new Cart();
        }
        cart.addItem(item);
    }
    
    public void checkout(){

        if (cart == null || cart.isEmpty()) {
            System.out.println("Cart is empty!!! ");
            return;
        }
        cart.printCartReceipt();
        System.out.println("=======================================================");
        cart.printShippingReceipt();
        double totalPrice = cart.getTotalPriceWithShipping();
        System.out.println("Total Price with Shipping: " + totalPrice + "\n");
        if (balance < totalPrice) {
            throw new IllegalArgumentException("Insufficient balance for checkout. Total price: " + totalPrice + ", Available balance: " + balance);
        }
        balance -= totalPrice;
        System.out.println("Checkout successful! Remaining balance: " + balance);
        cart = new Cart(); // Clear the cart after checkout

    }

}
