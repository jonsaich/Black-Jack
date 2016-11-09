/**
 * BlackJack Application
 * <p>
 * The main class. This is where the majority of the game operates from. It stores the usersBalance as a local varaible
 * the user has options as to how much they'd like to bet etc.
 * <p>
 * It creates an object from Deck so that it has access to the methods suchas a dealing a card, this
 * helps keeping methods seperate from eachother and makes it easier to manage in the long term.
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class BlackJack {

    Scene scene1;
    Pane pane;
    Button logoutButton, hitButton, standButton, splitButton, menuButton, placeBet, cancelBet;
    Button bet1Button, bet5Button, bet10Button, bet50Button;
    Image logoImg = new Image("logo.png");
    Image tableBg = new Image("table-bg.jpg");
    Image dealerImg = new Image("dealer.jpg");
    Image hiddenCard = new Image("cards/backofcard.png");
    ImageView logo, tblBg, currentDealer, playerCard1Img, playerCard2Img, playerCard3Img, playerCard4Img, playerCard5Img, playerCard6Img, dealerCard1Img, dealerCard2Img, dealerCard3Img, dealerCard4Img, dealerCard5Img, dealerCardHidden;
    Text welcomePlayer, balancePlayer, dealerMessage, numOfDecks, dealer, playerCardValueTotal, playerCard2, dealerTotal, dealerCard2;
    Deck deck;
    Alert popUpDialog = new Alert(Alert.AlertType.INFORMATION);
    boolean alreadyShuffled = false;
    boolean standButtonTriggered = false;
    int betAmount = 0;
    int balance = 10;
    int playerFirstCard, playerSecondCard;


    public Scene blackJackScene(Stage thestage) {

        // Header Section
        // Welcome message to Player
        welcomePlayer = new Text("Good Afternoon, Jonathan.");
        welcomePlayer.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        welcomePlayer.setFill(Color.WHITE);
        welcomePlayer.relocate(220, 40);

        // BlackJack logo
        logo = new ImageView();
        logo.setImage(logoImg);
        logo.setFitWidth(190);
        logo.setFitHeight(90);

        // Displays Players balance
        balancePlayer = new Text("Balance £" + balance);
        balancePlayer.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        balancePlayer.setFill(Color.WHITE);
        balancePlayer.relocate(540, 40);

        // Logout button - returns to login screen
        logoutButton = new Button("logout");
        logoutButton.setId("logoutButton");
        logoutButton.setPadding(new Insets(10, 15, 10, 15));
        logoutButton.relocate(710, 33);
        logoutButton.setStyle("-fx-background-color: #494545; -fx-color: white;");

        logoutButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Login loginScene = new Login();
                System.out.println("changing");
                thestage.setScene(loginScene.loginScreen(thestage));
            }
        });

        // Main
        // BlackJack table image
        tblBg = new ImageView();
        tblBg.setImage(tableBg);
        tblBg.setFitWidth(670);
        tblBg.setFitHeight(505);
        tblBg.relocate(135, 90);

        // Current Dealer image
        currentDealer = new ImageView();
        currentDealer.setImage(dealerImg);
        currentDealer.setFitWidth(134);
        currentDealer.setFitHeight(115);
        currentDealer.relocate(0, 100);

        // Current Dealer name
        dealer = new Text("Your dealer is: Mark Wayne");
        dealer.setFont(Font.font("Arial", FontWeight.BOLD, 9));
        dealer.setFill(Color.WHITE);
        dealer.relocate(5, 220);

        // Displays the number of decks being used
        numOfDecks = new Text("Decks: ?");
        numOfDecks.setFont(Font.font("Arial", 9));
        numOfDecks.setFill(Color.WHITE);
        numOfDecks.relocate(45, 230);

        // Displays the number of cards until new deck
        dealerMessage = new Text("Please gamble responsibly.");
        dealerMessage.setFont(Font.font("Arial", 9));
        dealerMessage.setFill(Color.WHITE);
        dealerMessage.relocate(15, 240);

        // Buttons on left side
        // Hit Button
        hitButton = new Button("HIT");
        hitButton.setId("playButtons");
        hitButton.relocate(15, 270);
        hitButton.setPadding(new Insets(2, 40, 2, 40));
        hitButton.setVisible(false);

        /*
        The hit method, exectued when the user presses the button,
        counter which keeps a check of which card to draw, after every card is
        drawn the total is compared to see whether it's over 21
         */

        hitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (deck.playerTotalCardValue == 2) {
                    deck.giveCard();
                    playerCardValueTotal.setText("You have" + " " + deck.dealCardPlayer().toString());
                    playerCard3Img.setImage(deck.dealCardPlayerImg());
                    playerCard3Img.setVisible(true);
                    checkIfBust();
                } else if (deck.playerTotalCardValue == 3) {
                    deck.giveCard();
                    playerCardValueTotal.setText("You have" + " " + deck.dealCardPlayer().toString());
                    playerCard4Img.setImage(deck.dealCardPlayerImg());
                    playerCard4Img.setVisible(true);
                    checkIfBust();
                } else if (deck.playerTotalCardValue == 4) {
                    deck.giveCard();
                    playerCardValueTotal.setText("You have" + " " + deck.dealCardPlayer().toString());
                    playerCard5Img.setImage(deck.dealCardPlayerImg());
                    playerCard5Img.setVisible(true);
                    checkIfBust();
                } else if (deck.playerTotalCardValue == 5) {
                    deck.giveCard();
                    playerCardValueTotal.setText("You have" + " " + deck.dealCardPlayer().toString());
                    playerCard5Img.setImage(deck.dealCardPlayerImg());
                    playerCard5Img.setVisible(true);
                    checkIfBust();
                } else if (deck.playerTotalCardValue == 6) {
                    deck.giveCard();
                    playerCardValueTotal.setText("You have" + " " + deck.dealCardPlayer().toString());
                    playerCard5Img.setImage(deck.dealCardPlayerImg());
                    playerCard5Img.setVisible(true);
                    checkIfBust();
                }
            }
        });

        // Stand Button
        standButton = new Button("STAND");
        standButton.setId("playButtons");
        standButton.relocate(15, 300);
        standButton.setPadding(new Insets(2, 28, 2, 28));
        standButton.setVisible(false);

        /*
        Stand button just like the hit button but will keep running until either bust
        or house wins. Uses a while loop to keep showing the cards
         */

        standButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                standButtonTriggered = true;

                while (standButtonTriggered == true) { // Keeps running loop until standButton equal false when bust
                    if (deck.houseTotalCardValue == 1) {
                        deck.giveCard();
                        dealerTotal.setText("Dealer has " + deck.dealCardHouse().toString());
                        dealerCard1Img.setImage(deck.dealCardHouseImg());
                        dealerCard1Img.setVisible(true);
                        System.out.println("this went" + deck.houseTotalCardValue);
                        checkIfBust();
                    } else if (deck.houseTotalCardValue == 2) {
                        deck.giveCard();
                        dealerTotal.setText("Dealer has " + deck.dealCardHouse().toString());
                        dealerCard3Img.setImage(deck.dealCardHouseImg());
                        dealerCard3Img.setVisible(true);
                        System.out.println("this went" + deck.houseTotalCardValue);
                        checkIfBust();
                    } else if (deck.houseTotalCardValue == 3) {
                        deck.giveCard();
                        dealerTotal.setText("Dealer has " + deck.dealCardHouse().toString());
                        dealerCard4Img.setImage(deck.dealCardHouseImg());
                        dealerCard4Img.setVisible(true);
                        System.out.println("this went" + deck.houseTotalCardValue);
                        checkIfBust();
                    } else if (deck.houseTotalCardValue == 4) {
                        deck.giveCard();
                        dealerTotal.setText("Dealer has " + deck.dealCardHouse().toString());
                        dealerCard5Img.setImage(deck.dealCardHouseImg());
                        dealerCard5Img.setVisible(true);
                        System.out.println("this went" + deck.houseTotalCardValue);
                        checkIfBust();
                    } else if (deck.houseTotalCardValue == 5) {
                        deck.giveCard();
                        dealerTotal.setText("Dealer has " + deck.dealCardHouse().toString());
                        dealerCard5Img.setImage(deck.dealCardHouseImg());
                        dealerCard5Img.setVisible(true);
                        System.out.println("this went" + deck.houseTotalCardValue);
                        checkIfBust();
                    } else if (deck.houseTotalCardValue == 6) {
                        deck.giveCard();
                        dealerTotal.setText("Dealer has " + deck.dealCardHouse().toString());
                        dealerCard5Img.setImage(deck.dealCardHouseImg());
                        dealerCard5Img.setVisible(true);
                        System.out.println("this went" + deck.houseTotalCardValue);
                        checkIfBust();
                    }
                }
            }
        });


        // Split Button
        splitButton = new Button("HELP");
        splitButton.setId("playButtons");
        splitButton.relocate(15, 360);
        splitButton.setPadding(new Insets(2, 32, 2, 32));
        splitButton.setVisible(false);

        // Menu Button
        menuButton = new Button("menu");
        menuButton.setId("logoutButton");
        menuButton.setPadding(new Insets(10, 15, 10, 15));
        menuButton.relocate(30, 440);
        menuButton.setStyle("-fx-background-color: #494545; -fx-color: white;");

        // Bet buttons
        // Bet £1 button
        bet1Button = new Button("£1");
        bet1Button.setId("logoutButton");
        bet1Button.setPadding(new Insets(10, 15, 10, 15));
        bet1Button.relocate(15, 270);
        bet1Button.setStyle("-fx-background-color: #494545; -fx-color: white;");

        bet1Button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                betAmount = betAmount + 1;
                if (betAmount > balance) {
                    popUpDialog.setHeaderText("Ooops...");
                    popUpDialog.setContentText("You don't have enough funds to bet this much...");
                    popUpDialog.showAndWait();
                    betAmount = betAmount - 1;
                }
                placeBet.setText("BET £" + betAmount);
            }
        });

        // Bet £5 button
        bet5Button = new Button("£5");
        bet5Button.setId("logoutButton");
        bet5Button.setPadding(new Insets(10, 15, 10, 15));
        bet5Button.relocate(80, 270);
        bet5Button.setStyle("-fx-background-color: #494545; -fx-color: white;");

        bet5Button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                betAmount = betAmount + 5;
                if (betAmount > balance) {
                    popUpDialog.setHeaderText("Ooops...");
                    popUpDialog.setContentText("You don't have enough funds to bet this much...");
                    popUpDialog.showAndWait();
                    betAmount = betAmount - 5;
                }
                placeBet.setText("BET £" + betAmount);
            }
        });

        // Bet £10 button
        bet10Button = new Button("£10");
        bet10Button.setId("logoutButton");
        bet10Button.setPadding(new Insets(10, 15, 10, 15));
        bet10Button.relocate(10, 312);
        bet10Button.setStyle("-fx-background-color: #494545; -fx-color: white;");

        bet10Button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                betAmount = betAmount + 10;
                if (betAmount > balance) {
                    popUpDialog.setHeaderText("Ooops...");
                    popUpDialog.setContentText("You don't have enough funds to bet this much...");
                    popUpDialog.showAndWait();
                    betAmount = betAmount - 10;
                }
                placeBet.setText("BET £" + betAmount);
            }
        });

        // Bet £50 button
        bet50Button = new Button("£50");
        bet50Button.setId("logoutButton");
        bet50Button.setPadding(new Insets(10, 15, 10, 15));
        bet50Button.relocate(75, 312);
        bet50Button.setStyle("-fx-background-color: #494545; -fx-color: white;");

        bet50Button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                betAmount = betAmount + 50;
                if (betAmount > balance) {
                    popUpDialog.setHeaderText("Ooops...");
                    popUpDialog.setContentText("You don't have enough funds to bet this much...");
                    popUpDialog.showAndWait();
                    betAmount = betAmount - 50;
                }
                placeBet.setText("BET £" + betAmount);
            }
        });


        // Actual Game
        deck = new Deck();

        playerCardValueTotal = new Text("");
        playerCardValueTotal.setFont(Font.font("Arial", 9));
        playerCardValueTotal.setFill(Color.WHITE);
        playerCardValueTotal.relocate(450, 475);


        // Popup dialog alert
        popUpDialog.setTitle("BlackJack - Jonathan Saich - i7463939");

        /*
        The card images are shown below
         */

        // Current Dealer image
        playerCard1Img = new ImageView();
        playerCard1Img.setFitWidth(68);
        playerCard1Img.setFitHeight(68);
        playerCard1Img.relocate(443, 400);

        playerCard2 = new Text("");
        playerCard2.setFont(Font.font("Arial", 9));
        playerCard2.setFill(Color.WHITE);
        playerCard2.relocate(450, 420);

        playerCard2Img = new ImageView();
        playerCard2Img.setFitWidth(68);
        playerCard2Img.setFitHeight(68);
        playerCard2Img.relocate(473, 340);

        playerCard3Img = new ImageView();
        playerCard3Img.setFitWidth(68);
        playerCard3Img.setFitHeight(68);
        playerCard3Img.relocate(503, 280);

        playerCard4Img = new ImageView();
        playerCard4Img.setFitWidth(68);
        playerCard4Img.setFitHeight(68);
        playerCard4Img.relocate(533, 220);

        playerCard5Img = new ImageView();
        playerCard5Img.setFitWidth(68);
        playerCard5Img.setFitHeight(68);
        playerCard5Img.relocate(563, 163);

        playerCard6Img = new ImageView();
        playerCard6Img.setFitWidth(68);
        playerCard6Img.setFitHeight(68);
        playerCard6Img.relocate(533, 220);

        dealerTotal = new Text("");
        dealerTotal.setFont(Font.font("Arial", 9));
        dealerTotal.setFill(Color.WHITE);
        dealerTotal.relocate(450, 220);

        dealerCard1Img = new ImageView();
        dealerCard1Img.setFitWidth(68);
        dealerCard1Img.setFitHeight(68);
        dealerCard1Img.relocate(353, 141);

        dealerCard2Img = new ImageView();
        dealerCard2Img.setFitWidth(68);
        dealerCard2Img.setFitHeight(68);
        dealerCard2Img.relocate(425, 141);

        dealerCard3Img = new ImageView();
        dealerCard3Img.setFitWidth(68);
        dealerCard3Img.setFitHeight(68);
        dealerCard3Img.relocate(497, 141);

        dealerCard4Img = new ImageView();
        dealerCard4Img.setFitWidth(68);
        dealerCard4Img.setFitHeight(68);
        dealerCard4Img.relocate(569, 141);

        dealerCard5Img = new ImageView();
        dealerCard5Img.setFitWidth(68);
        dealerCard5Img.setFitHeight(68);
        dealerCard5Img.relocate(641, 141);

        dealerCard2 = new Text("");
        dealerCard2.setFont(Font.font("Arial", 9));
        dealerCard2.setFill(Color.WHITE);
        dealerCard2.relocate(460, 239);

        cancelBet = new Button("CLEAR BET");
        cancelBet.setId("playButtons");
        cancelBet.setPadding(new Insets(2, 23, 2, 23));
        cancelBet.relocate(5, 402);

        cancelBet.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                betAmount = 0;
                placeBet.setText("PLACE BET");
            }
        });

        placeBet = new Button("PLACE BET");
        placeBet.setId("playButtons");
        placeBet.setPadding(new Insets(2, 23, 2, 23));
        placeBet.relocate(5, 372);

        /*
        When the placeBet button is pressed the following code runs.
        First it checks whether the deck has been shuffled, it will get shuffled
        the first time the button has been pressed, then the boolean gets set to true.

        following that it then checks whether a bet has been entered and is greater than 0
        Then the first 2 cards are dealt to the player and the delaer recives 2 cards but only displaying
        the value of the first
         */

        placeBet.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {


                if (alreadyShuffled == false) {
                    deck.shuffleDeck(); // Shuffles the deck in a random order
                    alreadyShuffled = true;
                    numOfDecks.setText("Decks: " + deck.newCardsPic.size() / 52);
                }

                if (betAmount == 0 && balance == 0) {
                    balance = 5;
                    popUpDialog.setHeaderText("Ooops...");
                    popUpDialog.setContentText("You don't have any funds... here's £5");
                    balancePlayer.setText("Balance £" + balance);
                    popUpDialog.showAndWait();
                } else if (betAmount == 0) {

                    // Won't do anything until a betAmount is > 0

                } else {


                    deck.playerCardTotal = 0;
                    deck.houseCardTotal = 0;
                    deck.playerTotalCardValue = 0;
                    deck.houseTotalCardValue = 0;
                    standButtonTriggered = false;

                    balancePlayer.setText("Balance £" + (balance = balance - betAmount));


                    playerFirstCard = deck.dealCardPlayer();
                    playerCardValueTotal.setText("You have" + " " + playerFirstCard);
                    playerCardValueTotal.setVisible(true);
                    playerCard1Img.setImage(deck.dealCardPlayerImg());
                    playerCard1Img.setVisible(true);
                    deck.giveCard();
                    playerSecondCard = deck.dealCardPlayer(); // Used to check for BJ
                    playerCardValueTotal.setText("You have" + " " + playerSecondCard);
                    playerCard2Img.setImage(deck.dealCardPlayerImg());
                    playerCard2Img.setVisible(true);
                    deck.giveCard();

                    System.out.println(playerFirstCard + "  and " + (playerSecondCard - playerFirstCard));

                    dealerCard1Img.setImage(hiddenCard); // Replaces with a hidden img
                    dealerCard1Img.setVisible(true);
                    deck.giveCard();
                    dealerTotal.setText("Dealer has" + " " + deck.dealCardHouse().toString());
                    dealerTotal.setVisible(true);
                    dealerCard2Img.setImage(deck.dealCardHouseImg());
                    dealerCard2Img.setVisible(true);

                    placeBet.setVisible(false); // Removes the bet button from screen
                    cancelBet.setVisible(false);
                    bet1Button.setVisible(false);
                    bet5Button.setVisible(false);
                    bet10Button.setVisible(false);
                    bet50Button.setVisible(false);

                    hitButton.setVisible(true);
                    standButton.setVisible(true);

                    checkForBlackJack();
                }
            }
        });

        /*
        Used to return to the menu of BlackJack
         */

        menuButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Play playScreen = new Play();
                thestage.setScene(playScreen.playScene(thestage));
            }
        });

        pane = new Pane();
        pane.setStyle("-fx-background-color: #2e2929");
        pane.getChildren().addAll(logo, tblBg, welcomePlayer, balancePlayer, logoutButton, currentDealer, dealer, numOfDecks, dealerMessage, splitButton, hitButton, standButton, menuButton, placeBet, playerCard2, dealerTotal, dealerCard2, dealerCard1Img, playerCard1Img, playerCardValueTotal, playerCard2Img, playerCard3Img, playerCard4Img, playerCard5Img, dealerCard2Img, dealerCard3Img, dealerCard4Img, dealerCard5Img, bet1Button, bet5Button, bet10Button, bet50Button, cancelBet);

        scene1 = new Scene(pane, 800, 500);
        logoutButton.requestFocus(); // For password
        scene1.getStylesheets().add("style.css");
        return scene1;
    }

    /*
    Checks whether the user has blackjack
     */

    public void checkForBlackJack() {
        if (playerFirstCard == 1 && (playerSecondCard - playerFirstCard) == 10 || playerFirstCard == 10 && (playerSecondCard - playerFirstCard) == 1) {
            System.out.println("Player has 21... Game ends - PLAYER WINS!");
            balance = balance + (betAmount * 3);
            balancePlayer.setText("Balance £" + balance);
            popUpDialog.setHeaderText("BlackJack...");
            popUpDialog.setContentText("BLACKJACK - Congratulations, you've won. £" + betAmount * 2);
            popUpDialog.showAndWait(); // Doesn't proceed with code until user presses okay
            roundEnd();
        } else {
            System.out.println("No blackjack... contuing game.");
        }
    }

    public void roundEnd() {
        playerCard1Img.setVisible(false);
        playerCard2Img.setVisible(false);
        playerCard3Img.setVisible(false);
        playerCard4Img.setVisible(false);
        playerCard5Img.setVisible(false);

        dealerCard1Img.setVisible(false);
        dealerCard2Img.setVisible(false);
        dealerCard3Img.setVisible(false);
        dealerCard4Img.setVisible(false);
        dealerCard5Img.setVisible(false);

        placeBet.setVisible(true);
        cancelBet.setVisible(true);
        bet1Button.setVisible(true);
        bet5Button.setVisible(true);
        bet10Button.setVisible(true);
        bet50Button.setVisible(true);

        hitButton.setVisible(false);
        standButton.setVisible(false);
        standButtonTriggered = false;
        betAmount = 0; // Resets the bet amount

        dealerTotal.setVisible(false);
        playerCardValueTotal.setVisible(false);

        placeBet.setText("PLACE BET");
    }

    public void win() {
        balance = balance + (betAmount * 2);
        balancePlayer.setText("Balance £" + balance);
        popUpDialog.setHeaderText("Congratulations...");
        popUpDialog.setContentText("WIN! - Congratulations, you've won £" + betAmount);
        popUpDialog.showAndWait(); // Doesn't proceed with code until user presses okay
        roundEnd();
    }

    public void lose() {
        balancePlayer.setText("Balance £" + balance);
        popUpDialog.setHeaderText("Unlucky...");
        popUpDialog.setContentText("Lose! - Unlucky, you lost £" + betAmount);
        popUpDialog.showAndWait(); // Doesn't proceed with code until user presses okay
        roundEnd();
    }

    public void push() {
        balance = balance + (betAmount);
        balancePlayer.setText("Balance £" + balance);
        popUpDialog.setHeaderText("PUSH...");
        popUpDialog.setContentText("PUSH! - Dealer and Players cards match... bet returned.");
        popUpDialog.showAndWait(); // Doesn't proceed with code until user presses okay
        roundEnd();
        System.out.println("PUSH");
    }

    /*
    To check whether the user is bust the code below is exectued based on a number
    of conditions they'll either win or lose
     */

    public void checkIfBust() {

        // If players card total is over 21
        if (deck.playerCardTotal > 21) {
            System.out.println("BUST - You loseeeeeee.");
            lose();
        }

        // If players card total is 21
        else if (deck.playerCardTotal == 21) {
            System.out.println("WINNER WINNER U GOT 21");
            win();
        }

        // If players card total is less than 21 and house total is greater than 21
        else if (deck.playerCardTotal < 21 && deck.houseCardTotal > 21) {
            System.out.println("WINNER If players card total is less than 21 and house total is greater than 21");
            win();
        }

        // If house total is over 17 && house total is not over 21 && house total is > player total
        else if (deck.playerCardTotal > 17 && deck.houseCardTotal < 21 && deck.houseCardTotal > deck.playerCardTotal) {
            System.out.println("If house total is over 17 && house total is not over 21 && house total is > player total");
            lose();
        }

        // If dealers hand is greater than 17 and dealer and player == same cards
        else if (deck.houseCardTotal >= 17 && deck.houseCardTotal == deck.playerCardTotal) {
            push();
        } else if (deck.houseCardTotal == 21 && deck.playerCardTotal < 21) {
            lose();
        } else if (deck.houseCardTotal <= 21 && standButtonTriggered == true && deck.houseCardTotal > deck.playerCardTotal) {
            lose();
        }

    }
}
