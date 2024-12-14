// Importerar klasser från Java Standard Library
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
}
