

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackjackGameTest {
    private BlackjackGame game;
    private Player player;

    @BeforeEach
    public void setUp() {
        game = new BlackjackGame();
        player = new Player("Test Player");
    }

    @Test
    public void testCalculateHandValue() {
        // Skapa en "deck" och "draw" kort för testet
        Deck deck = new Deck();

        // Dra kort för spelare
        player.drawCard(deck); // Dra ett kort
        player.drawCard(deck); // Dra ett kort

        // Kontrollera handens värde
        int handValue = game.calculateHandValue(player);

        // Output för att se vad handens värde är
        System.out.println("Player's Hand Value: " + handValue);

        // Gör antaganden om värdet baserat på dragna kort
        // Du måste här kontrollera och verifiera förväntat värde baserat på de faktiska korten som dras.
    }

    // Du kan lägga till fler tester för olika scenarier
}