package E4_Interfaces_and_Abstraction.P3_Birthday_Celebrations;

import E4_Interfaces_and_Abstraction.P3_Birthday_Celebrations.Birthable;
import E4_Interfaces_and_Abstraction.P3_Birthday_Celebrations.Citizen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Birthable> listBirthableObjects = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] inputData = input.split("\\s+");
            String typeObject = inputData[0];
            switch (typeObject) {
                case "E4_Interfaces_and_Abstraction.P3_Birthday_Celebrations.E4_Interfaces_and_Abstraction.P4_Food_Shortage.Citizen":
                    String name = inputData[1];
                    int age = Integer.parseInt(inputData[2]);
                    String id = inputData[3];
                    String birthDate = inputData[4];
                    Citizen citizen = new Citizen(name, age, id, birthDate);
                    listBirthableObjects.add(citizen);
                    break;
                case "E4_Interfaces_and_Abstraction.P3_Birthday_Celebrations.Pet":
                    String namePet = inputData[1];
                    String birthDatePet = inputData[2];
                    Pet pet = new Pet(namePet, birthDatePet);
                    listBirthableObjects.add(pet);
                    break;
//                case "E4_Interfaces_and_Abstraction.P3_Birthday_Celebrations.Robot":
//                    break;
            }
            input = scanner.nextLine();
        }
        boolean equalsBirthDates = false;
        String randomYear = scanner.nextLine();
        for (Birthable birthableObject : listBirthableObjects) {
            if (birthableObject.getBirthDate().endsWith(randomYear)) {
                System.out.println(birthableObject.getBirthDate());
                equalsBirthDates = true;
            }
        }
        if (!equalsBirthDates) {
            System.out.println("<no output>");
        }
    }
}
