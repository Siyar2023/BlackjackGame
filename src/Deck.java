// Importerar ArrayList-klassen från java.util-paketet för att använda den som en lista.
import java.util.ArrayList;

public class Deck {

    // Skapar en privat instansvariabel 'cards' som är en ArrayList av typ Card.
    private ArrayList<Card> cards;

    // Konstruktor för Deck-klassen som initialiserar kortleken.
    public Deck() {

        // Skapar en ny ArrayList för att lagra korten.
        cards = new ArrayList<>();

        // Skapar en array av strängar som representerar de fyra olika färgerna (suits) i en kortlek.
        String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};

        // Skapar en array av strängar som representerar de olika rangordningarna (ranks) på korten.
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        // Skapar en array av heltal som representerar värdena (values) för varje rang.
        // T.ex. alla 'Jack', 'Queen' och 'King' har värdet 10, medan 'Ace' är 11.
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11}; // Värden för korten

    }
}


