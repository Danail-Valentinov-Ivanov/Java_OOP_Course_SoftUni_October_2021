package E1_Working_with_Abstraction.P3_Cards_with_Power;

public class Card {
    private CardSuits cardSuits;
    private CardRank cardRank;

    public Card(CardSuits cardSuits, CardRank cardRank) {
        this.cardSuits = cardSuits;
        this.cardRank = cardRank;
    }
    public int getPower(){
        return cardSuits.getCardSuit()+cardRank.getCardRank();
    }
}
