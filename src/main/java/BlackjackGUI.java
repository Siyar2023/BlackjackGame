// Importerar nödvändiga JavaFX-klasser för att skapa en GUI-applikation
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BlackjackGUI extends Application {

    // start metoden är huvudmetoden för att skapa och visa GUI-komponenter i JavaFX
    @Override
    public void start(Stage primaryStage) {
        TextArea output = new TextArea(); // Skapar en TextArea där spelets resultat eller information kommer att visas
        Button playButton = new Button("Spela"); // Skapar en Button komponent som användaren kan trycka på för att starta spelet

        BlackjackGame game = new BlackjackGame(); // Skapar en instans av BlackjackGame klassen som hanterar spelets logik

        playButton.setOnAction(e -> { // När knappen "Spela" trycks på, kommer spelet att starta och resultatet att visas i TextArea
            game.play(output); // Spela spelet och skickar TextArea för att uppdatera med resultatet
        });

        VBox vbox = new VBox(playButton, output); // Skapar en VBox (vertical box) för att ordna playButton och output i en vertikal layout
        Scene scene = new Scene(vbox, 400, 400); // Skapar en ny scen som innehåller VBox-layouten, och sätter storleken på scenen

        primaryStage.setScene(scene); // Ställer in scenen för primärstadiet (huvudfönstret)
        primaryStage.setTitle("Blackjack"); // Sätter titeln på fönstret
        primaryStage.show(); // Visar fönstret
    }

    public static void main(String[] args) {
        launch(args);  // Starta JavaFX applikationen
    }
}
