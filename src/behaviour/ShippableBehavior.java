package behaviour;
import models.Weight;

public class ShippableBehavior implements Shippable {
    private final Weight weight;

    public ShippableBehavior(String weight, String unit) {
        this.weight = new Weight(weight, unit);
    }

    @Override
    public String getweight() {
        return weight.getWeight() + " " + weight.getUnit();
    }

    // Add this getter to access the Weight object
    public Weight getWeightObject() {
        return weight;
    }
}
