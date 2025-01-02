// Importerar ArrayList-klassen från java.util-paketet för att använda den som en lista.
import java.util.ArrayList;
import java.util.Collections; // Importerar Collections-klassen som innehåller statiska metoder för att arbeta med samlingar.

public class Deck {

    // Skapar en privat instansvariabel 'cards' som är en ArrayList av typ Card.
    ArrayList<Card> cards; // Lista för att lagra korten
    private static final String[] SUITS = {"Hearts", "Spades", "Diamonds", "Clubs"}; // Definierar färger (suits) för kortleken som en konstant lista.
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}; // Definierar rangordningar (rank) för korten som en konstant lista.
    private static final int[] VALUES = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11}; // Definierar poängvärden (values) för korten som en konstant lista.

    // Konstruktor för Deck-klassen som initialiserar kortleken.
    public Deck() {
        cards = new ArrayList<>(); // Skapar en ny ArrayList för att lagra korten.
        initializeDeck(); // Kallar på metoden för att lägga till kort i kortleken.
        shuffle(); // Blandar kortleken när den har blivit initialiserad.
    }

    // Metod för att initialisera kortleken genom att lägga till kort.
    private void initializeDeck() {
        cards.clear(); // Rensa korten innan ny initialisering
        for (String suit : SUITS) { // Loopar genom varje färg (suit) och varje rangordning (rank).
            for (int i = 0; i < RANKS.length; i++) {
                cards.add(new Card(suit, RANKS[i], VALUES[i])); // Skapar ett nytt kort och lägger till det i listan 'cards'.
            }
        }
    }

    // Denna metod blandar kortleken genom att använda Collections.shuffle().
    public void shuffle() {
        Collections.shuffle(cards);  // Använder Collections.shuffle för att blanda korten i listan 'cards'.
    }


    // Metod för att dra (ta bort och returnera) det första kortet från kortleken.
    Card drawCard() {
        if (cards.isEmpty()) { // Kollar om kortleken är tom.
            System.out.println("The deck is out! Resets the deck...");
            resetDeck(); // Återställer kortleken om den är tom
        }
        return cards.remove(0); // Tar bort och returnerar det första kortet i listan.
    }
    // Metod för att återställa kortleken och blanda den
    public void resetDeck() {
        initializeDeck(); // Skapar en ny kortlek genom att återställa korten.
        shuffle(); // Blandar kortleken efter att den har återställts.
    }

}


