import cardSuites.Card;
import cardSuites.CardRank;
import cardSuites.CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String cardRank=scanner.nextLine();
        String cardSuit=scanner.nextLine();

        Card card=new Card();


        System.out.printf("Card name: %s of %s; Card power: %d"
                ,cardRank,cardSuit,card.calculate(CardRank.valueOf(cardRank),CardSuit.valueOf(cardSuit)));


    }
}
