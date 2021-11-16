package E1_Working_with_Abstraction.P3_Cards_with_Power;

public enum CardSuits {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);
    private int cardSuit;

    CardSuits(int cardSuit) {
        this.cardSuit = cardSuit;
    }

    public int getCardSuit() {
        return cardSuit;
    }
}
