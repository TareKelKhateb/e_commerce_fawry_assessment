package models;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public boolean isAvailable() {
        return product.getQuantity() >= quantity;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public boolean isShippable() {
        return product.isShippable();
    }

}
