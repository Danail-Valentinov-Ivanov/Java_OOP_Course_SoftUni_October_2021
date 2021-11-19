package E2_P4_Pizza_Calories;

public class Dough {
    //    - flourType: String
//- bakingTechnique: String
//- weight: double
//+ E2_P4_Pizza_Calories.Dough (String, String, double)
//- setWeight(double): void
//- setFlourType(String): void
//- setBakingTechnique(String): void
//+ calculateCalories (): double
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setWeight(double weight) {
        if (weight < 0 || weight > 200) {
            throw new IllegalArgumentException("E2_P4_Pizza_Calories.Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy")
                && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double calculateCalories() {
        double flourTypeModifier = 0;
        double bakingTechniqueModifier = 0;
        switch (flourType) {
            case "White":
                flourTypeModifier = 1.5;
                break;
            case "Wholegrain":
                flourTypeModifier = 1.0;
                break;
        }
        switch (bakingTechnique) {
            case "Crispy":
                bakingTechniqueModifier = 0.9;
                break;
            case "Chewy":
                bakingTechniqueModifier = 1.1;
                break;
            case "Homemade":
                bakingTechniqueModifier = 1.0;
                break;
        }
        return (2 * weight) * flourTypeModifier * bakingTechniqueModifier;
    }
}
