// Importerarg JavaFX-bibliotek som behövs för att skapa en grafisk användargränssnitt (GUI.
import javafx.application.Application; // Importerar huvudklassen för att starta JavaFX-applikationen.
import javafx.scene.Scene; // Importerar Scene-klassen, som används för att hålla alla GUI-komponenter (t.ex. knappar, textområden).
import javafx.scene.control.*; // Importerar alla kontrollkomponenter (som knappar, textfält, etiketter, etc.) från JavaFX.
import javafx.scene.layout.HBox; // Importerar HBox-layouten, som används för att arrangera GUI-komponenter horisontellt.
import javafx.scene.layout.VBox; // Importerar VBox-layouten, som används för att arrangera GUI-komponenter vertikalt.
import javafx.stage.Stage; // Importerar Stage-klassen, som representerar huvudfönstret i en JavaFX-applikationen.

public class BlackjackGame extends Application {
    // Definiera spelare, dealer, kortlek, aktuellt bet och flagga för spelets status
    private Player player;  // Spelarens objekt.
    private Player dealer; // Dealerens objekt.
    private Deck deck; // Kortleken.
    private TextArea output; // Textområde för att visa meddelanden och spelets tillstånd.
    private int currentBet; // Den aktuella insatsen.
    private Label balanceLabel; // Visar spelarens balans.
    private boolean isGameActive; // Flagga för att kontrollera spelets status

    // Konstruktor som initierar spelets objekt: spelare, dealer och kortlek
    public BlackjackGame() {
        player = new Player("Player"); // Skapar en spelare med namnet "Player".
        dealer = new Player("Dealer"); // Skapar en dealer med namnet "Dealer"
        deck = new Deck(); // Skapar en ny kortlek
        isGameActive = false; // Spelet är inaktivt i början
    }

    @Override  //Denna metod överskriver start(Stage primaryStage) från klassen Application, som är en del av JavaFX. När man skapar en JavaFX-applikation är det obligatoriskt att överskriva denna metod för att definiera hur det grafiska användargränssnittet ska byggas upp och visas.
    public void start(Stage primaryStage) {
        output = new TextArea();  // TextArea för att visa spelinformation och meddelanden
        output.setEditable(false); // Gör textområdet endast läsbart

        balanceLabel = new Label("Balance: " + player.getBalance() + " kr"); // Label för att visa spelarens balans

        // Skapar knappar för spelåtgärder
        Button playButton = new Button("Play"); // Starta ett nytt spel
        Button hitButton = new Button("Draw card"); // Dra ett nytt kort
        Button stayButton = new Button("Stay"); // Stanna och låt dealern spela
        Button quitButton = new Button("Quit"); // Avsluta spelet helt


        // ComboBox för att välja insats (25, 50 eller 100 kr)
        ComboBox<Integer> betSelector = new ComboBox<>();
        betSelector.getItems().addAll(25, 50, 100); // Lägger till möjliga insatsbelopp.
        betSelector.setValue(25); // Standardinsats är 25 kr


        playButton.setOnAction(e -> { // Knapp för att starta ett nytt spel
            if (player.getBalance() == 0) { // Kontrollera om spelaren har 0 balans
                output.setText("You don't have enough money to play on.\n" +
                        "Please Quit the game and restart to replay!");
                playButton.setDisable(true); // Inaktivera "Spela"-knappen om saldot är noll.
                return; // Avsluta händelsehanteraren
            }

            currentBet = betSelector.getValue(); // Hämtar vald insats
            if (player.getBalance() < currentBet) { // Kontrollera spelarens balans
                output.appendText("You don't have enough money for this bet. Please choose a lower stake!\n");
                return;
            }
            startNewGame(hitButton, stayButton, playButton); // Startar spelet om insatsen är tillräckligt stort.
        });



        hitButton.setOnAction(e -> {   // Knapp för att dra ett kort
            if (!isGameActive) return; // Säkerställer att spelet är aktivt
            player.drawCard(deck);  // Spelaren drar ett kort
            updateOutput(); // Uppdaterar visningen av spelarens hand
            if (calculateHandValue(player) > 21) { // Kontrollera om spelaren förlorar
                output.appendText("You went over 21 and YOU LOSE!");
                endGame(hitButton, stayButton, playButton); // Avsluta spelet
            }
        });


        stayButton.setOnAction(e -> { // Knapp för att stanna och låta dealern spela
            if (!isGameActive) return; // Säkerställer att spelet är aktivt
            dealerPlay(); // Dealern spelar sin tur
            determineWinner(); // Avgör vinnaren mellan spelaren och dealern
            endGame(hitButton, stayButton, playButton); // Avsluta spelet
        });


            quitButton.setOnAction(e -> { // Knapp för att avsluta spelet
            System.exit(0); // Avslutar applikationen
        });

        // Inaktiverar "Dra Kort" och "Stanna" knapparna innan spelet startar
        hitButton.setDisable(true);
        stayButton.setDisable(true);

        // Layout för insats och balans
        HBox betAndBalanceBox = new HBox(10, new Label("Bet: "), betSelector, balanceLabel);

        // Huvudlayout med alla UI-element i en vertikal box
        VBox layout = new VBox(10, betAndBalanceBox, playButton, hitButton, stayButton, quitButton, output);
        Scene scene = new Scene(layout, 600, 600); // Skapar en scen med 600x600 pixlar

        // Konfigurera och visa fönstret
        primaryStage.setTitle("Blackjack Game"); // Sätter titel på fönstret
        primaryStage.setScene(scene); // Lägger till scenen i fönstret
        primaryStage.show(); // Visar fönstret
    }


