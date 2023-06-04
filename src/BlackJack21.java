import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack21 {
    public static int drawNum = 0;
    public static Deck deck = new Deck();
    public static void main(String[] args) {
        ArrayList<Card> dealer = new ArrayList<>();
        ArrayList<Card> player = new ArrayList<>();


        int dealerScore = 0;
        int playerScore = 0;

        drawCard(dealer);
        //drawCard(dealer);

        drawCard(player);
        //drawCard(player);

        dealerScore = getScore(dealer);
        playerScore = getScore(player);

        Scanner sc = new Scanner(System.in);

        while (playerScore <= 21 && dealerScore <= 21) {
            System.out.println("Dealer's Score: "+getScore(dealer));
            System.out.println("Your Score: "+getScore(player));
            System.out.println("Hit (h) or Stand (s)?");
            char c = sc.next().charAt(0);
            if (c == 'h') {
                drawCard(player);
                drawCard(dealer);
            } else if (c == 's') {
                drawCard(dealer);
                dealerScore = getScore(dealer);
                playerScore = getScore(player);
                if (isBusted(playerScore, dealerScore)) {
                    return;
                }
                if (playerScore > dealerScore) {
                    System.out.println("You win! Player score: "+playerScore+". Dealer score: "+dealerScore+".");
                    return;
                } else if (playerScore == dealerScore) {
                    System.out.println("Draw! Player score: "+playerScore+". Dealer score: "+dealerScore+".");
                    return;
                } else {
                    System.out.println("You lose... Player score: "+playerScore+". Dealer score: "+dealerScore+".");
                    return;
                }
            } else {
                System.out.println("Invalid reply.");
            }
            playerScore = getScore(player);
            dealerScore = getScore(dealer);
        }
        if (dealerScore > 21){
            System.out.println("You win! Player score: "+playerScore+". Dealer score: "+dealerScore);
        } else {
            System.out.println("You went over 21... Player score: "+playerScore+". Dealer score: "+dealerScore);
        }
    }

    public static void printCards(ArrayList<Card> cards) {
        for (Card card : cards) {
            System.out.println(card.value + " of " + card.suit);
        }
    }

    public static Card drawCard(ArrayList<Card> d) {
        Card c = deck.cards[drawNum];
        d.add(c);
        drawNum++;
        return c;
    }

    public static int getScore(ArrayList<Card> d) {
        int s = 0;
        for (Card c : d) {
            s += c.pointValue;
        }
        return s;
    }

    public static boolean isBusted(int playerScore, int dealerScore){
        if (playerScore > 21 || dealerScore > 21){
            return true;
        } else {
            return  false;
        }
    }
}
