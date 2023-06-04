public class Deck {
    Card[] cards = new Card[52];
    private String[] cardIndexes = new String[]{
      "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
    };

    public Deck() {
        createSuit("Hearts", 0);
        createSuit("Diamonds", 13);
        createSuit("Spades", 26);
        createSuit("Clubs", 39);
        shuffle();
    }

    public void createSuit(String suit, int startPos) {
        for (int i=0; i<cardIndexes.length; i++) {
            cards[i+startPos] = new Card(cardIndexes[i], suit, Math.min(i+1, 10));
        }
    }

    public void shuffle() {
        for (int i = 0; i<52; i++) {
            int r = (int) (Math.random()*52);
            Card order = cards[i];
            cards[i] = cards[r];
            cards[r] = order;
        }
    }
}
