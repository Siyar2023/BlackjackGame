// Importerar ArrayList-klassen från java.util-paketet för att använda den som en lista.
import java.util.ArrayList;
import java.util.Collections; // Importerar Collections-klassen som innehåller statiska metoder för att arbeta med samlingar.

public class Deck {

    // Skapar en privat instansvariabel 'cards' som är en ArrayList av typ Card.
    ArrayList<Card> cards; // Lista för att lagra korten
    private static final String[] SUITS = {"Hearts", "Spades", "Diamonds", "Clubs"}; // Färger
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}; // Rangordningar
    private static final int[] VALUES = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

    // Konstruktor för Deck-klassen som initialiserar kortleken.
    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }

    // Metod för att initialisera kortleken
    private void initializeDeck() {
        cards.clear(); // Rensa korten innan ny initialisering
        for (String suit : SUITS) {
            for (int i = 0; i < RANKS.length; i++) {
                cards.add(new Card(suit, RANKS[i], VALUES[i]));
            }
        }
    }

    // Denna metod blandar kortleken genom att använda Collections.shuffle().
    public void shuffle() {
        Collections.shuffle(cards);  // Blandar korten i kortleken
    }

    // Denna metod drar (tar bort och returnerar) det första kortet från kortleken.
    public Card drawCard() {
        if (cards.isEmpty()) {
            System.out.println("Kortleken är slut! Återställer kortleken...");
            resetDeck(); // Återställ kortleken om den är tom
        }
        return cards.remove(0); // Dra och ta bort det första kortet
    }
    // Metod för att återställa kortleken och blanda den
    public void resetDeck() {
        initializeDeck(); // Återställ korten
        shuffle(); // Blanda korten
    }

}


