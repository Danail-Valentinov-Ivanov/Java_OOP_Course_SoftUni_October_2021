package E4_Interfaces_and_Abstraction.P5_Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputNumbers = scanner.nextLine().split("\\s+");
        List<String> listNumbers = Arrays.asList(inputNumbers);

        String[] inputUrls = scanner.nextLine().split("\\s+");
        List<String> listUrls = Arrays.asList(inputUrls);
        Smartphone smartphone = new Smartphone(listNumbers, listUrls);

        System.out.print(smartphone.call());
        System.out.print(smartphone.browse());
    }
}
