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
        if(!item.isAvailable()) {
            throw new IllegalArgumentException("Item is not available for purchase: " + item.getProduct().getName());
        }
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

    // Print the cart receipt
    public void printCartReceipt() {
        if (isEmpty()) {
            System.out.println("Cart is empty!!! ");
            return;
        }
        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.println(item.getQuantity() + "x " +
                               item.getProduct().getName() + " " +
                               item.getProduct().getPrice());
        }
        System.out.println("Total Price: " + getTotalPrice());
    }

    // Calculate the shipping cost for the items in the cart
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

    // Print the shipping receipt
    // This method prints the shipping receipt for the items in the cart
    public void printShippingReceipt() {
        if (isEmpty()) {
            System.out.println("Cart is empty!!! ");
            return;
        }
        List<ShippableItem> shippableItems = getShippableItems();

        if (shippableItems.isEmpty()) {
            System.out.println("No shippable items in the cart.");
            return;
        }
        // Print the shipping notice
        // This method prints the shipping notice for the items in the cart
        // It calculates the total weight of the shippable items and prints the details
        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;
        for (CartItem item : items) {
            Product product = item.getProduct();
            if (product.isShippable()) {
                double itemWeight=product.asShippableItem().getWeight();
                System.out.println(item.getQuantity() + "x " + product.getName() + " " + itemWeight + "kg");
                totalWeight += itemWeight * item.getQuantity();
            }
        }
        System.out.printf("\n");
        System.out.printf("Total package weight %.1fkg\n", totalWeight );
        System.out.println("Total Shipping Cost: " + getShippingCost());
        System.out.println("=======================================================");
    }

    public double getTotalPriceWithShipping() {
        return getTotalPrice() + getShippingCost();
    }
}

