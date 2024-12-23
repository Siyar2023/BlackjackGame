import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PlayerTest {
    private Player player;
    private Deck deck;

    @BeforeEach
    public void setUp() {
        player = new Player("Test Player");
        deck = new Deck();
    }

    @Test  //Testar om spelarens initiala saldo är korrekt inställt på 1000.
    public void testInitialBalance() {
        assertEquals(1000, player.getBalance(), "Det ursprungliga saldot ska vara 1000.");
    }

    @Test // Testar för att kontrollera om spelarens hand ökar med ett kort efter att drawCard har anropats.
    public void testDrawCard() {
        int initialHandSize = player.getHand().size();
        player.drawCard(deck); // Dra ett kort
        assertEquals(initialHandSize + 1, player.getHand().size(), "Handens storlek bör öka med 1 efter att man har dragit ett kort.");
    }

    @Test //Test för spelaren kan rensa sin hand korrekt efter att ha dragit ett kort. Här är några saker att tänka på:
    public void testClearHand() {
        player.drawCard(deck);
        player.clearHand(); // Rensa handen
        assertTrue(player.getHand().isEmpty(), "Handen ska vara tom efter rensning.");
    }

    @Test //Test för att kontrollera att spelarens saldo minskar korrekt när en insats placeras.
    public void testPlaceBet() {
        player.placeBet(100);
        assertEquals(900, player.getBalance(), "Balance should decrease by the bet amount.");
    }

    @Test // Test för att verifiera att spelarens saldo ökar korrekt när den vinner en insats.
    public void testWinBet() {
        player.placeBet(100);
        player.winBet(100); // Vinn insatsen
        assertEquals(1100, player.getBalance(), "Saldot bör öka med dubbelt så mycket som det satsade beloppet.");
    }

    @Test //Testar för att visa spelarens hand efter att ett kort har dragits från kortleken.
    public void testShowHand() {
        player.drawCard(deck);
        String handString = player.showHand();
        assertFalse(handString.isEmpty(), "Handsträngen ska inte vara tom efter att ett kort har dragits");
    }
}