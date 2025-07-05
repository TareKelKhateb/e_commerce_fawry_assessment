package models;


public class Weight{
    private final String weight;
    private final String unit;
    public Weight(String weight, String unit) {
        this.weight = weight;
        this.unit = unit;
    }
    public String getWeight() {
        return weight;
    }
    public String getUnit() {
        return unit;
    }

    // Returns the weight in kilograms 
    public double getWeightInKg() {
        double w = Double.parseDouble(weight);
        if (unit.equalsIgnoreCase("g")) {
            return w / 1000.0;
        } else if (unit.equalsIgnoreCase("kg")) {
            return w;
        } else {
            // Unknown unit, treat as kg by default
            return w;
        }
    }
}
