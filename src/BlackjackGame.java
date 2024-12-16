public class BlackjackGame {
    // Definiera spelare, dealer, kortlek, aktuellt bet och flagga för spelets status
    private Player player;
    private Player dealer;
    private Deck deck;
    private int currentBet;
    private boolean isGameActive; // Ny flagga för att kontrollera spelets status

    // Konstruktor som initierar spelets objekt: spelare, dealer och kortlek
    public BlackjackGame() {
        player = new Player("Player"); // Skapa en spelare med namnet "Player"
        dealer = new Player("Dealer"); // Skapa en dealer med namnet "Dealer"
        deck = new Deck(); // Skapa en ny kortlek
        isGameActive = false; // Spelet är inaktivt i början
    }

    // Metod för att starta ett nytt spel
    public void startNewGame() {
        // Rensa händerna för spelaren och dealern
        player.clearHand();
        dealer.clearHand();

        // Blanda kortleken
        deck.shuffle();

        // Spelaren placerar sitt bet
        player.placeBet(currentBet);

        // Spelaren drar två kort
        player.drawCard(deck);
        player.drawCard(deck);

        // Dealern drar ett kort, endast ett kort syns i början
        dealer.drawCard(deck);

        // Sätt spelet till aktivt (nu kan spelaren börja spela)
        isGameActive = true;
    }
}
