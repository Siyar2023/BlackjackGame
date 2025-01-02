// java.util.ArrayList används för att skapa en lista som kan ändras i storlek.
// java.util.List är en gränssnitt som används för att deklarera listan.
import java.util.ArrayList;
import java.util.List;

// Definierar en offentlig klass med namnet Player som representerar en spelare.
public class Player {

    // Deklarerar en privat instansvariabel för spelarens namn.
    private String name;

    // Deklarerar en privat instansvariabel som är en lista över kort (handen som spelaren har).
    private List<Card> hand;

    // Deklarerar en publik instansvariabel för spelarens saldo (balance).
    int balance;

    // Konstruktor för att skapa en Player-instans.  Konstruktorer används för att initialisera objektets instansvariabler.
    public Player(String name) {
        // Tilldelar det inkommande parametrarvärdet till instansvariabeln "name".
        this.name = name;

        // Initialiserar spelarens hand som en tom lista av typen ArrayList.
        this.hand = new ArrayList<>();

        // Sätter startbalansen till 1000 när spelaren skapas.
        this.balance = 1000; // Startbalans
    }

    // Metod för att dra ett kort från kortleken och lägga till det i spelarens hand.
    public void drawCard(Deck deck) {
        // Hämtar ett kort från kortleken (deck) och lägger till det i spelarens hand.
        hand.add(deck.drawCard());  // Decks drawCard() metod hämtar ett kort som läggs till spelarens hand.
    }

    // Metod för att tömma spelarens hand (ta bort alla kort).
    public void clearHand() {
        // Tömmer spelarens hand genom att rensa listan 'hand'
        hand.clear();  // clear() tar bort alla objekt från hand-listan
    }

    // Metod för att hämta spelarens hand.
    public List<Card> getHand() {
        // Returnerar listan 'hand' som innehåller alla kort i spelarens hand.
        return hand;  // Returnerar listan med kort som spelaren har i handen
    }

    // Metod för att hämta spelarens nuvarande saldo/balance.
    public int getBalance() {
        // Returnerar spelarens aktuella balans
        return balance;  // Returnerar värdet av 'balance' som representerar spelarens pengar
    }

    // Metod för att placera en insats (bet) genom att dra av beloppet från spelarens saldo.
    public void placeBet(int amount) {
        // Om insatsbeloppet är mindre än eller lika med spelarens saldo, gör insatsen.
        if (amount <= balance) {
            balance -= amount;  // Minska saldot med insatsbeloppet
        } else {
            // Om insatsen är för hög, skriv ut ett meddelande.
            System.out.println("Not enough money.");  // Meddelande om saldo är för lågt.
        }
    }

    // Metod för att vinna en insats, där spelaren får dubbla insatsen tillbaka.
    public void winBet(int amount) {
        // Lägger till insatsen gånger 2 till spelarens saldo (dvs. spelarens insats plus en lika stor vinst).
        balance += amount * 2;  // Lägger till dubbla insatsen till saldot (vinsten).
    }

    // Metod för att visa spelarens hand som en sträng
    public String showHand() {
        // Används för att skapa en sträng som representerar alla kort i spelarens hand.
        StringBuilder handString = new StringBuilder();  // StringBuilder används för att effektivt bygga strängar.
        // Loopa igenom varje kort i spelarens hand.
        for (int i = 0; i < hand.size(); i++) {
            handString.append(hand.get(i).toString());  // Lägg till kortets strängrepresentation till handString.
            if (i < hand.size() - 1) {
                handString.append(" + ");  // Lägg till " + " mellan korten om det inte är sista kortet.
            }
        }
        return handString.toString();  // Returnerar den sammanställda strängen som representerar handens kort.
    }

}
