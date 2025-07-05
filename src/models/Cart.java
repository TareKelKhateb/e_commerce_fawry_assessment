package models;

import java.util.ArrayList;
import java.util.List;
import services.ShippingService;

public class Cart {
    private final List<CartItem> items;
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
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public int getTotalQuantity() {
        return totalQuantity;
    }

    //getting the shippable items from the cart
    public List<ShippableItem> getShippableItems() {
        List<ShippableItem> shippableItems = new ArrayList<>();
        for (CartItem item : items) {
            Product product = item.getProduct();
            if (product.isShippable()) {
                ShippableItem shippable = product.asShippableItem();
                shippableItems.add(shippable);
            }
        }
        return shippableItems;
    }

    public void printCartReceipt() {
        if (isEmpty()) {
            System.out.println("Cart is empty!!! ");
            return;
        }
        for (CartItem item : items) {
            System.out.println("Product: " + item.getProduct().getName() +
                               ", Quantity: " + item.getQuantity() +
                               ", Price: " + item.getProduct().getPrice());
        }
        System.out.println("Total Price: " + getTotalPrice());
    }

    public double getShippingCost() {
        if (isEmpty()) {
            System.out.println("Cart is empty!!! ");
            return 0.0;
        }
        ShippingService shippingService = new ShippingService();
        List<ShippableItem> shippableItems = getShippableItems();

        if (shippableItems.isEmpty()) {
            System.out.println("No shippable items in the cart.");
            return 0.0;
        }

        double shippingCost = shippingService.calculateShippingCost(shippableItems);
        return shippingCost;
    }

    public void printShippingReceipt() {
        if (isEmpty()) {
            System.out.println("Cart is empty!!! ");
            return;
        }
        ShippingService shippingService = new ShippingService();
        List<ShippableItem> shippableItems = getShippableItems();

        if (shippableItems.isEmpty()) {
            System.out.println("No shippable items in the cart.");
            return;
        }
        System.out.println("Shipping Receipt:");
        shippingService.shipItems(shippableItems);
        System.out.println("Total Shipping Cost: " + getShippingCost());
    }

    public double getTotalPriceWithShipping() {
        return getTotalPrice() + getShippingCost();
    }
}

