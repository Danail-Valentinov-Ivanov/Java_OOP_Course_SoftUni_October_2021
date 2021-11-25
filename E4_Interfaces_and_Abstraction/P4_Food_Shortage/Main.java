package E4_Interfaces_and_Abstraction.P4_Food_Shortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> mapPersons = new HashMap<>();
        int numberOfPerson = Integer.parseInt(scanner.nextLine());
        while (numberOfPerson-- > 0) {
            String[] personData = scanner.nextLine().split("\\s+");
            if (personData.length == 4) {
                String nameCitizen = personData[0];
                int ageCitizen = Integer.parseInt(personData[1]);
                String id = personData[2];
                String birthDate = personData[3];
                Person citizen = new Citizen(nameCitizen, ageCitizen, id, birthDate);
                mapPersons.putIfAbsent(nameCitizen, citizen);
            } else {
                String nameRebel = personData[0];
                int ageRebel = Integer.parseInt(personData[1]);
                String group = personData[2];
                Person rebel = new Rebel(nameRebel, ageRebel, group);
                mapPersons.putIfAbsent(nameRebel, rebel);
            }
        }
        String nameOfPerson = scanner.nextLine();
        while (!nameOfPerson.equals("End")) {
            if (mapPersons.containsKey(nameOfPerson)) {
                if (mapPersons.get(nameOfPerson) instanceof Citizen) {
                    ((Citizen) mapPersons.get(nameOfPerson)).buyFood();
                } else {
                    ((Rebel) mapPersons.get(nameOfPerson)).buyFood();
                }
            }
            nameOfPerson = scanner.nextLine();
        }
        int totalFood = 0;
        for (Person person : mapPersons.values()) {
            if (person instanceof Citizen) {
                totalFood += ((Citizen) person).getFood();
            } else {
                totalFood += ((Rebel) person).getFood();
            }
        }
        System.out.println(totalFood);
    }
}
