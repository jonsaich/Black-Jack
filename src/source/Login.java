/**
 * BlackJack Application
 * <p>
 * This is the login screen. Here the user enters their credentials and they're logged in. Currently
 * there are no checks involved, but once the login button is clicked they're taken to the next scene.
 * <p>
 * I am also using external CSS to style the whole GUI which has also been loaded in.
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

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Login {

    public Scene loginScreen(Stage thestage) {

        Pane pane = new Pane();
        Scene scene;
        Image logoImg = new Image("logo.png");

        TextField un = new TextField();
        un.setPromptText("username");
        un.setId("un");
        un.setPadding(new Insets(10, 10, 10, 10));
        un.setAlignment(Pos.CENTER);
        un.relocate(300, 200);

        PasswordField pw = new PasswordField();
        pw.setPromptText("password");
        pw.setId("pw");
        pw.setPadding(new Insets(10, 10, 10, 10));
        pw.setAlignment(Pos.CENTER);
        pw.relocate(300, 260);

        /*
        When the enter button is pressed in the PasswordField
        the password is printed to the screen *NO USE BUT COULD
        BE USED IN THE FUTURE
         */

        pw.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    System.out.println(pw.getText());
                }
            }
        });

        Button signIn = new Button("login");
        signIn.setId("signIn");
        signIn.setPadding(new Insets(10, 20, 10, 20));
        signIn.relocate(355, 310);

        signIn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Play playScreen = new Play();
                System.out.println(pw.getText());
                System.out.println("changing");
                thestage.setScene(playScreen.playScene(thestage));
            }
        });

        ImageView logo = new ImageView();
        logo.setImage(logoImg);
        logo.setFitWidth(270);
        logo.setFitHeight(120);
        logo.relocate(256, 34);


        pane.setStyle("-fx-background-image: url('bg.jpg')");


        pane.getChildren().addAll(un, pw, logo, signIn);

        scene = new Scene(pane, 800, 500);
        logo.requestFocus(); // This is used so the passwordfield isn't selected when screen opens
        scene.getStylesheets().add("style.css"); // External stylesheet is loaded
        return scene;
    }
}
