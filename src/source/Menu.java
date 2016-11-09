/**
 * BlackJack Application
 *
 * This is the main class where the first scene is shown to the user. JavaFX uses the start method to
 * as the "main method".
 *
 * @author Jonathan Saich
 * @version BETA 0.75
 * @date 28/04/2016
 * Note. This is far from completion. I was far too ambitious with the amount of features I wanted in the game originally
 * and the amount of time I had for the project. I will be continuing this project in my free time to add the rest of the
 * features. The login screen does not require a login - by clicking the login button it'll take you to the menu, also
 * the leaderboard has no functionality. In the future I'll be connecting it up to a database.
 */


package source;


import javafx.application.Application;
import javafx.stage.Stage;

public class Menu extends Application {

    Stage stage;
    Login loginScreen = new Login();


    public void start(Stage primarystage) throws Exception {
        stage = primarystage;
        primarystage.setResizable(false);
        primarystage.setTitle("BlackJack - Jonathan Saich - i7463939");
        primarystage.setScene(loginScreen.loginScreen(primarystage));
        primarystage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
