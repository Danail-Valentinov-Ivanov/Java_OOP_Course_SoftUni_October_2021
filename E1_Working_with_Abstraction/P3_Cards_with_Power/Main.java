package E1_Working_with_Abstraction.P3_Cards_with_Power;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardRank cardRank = CardRank.valueOf(scanner.nextLine());
        CardSuits cardSuits = CardSuits.valueOf(scanner.nextLine());
        Card card = new Card(cardSuits, cardRank);
        System.out.printf("Card name: %s of %s; Card power: %d"
                , cardRank.name(), cardSuits.name(), card.getPower());
    }
}
