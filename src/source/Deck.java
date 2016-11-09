/**
 * BlackJack Application
 * <p>
 * This is the deck class where the deck all 6 decks are formed.
 * It links to the PackOfCards which has 52 cards and creates an object of that.
 * Using a for loop 312 cards (6 decks) are created.
 * <p>
 * This is the class where cards are shuffled, dealt and kept acount of.
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

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Deck {

    int cardNumber = 0;
    int playerTotalCardValue = 0;
    int houseTotalCardValue = 0;
    int playerCardTotal = 0;
    int houseCardTotal = 0;
    int cardsInDeckCounter = 0;


    PackOfCards theDeck = new PackOfCards();
    List<Image> newCardsPic = new ArrayList<Image>();
    List<Integer> newCardsValue = new ArrayList<Integer>();


    public void shuffleDeck() {

        // 312 = 6 decks (52 cards in a deck, 52 * 6 = 312)
        for (int i = 0; i < 312; i++) {
            if (cardsInDeckCounter > 51) {
                cardsInDeckCounter = 0;
                System.out.println("Deck complete... adding new deck");
            }

            newCardsPic.add(theDeck.cardsPic.get(cardsInDeckCounter));
            newCardsValue.add(theDeck.cardsValue.get(cardsInDeckCounter));
            cardsInDeckCounter++;
        }


        long seed = System.nanoTime(); // Syncronised random. For both arrays
        Collections.shuffle(newCardsPic, new Random(seed));
        Collections.shuffle(newCardsValue, new Random(seed));
        System.out.println("Cards Shuffled");
    }

    public void giveCard() {

        cardNumber++;
    }

    public Integer dealCardPlayer() {

        playerCardTotal = playerCardTotal + newCardsValue.get(cardNumber);
        playerTotalCardValue++;

        return playerCardTotal;

    }

    public Image dealCardPlayerImg() {

        return newCardsPic.get(cardNumber);
    }


    public Object dealCardHouse() {

        houseCardTotal = houseCardTotal + newCardsValue.get(cardNumber);
        houseTotalCardValue++;

        return houseCardTotal;
    }

    public Image dealCardHouseImg() {

        return newCardsPic.get(cardNumber);
    }

}

