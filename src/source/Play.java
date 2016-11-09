/**
 * BlackJack Application
 *
 * The play class is really the menu of the whole game. From here the user has options whether
 * they wish to view the leaderboard or play blackjack. I'm using a onMouseClick listener
 * to change scenes once a mouse click has been deteced.
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Play {
    Scene scene1;
    Pane pane;
    Image logoImg = new Image("logo.png");


    public Scene playScene(Stage thestage) {
        pane = new Pane();

        // Text Welcoming player
        Text welcomePlayer = new Text("Good Afternoon, Jonathan.");
        welcomePlayer.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        welcomePlayer.setFill(Color.WHITE);
        welcomePlayer.relocate(220, 40);


        // Buttons
        Button logout = new Button("logout");
        logout.setId("logoutButton");
        logout.setPadding(new Insets(10, 15, 10, 15));
        logout.relocate(710, 33);
        logout.setStyle("-fx-background-color: #494545; -fx-color: white;");

        Button playBJ = new Button("Play BlackJack");
        playBJ.setId("playBJButton");
        playBJ.setPadding(new Insets(10, 20, 10, 20));
        playBJ.relocate(290, 200);

        playBJ.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                BlackJack bJScene = new BlackJack();
                thestage.setScene(bJScene.blackJackScene(thestage));
            }
        });

        Button leaderboard = new Button("Leaderboard");
        leaderboard.setId("lbButton");
        leaderboard.setPadding(new Insets(10, 35, 10, 35));
        // across and up/down
        leaderboard.relocate(290, 270);


        logout.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Login loginScene = new Login();
                System.out.println("changing");
                thestage.setScene(loginScene.loginScreen(thestage));
            }
        });

        ImageView logo = new ImageView();
        logo.setImage(logoImg);
        logo.setFitWidth(190);
        logo.setFitHeight(90);

        // This is used instead of an image for the design
        Rectangle r = new Rectangle();
        r.setX(0);
        r.setY(0);
        r.setWidth(800);
        r.setHeight(90);
        r.setFill(Color.web("#2e2929"));

        pane.setStyle("-fx-background-image: url('bg.jpg')");


        pane.getChildren().addAll(r, logo, welcomePlayer, playBJ, leaderboard, logout);
        scene1 = new Scene(pane, 800, 500);
        logout.requestFocus();
        scene1.getStylesheets().add("style.css");
        return scene1;
    }
}
