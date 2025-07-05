## Project Structure

```
README.md
src/
    App.class
    App.java
    behaviour/
        Expiration.class
        Expiration.java
        ExpirationBehavior.class
        ExpirationBehavior.java
        Shippable.class
        Shippable.java
        ShippableBehavior.class
        ShippableBehavior.java
    models/
        Cart.class
        Cart.java
        CartItem.class
        CartItem.java
        Customer.class
        Customer.java
        Product.class
        Product.java
        ShippableItem.class
        ShippableItem.java
        Weight.class
        Weight.java
    services/
        ShippingService.class
        ShippingService.java
```

## Example Output (`App.java`)

### Output Explanation

### The following are the four use cases demonstrated by the output:


### Four Use Cases

1. Working use case with valid products and customer checkout
2. Error: Cart is empty
3. Error: Insufficient balance
4. Error: Product out of stock
5. Error: Product expired

```
****=== Working use case ===****
** Checkout receipt **
2x Cheese 200.0
1x Biscuits 150.0
3x Chocolate 100.0
Total Price: 850.0
=======================================================
** Shipment notice **
2x Cheese 0.4kg
1x Biscuits 0.7kg

Total package weight 1.5kg
Total Shipping Cost: 3.3
=======================================================
Total Price with Shipping: 853.3

Checkout successful! Remaining balance: 146.70000000000005

****=== Error 1: Cart is empty ===****
Caught error 1 (Cart is empty): Cart is empty. Please add items to the cart before checkout.   

****=== Error 2: Insufficient balance ===****
** Checkout receipt **
1x Cheese 200.0
Total Price: 200.0
=======================================================
** Shipment notice **
1x Cheese 0.4kg

Total package weight 0.4kg
Total Shipping Cost: 1.2000000000000002
=======================================================
Total Price with Shipping: 201.2

Caught error 2 (Insufficient balance): Insufficient balance for checkout. Total price: 201.2, Available balance: 10.0
Total Shipping Cost: 1.2000000000000002
=======================================================
Total Price with Shipping: 201.2

Caught error 2 (Insufficient balance): Insufficient balance for checkout. Total price: 201.2, Available balance: 10.0

****=== Error 3: Product out of stock ===****
Caught error 3 (Product out of stock): Item is not available for purchase: Rare Item

****=== Error 4: Product expired ===****
Caught error 4 (Product expired): Item is expired: Old Milk2020-01-01
```
