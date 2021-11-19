package E2_P4_Pizza_Calories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputPizza = scanner.nextLine().split("\\s+");
        String namePizza = inputPizza[1];
        int numberOfToppings = Integer.parseInt(inputPizza[2]);

        Pizza pizza;
        try {
            pizza = new Pizza(namePizza, numberOfToppings);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] inputDough = scanner.nextLine().split("\\s+");
        String flourType = inputDough[1];
        String bakingTechnique = inputDough[2];
        double weight = Double.parseDouble(inputDough[3]);

        try {
            Dough dough = new Dough(flourType, bakingTechnique, weight);
            pizza.setDough(dough);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String toppingInfo = scanner.nextLine();
        while (!toppingInfo.equals("END")) {
            String[] toppingsData = toppingInfo.split("\\s+");
            String toppingType = toppingsData[1];
            double weightTopping = Double.parseDouble(toppingsData[2]);
            toppingInfo = scanner.nextLine();

            try {
                Topping topping = new Topping(toppingType, weightTopping);
                pizza.addTopping(topping);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.printf("%s - %.2f\n", pizza.getName(), pizza.getOverallCalories());
    }
}
