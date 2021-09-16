
import java.util.ArrayList;
import java.util.Collections;


public class Main {

    public static void main(String[] args) {
        // test your code here
        ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(3, Suit.SPADE));
        cards.add(new Card(2, Suit.DIAMOND));
        cards.add(new Card(14, Suit.SPADE));
        cards.add(new Card(12, Suit.HEART));
        cards.add(new Card(2, Suit.SPADE));

        SortBySuit sortBySuitSorter = new SortBySuit();
        Collections.sort(cards, sortBySuitSorter);

        cards.stream().forEach(c -> System.out.println(c));
    }
}
