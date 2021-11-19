package E2_P3_Shopping_Spree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> mapPerson = new LinkedHashMap<>();
        Map<String, Product> mapProduct = new HashMap<>();

        String[] inputPeople = scanner.nextLine().split(";");
        for (String personData : inputPeople) {
            String[] personInfo = personData.split("=");
            String personName = personInfo[0];
            double personMoney = Double.parseDouble(personInfo[1]);
            try {
                Person person = new Person(personName, personMoney);
                mapPerson.put(personName, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] inputProducts = scanner.nextLine().split(";");
        for (String productData : inputProducts) {
            String[] productInfo = productData.split("=");
            String productName = productInfo[0];
            double productCost = Double.parseDouble(productInfo[1]);
            try {
                Product product = new Product(productName, productCost);
                mapProduct.put(productName, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] currentCommand = command.split("\\s+");
            String currentPersonName = currentCommand[0];
            String currentProductName = currentCommand[1];

            try {
                Person person = mapPerson.get(currentPersonName);
                Product product = mapProduct.get(currentProductName);
                person.buyProduct(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            command = scanner.nextLine();
        }

        for (Person person : mapPerson.values()) {
            System.out.printf("%s - ", person.getName());
            if (person.getProducts().isEmpty()) {
                System.out.println("Nothing bought");
            } else {
                System.out.println(person.getProducts().stream().map(product -> product.getName())
                        .collect(Collectors.joining(", ")));
            }
        }
    }
}
