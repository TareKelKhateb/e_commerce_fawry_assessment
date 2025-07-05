package services;
import java.util.List;
import models.ShippableItem;

public class ShippingService {
    // printing the items to be shipped
    public void shipItems(List<ShippableItem> items) {
        for (ShippableItem item : items) {
            System.out.println("Shipping: " + item.getName() + " (" + item.getWeight() + " kg)");
        }
        
        
    }
    //some logic for the shipping service
    public double calculateShippingCost(List<ShippableItem> items) {
        double totalCost = 0.0;
        for (ShippableItem item : items) {
            // Assuming a rate of 3 for each kg
            totalCost += item.getWeight() * 3.0;
        }
        return totalCost;
    }
}