package E3_Inheritance.animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentAnimal = scanner.nextLine();
        while (!currentAnimal.equals("Beast!")) {
            String[] currentAnimalData = scanner.nextLine().split("\\s+");
            String name = currentAnimalData[0];
            int age = Integer.parseInt(currentAnimalData[1]);
            String gender = currentAnimalData[2];
            try {
                switch (currentAnimal) {
                    case "Dog":
                        Dog dog = new Dog(name, age, gender);
                        System.out.println(dog);
                        break;
                    case "Cat":
                        Cat cat = new Cat(name, age, gender);
                        System.out.println(cat);
                        break;
                    case "Frog":
                        Frog frog = new Frog(name, age, gender);
                        System.out.println(frog);
                        break;
                    case "Kittens":
                        Kitten kitten = new Kitten(name, age);
                        System.out.println(kitten);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(name, age);
                        System.out.println(tomcat);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            currentAnimal = scanner.nextLine();
        }
    }
}
