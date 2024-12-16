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


/*
############################## KOD FÖRKLARING: ##############################
INSTANSVARIABLAR:
private String suit;:
Detta är en variabel som håller kortets färg.
Den representerar t.ex. "Hjärter", "Spader", "Ruter", eller "Klöver".
Den är privat vilket betyder att den bara kan nås från denna klass.

private String rank;:
Detta är en variabel som håller kortets rank eller värde, t.ex. "2", "Knekt", "Dam", "Kung"
eller "Ess". Den är också privat.

private int value;:
Detta är en variabel som håller det numeriska poängvärdet för kortet.
T.ex. ett kort med rank "Knekt" kan ha värdet 10, medan Ess kan ha värdet 1 eller 11, beroende på spelets regler.



KONSTRUKTOR:
public Card(String suit, String rank, int value):
Detta är en konstruktor som används för att skapa ett nytt objekt av typen Card.
När ett nytt kort skapas, skickas värden för suit, rank och value som argument och sätts till instansvariablerna i
objektet.

this.suit = suit;:
Tilldelar det inkommande argumentet suit till instansvariabeln suit i objektet.
this används här för att referera till den aktuella instansen av objektet.

this.rank = rank;:
Tilldelar det inkommande argumentet rank till instansvariabeln rank.

this.value = value;:
Tilldelar det inkommande argumentet value till instansvariabeln value



GETTER METODEN:
public int getValue():
Denna metod returnerar kortets poängvärde (value).
Det är en så kallad getter-metod, som tillåter andra delar av programmet att hämta kortets poängvärde.

return value;: Returnerar värdet på instansvariabeln value.



toString-metoden:
@Override:
Denna annotation markerar att metoden överskriver en befintlig metod från superklassen,
i det här fallet Object-klassen. toString() är en metod som varje objekt i Java kan ha,
och genom att överskriva den kan man specificera hur vårt kort ska representeras som en sträng.

public String toString():
Denna metod returnerar en strängrepresentation av kortet.
Strängen består av kortets rank (t.ex. "Knekt") och färg (t.ex. "Spader"),
vilket gör att vi får en läsbar representation som "Knekt of Spader".

return rank + " of " + suit;:
Här konstrueras strängen genom att sammanfoga rank, ordet " of " och suit,
vilket ger en läsbar beskrivning av kortet. Till exempel, om rank är "Ess" och
 */