    // Metod för att starta ett nytt spel
    public void startNewGame(Button hitButton, Button stayButton, Button playButton) {
        // Rensar händerna för spelaren och dealern
        output.clear();
        player.clearHand();
        dealer.clearHand();
        deck.shuffle(); // Blanda kortleken


        player.placeBet(currentBet); // Spelaren placerar sitt bet
        player.drawCard(deck); // Spelaren får ett kort
        player.drawCard(deck); // Spelaren får ett kort till
        dealer.drawCard(deck); // Dealern drar ett kort, endast ett kort syns i början
        updateBalanceLabel();
        updateOutput();

        // Avaktivera "Spela"-knappen under spelet och aktivera kort-knappar
        playButton.setDisable(true);
        hitButton.setDisable(false);
        stayButton.setDisable(false);
        isGameActive = true; // Sätt spelet till aktivt (nu kan spelaren börja spela)
    }
    // Den här metoden avslutar spelet genom att sätta isGameActive till false, vilket stoppar spelet.
    private void endGame(Button hitButton, Button stayButton, Button playButton) {
        hitButton.setDisable(true);
        stayButton.setDisable(true);
        playButton.setDisable(false);
        isGameActive = false; // Sätter isGameActive till false för att avsluta spelet
    }

    private void updateOutput() {
        output.appendText("YOUR HAND: " + player.showHand() + " (Sum: " + calculateHandValue(player) + ")\n");
        output.appendText("DEALER HAND: [ " + dealer.getHand().get(0).getValue() + " ] (Only one card is shown)\n");

        output.appendText("\n");
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Balance: " + player.getBalance() + " kr");
    }

    private void dealerPlay() { // Den här metoden styr dealerns spel
        output.appendText("DEALER PLAYS...\n");
        while (calculateHandValue(dealer) < 17) { // Dealern fortsätter att dra kort tills handvärdet är minst 17.
            dealer.drawCard(deck); // Dealern drar ett kort från kortleken
        }
        output.appendText("DEALER HAND: " + dealer.showHand() + " (Sum: " + calculateHandValue(dealer) + ")\n");

    }

    // Den här metoden beräknar handens värde för en spelare.
    int calculateHandValue(Player player) {
        int value = 0; // Värdet på handen, börjar på 0
        int aceCount = 0; // Räknar antalet ess i handen

        // Går igenom alla kort i spelarens hand
        for (Card card : player.getHand()) {
            if (card.getValue() == 1) { // Om kortet är ett ess
                aceCount++; // Öka antalet ess
                value += 11; // Temporärt räkna ess som 11
            } else if (card.getValue() >= 10) { // Om kortet är ett klätt kort (10, J, Q, K)
                value += 10; // Lägg till 10 poäng för klädda kort
            } else {
                value += card.getValue(); // Lägg till kortets faktiska värde
            }
        }

        while (value > 21 && aceCount > 0) { // Justera ess om handens värde överstiger 21 (dvs. räkna ess som 1 istället för 11)

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
            output.appendText("You went over 21 and YOU LOSE.");
        }
        // Om dealerens handvärde är större än 21 (dealern går över 21) vinner spelaren.
        else if (dealerValue > 21) {
            output.appendText("The DEALER went over 21. YOU WIN!");
            player.winBet(currentBet); // Spelaren vinner insatsen
        }
        // Om spelarens handvärde är större än dealerens handvärde vinner spelaren.
        else if (playerValue > dealerValue) {
            output.appendText("YOU WIN! Your hand is higher than the DEALER's.");
            player.winBet(currentBet); // Spelaren vinner insatsen
        }
        // Om spelarens handvärde är mindre än dealerens handvärde förlorar spelaren.
        else if (playerValue < dealerValue) {
            output.appendText("YOU LOST! The DEALER's hand is higher.");
        }
        // Om spelarens och dealerens handvärde är lika är det oavgjort och insatsen återgår.
        else {
            output.appendText("DRAW! The stake returns to you.");
            player.balance += currentBet; // Spelaren får tillbaka sin insats
        }
        updateBalanceLabel();
    }
    public static void main(String[] args) {
        launch(args);

}
   public void play(TextArea output){

   }
}
