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
        if (cart == null || cart.IsEmbty()) {
            throw new IllegalStateException("Cart is empty!!! ");
        }
        
        double totalCost = cart.getTotalPrice();
        if (getBalance() < totalCost) {
            System.out.println("Insufficient balance to complete the purchase.");
            return;
        }
        
        // Deduct the total cost from the customer's balance
        double newbalance = getBalance() - totalCost;
        setBalance(newbalance);
        
        // Clear the cart after checkout
        cart.getItems().clear();
        
        System.out.println("Checkout successful! Remaining balance: " + balance);

    }

}
