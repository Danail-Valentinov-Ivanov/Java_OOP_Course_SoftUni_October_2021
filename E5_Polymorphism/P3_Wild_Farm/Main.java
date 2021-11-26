package E5_Polymorphism.P3_Wild_Farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();
        String inputAnimal = scanner.nextLine();
        while (!inputAnimal.equals("End")) {
            Animal animal = getAnimal(inputAnimal);

            String[] foodData = scanner.nextLine().split("\\s+");
            Food food = getFood(foodData);

            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
            animals.add(animal);
            inputAnimal = scanner.nextLine();
        }
        animals.forEach(e -> System.out.println(e));
    }

    private static Food getFood(String[] foodData) {
        String foodType = foodData[0];
        int foodQuantity = Integer.parseInt(foodData[1]);
        if (foodType.equals("Vegetable")) {
            return new Vegetable(foodQuantity);
        }
        return new Meat(foodQuantity);
    }

    private static Animal getAnimal(String inputAnimal) {
        String[] animalData = inputAnimal.split("\\s+");
        String animalType = animalData[0];
        String animalName = animalData[1];
        Double animalWeight = Double.parseDouble(animalData[2]);
        String animalLivingRegion = animalData[3];
        switch (animalType) {
            case "Cat":
                String catBreed = animalData[4];
                return new Cat(animalName, animalType, animalWeight, animalLivingRegion, catBreed);
            case "Tiger":
                return new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
            case "Zebra":
                return new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
            case "Mouse":
                return new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
            default:
                throw new IllegalArgumentException("No such animal");
        }
    }
}
