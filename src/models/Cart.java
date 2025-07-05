package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;
    private double totalPrice;
    private int totalQuantity;
    
    public Cart() {
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
        this.totalQuantity = 0;
    }
    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(CartItem item) {
        items.add(item);
        totalPrice += item.getProduct().getPrice() * item.getQuantity();
        totalQuantity += item.getQuantity();
    }
    
    public boolean IsEmbty() {
        return items.isEmpty();
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public int getTotalQuantity() {
        return totalQuantity;
    }

}
