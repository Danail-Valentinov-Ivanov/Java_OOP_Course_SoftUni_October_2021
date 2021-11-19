package E2_P4_Pizza_Calories;

public class Topping {
    //    - toppingType: String
//- weight: double
//+ E2_P4_Pizza_Calories.Topping (String, double)
//- setToppingType (String): void
//- setWeight (double): void
//+ calculateCalories (): double
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.toppingType = toppingType;
                break;
            default:
                throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza."
                        , toppingType));
        }
    }

    private void setWeight(double weight) {
        if (weight < 0 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50]."
                    , toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double toppingTypeModifier = 0;
        switch (toppingType) {
            case "Meat":
                toppingTypeModifier = 1.2;
                break;
            case "Veggies":
                toppingTypeModifier = 0.8;
                break;
            case "Cheese":
                toppingTypeModifier = 1.1;
                break;
            case "Sauce":
                toppingTypeModifier = 0.9;
                break;
        }
        return (2 * weight) * toppingTypeModifier;
    }
}
