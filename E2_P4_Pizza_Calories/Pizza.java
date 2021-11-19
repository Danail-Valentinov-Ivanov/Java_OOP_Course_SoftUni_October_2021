package E2_P4_Pizza_Calories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    //    - name: String
//- dough: E2_P4_Pizza_Calories.Dough
//- toppings: List&lt;E2_P4_Pizza_Calories.Topping&gt;
//+ E2_P4_Pizza_Calories.Pizza (String, int numberOfToppings)
//- setToppings(int) : void
//- setName(String) : void
//+ setDough(E2_P4_Pizza_Calories.Dough) : void
//+ getName(): String
//+ addTopping (E2_P4_Pizza_Calories.Topping) : void
//+ getOverallCalories () : double
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("E2_P4_Pizza_Calories.Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double sumToppingsCalories = 0.0;
        for (Topping topping : toppings) {
            sumToppingsCalories += topping.calculateCalories();
        }
        return this.dough.calculateCalories() + sumToppingsCalories;
    }
}
