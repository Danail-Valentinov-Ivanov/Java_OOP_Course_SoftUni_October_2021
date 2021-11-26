package E5_Polymorphism.P3_Wild_Farm;

import java.text.DecimalFormat;

public class Cat extends Felime{
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }
//{AnimalType} [{AnimalName}, {CatBreed}, {AnimalWeight},
//{AnimalLivingRegion}, {FoodEaten}]
    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %s, %d]", getAnimalType(), getAnimalName(), breed
                , decimalFormat.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }
}
