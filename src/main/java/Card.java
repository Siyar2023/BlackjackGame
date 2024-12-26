public class Card {

    // Färg (Hjärter, Spader, Ruter, Klöver) för kortet
    private String suit;

    // Värde (2-10, Knekt, Dam, Kung, Ess) för kortet
    private String rank;

    // Poängvärde för kortet, används för att beräkna totalpoängen i spelet
    private int value;

    // Konstruktor som initierar ett kort med dess färg, värde och poängvärde
    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    // Getter för att hämta kortets poängvärde
    public int getValue() {
        return value;
    }

    // Överskuggar toString-metoden för att ge en lättläst representation av kortet
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
