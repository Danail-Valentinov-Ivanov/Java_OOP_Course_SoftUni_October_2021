package E1_Working_with_Abstraction.P2_Card_Rank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        for (CardRank cardRank : CardRank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s\n", cardRank.ordinal(), cardRank.name());
//            or
//            System.out.printf("Ordinal value: %d; Name value: %s\n", cardRank.ordinal(), cardRank);
//            or
//            System.out.printf("Ordinal value: %d; Name value: %s\n", cardRank.ordinal(), cardRank.toString());
        }
    }
}
