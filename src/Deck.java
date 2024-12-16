// Importerar ArrayList-klassen från java.util-paketet för att använda den som en lista.
import java.util.ArrayList;
import java.util.Collections; // Importerar Collections-klassen som innehåller statiska metoder för att arbeta med samlingar.

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


        // Denna loop itererar över varje färg (suit) i suits-arrayen.
        for (String suit : suits) {

            // Denna inre loop går igenom varje rang (rank) i ranks-arrayen.
            for (int i = 0; i < ranks.length; i++) {
                // Skapar ett nytt kort med den aktuella färgen (suit), rangordningen (rank) och värdet (value)
                // och lägger till det i kortleken (cards).
                cards.add(new Card(suit, ranks[i], values[i]));
            }
        }


        // Anropar shuffle metoden för att blanda kortleken efter att alla kort har lagts till.
        shuffle();


    }

    // Denna metod blandar kortleken genom att använda Collections.shuffle().
    public void shuffle() {
        Collections.shuffle(cards);  // Blandar korten i kortleken
    }

    // Denna metod drar (tar bort och returnerar) det första kortet från kortleken.
    public Card drawCard() {

        return cards.remove(0);  // Tar bort och returnera det första kortet i listan.
    }

}


