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


        dealer.drawCard(deck); // Dealern drar ett kort, endast ett kort syns i början


        isGameActive = true; // Sätt spelet till aktivt (nu kan spelaren börja spela)
    }
    // Den här metoden avslutar spelet genom att sätta isGameActive till false, vilket stoppar spelet.
    private void endGame() {
        isGameActive = false; // Sätter isGameActive till false för att avsluta spelet
    }

    // Den här metoden styr dealerns spel.
    private void dealerPlay() {

        while (calculateHandValue(dealer) < 17) { // Dealern fortsätter att dra kort tills handvärdet är minst 17.
            dealer.drawCard(deck); // Dealern drar ett kort från kortleken
        }
    }

    // Den här metoden beräknar handens värde för en spelare.
    private int calculateHandValue(Player player) {
        int value = 0; // Värdet på handen, börjar på 0
        int aceCount = 0; // Räknar antalet ess i handen

        // Går igenom alla kort i spelarens hand
        for (Card card : player.getHand()) {
            if (card.getValue() == 1) { // Om kortet är ett ess
                aceCount++; // Öka antalet ess
                value += 11; // Temporärt sätt ess som 11 poäng
            } else if (card.getValue() >= 10) { // Om kortet är ett klätt kort (10, J, Q, K)
                value += 10; // Lägg till 10 poäng för klädda kort
            } else {
                value += card.getValue(); // Lägg till kortets faktiska värde
            }
        }

        // Justera ess om handens värde överstiger 21 (dvs. räkna ess som 1 istället för 11)
        while (value > 21 && aceCount > 0) {
            value -= 10; // Minska värdet genom att räkna ett ess som 1 istället för 11
            aceCount--; // Minska antalet ess att justera
        }

        return value; // Returnera det slutgiltiga värdet på handen
    }


    // Metoden determineWinner används för att bestämma vinnaren mellan spelaren och dealern.
    private void determineWinner() {
        // Beräknar spelarens och dealerens handvärde genom att använda calculateHandValue-metoden.
        int playerValue = calculateHandValue(player);
        int dealerValue = calculateHandValue(dealer);

        // Om spelarens handvärde är större än 21 (spelaren går över 21) förlorar spelaren.
        if (playerValue > 21) {
            System.out.println("Du gick över 21 och DU FÖRLORAR.");
        }
        // Om dealerens handvärde är större än 21 (dealern går över 21) vinner spelaren.
        else if (dealerValue > 21) {
            System.out.println("DEALERN gick över 21. DU VINNER!");
            player.winBet(currentBet); // Spelaren vinner insatsen
        }
        // Om spelarens handvärde är större än dealerens handvärde vinner spelaren.
        else if (playerValue > dealerValue) {
            System.out.println("DU VANN! Din hand är högre än DEALERNS.");
            player.winBet(currentBet); // Spelaren vinner insatsen
        }
        // Om spelarens handvärde är mindre än dealerens handvärde förlorar spelaren.
        else if (playerValue < dealerValue) {
            System.out.println("DU FÖRLORADE! DEALERNS hand är högre.");
        }
        // Om spelarens och dealerens handvärde är lika är det oavgjort och insatsen återgår.
        else {
            System.out.println("OAVGJORT! Insatsen återgår till dig.");
            player.balance += currentBet; // Spelaren får tillbaka sin insats
        }
    }


}

