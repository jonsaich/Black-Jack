/**
 * BlackJack Application
 * <p>
 * This is the deck class where the original deck of 52 cards are created.
 * It forms of 2 arrays, one holding the card images and the other holding an integer value for the card iamge
 * this allows me to add the values together and know what card they have.
 * <p>
 * Benefits of using an arraylist is that you don't need to set a size, it is always growing and
 * i can easily add / remove elements from the list
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
import java.util.List;

public class PackOfCards {

    List<Image> cardsPic = new ArrayList<Image>(); // Used to store the images
    List<Integer> cardsValue = new ArrayList<Integer>(); // Used to store value of the images (cards)


    Image twoOfClubsImg = new Image("cards/2_of_clubs.png");
    Image threeOfClubsImg = new Image("cards/3_of_clubs.png");
    Image fourOfClubsImg = new Image("cards/4_of_clubs.png");
    Image fiveOfClubsImg = new Image("cards/5_of_clubs.png");
    Image sixOfClubsImg = new Image("cards/6_of_clubs.png");
    Image severnOfClubsImg = new Image("cards/7_of_clubs.png");
    Image eightOfClubsImg = new Image("cards/8_of_clubs.png");
    Image nineOfClubsImg = new Image("cards/9_of_clubs.png");
    Image tenOfClubsImg = new Image("cards/10_of_clubs.png");
    Image jackOfClubsImg = new Image("cards/jack_of_clubs.png");
    Image kingOfClubsImg = new Image("cards/king_of_clubs.png");
    Image queenOfClubsImg = new Image("cards/queen_of_clubs.png");
    Image aceImg = new Image("cards/ace_of_clubs.png");

    Image twoOfDiamondsImg = new Image("cards/2_of_diamonds.png");
    Image threeOfDiamondsImg = new Image("cards/3_of_diamonds.png");
    Image fourOfDiamondsImg = new Image("cards/4_of_diamonds.png");
    Image fiveOfDiamondsImg = new Image("cards/5_of_diamonds.png");
    Image sixOfDiamondsImg = new Image("cards/6_of_diamonds.png");
    Image severnOfDiamondsImg = new Image("cards/7_of_diamonds.png");
    Image eightOfDiamondsImg = new Image("cards/8_of_diamonds.png");
    Image nineOfDiamondsImg = new Image("cards/9_of_diamonds.png");
    Image tenOfDiamondsImg = new Image("cards/10_of_diamonds.png");
    Image jackOfDiamondsImg = new Image("cards/jack_of_diamonds.png");
    Image kingOfDiamondsImg = new Image("cards/king_of_diamonds.png");
    Image queenOfDiamondsImg = new Image("cards/queen_of_diamonds.png");
    Image aceImgOfDiamonds = new Image("cards/ace_of_diamonds.png");

    Image twoOfSpadesImg = new Image("cards/2_of_spades.png");
    Image threeOfSpadesImg = new Image("cards/3_of_spades.png");
    Image fourOfSpadesImg = new Image("cards/4_of_spades.png");
    Image fiveOfSpadesImg = new Image("cards/5_of_spades.png");
    Image sixOfSpadesImg = new Image("cards/6_of_spades.png");
    Image severnOfSpadesImg = new Image("cards/7_of_spades.png");
    Image eightOfSpadesImg = new Image("cards/8_of_spades.png");
    Image nineOfSpadesImg = new Image("cards/9_of_spades.png");
    Image tenOfSpadesImg = new Image("cards/10_of_spades.png");
    Image jackOfSpadesImg = new Image("cards/jack_of_spades.png");
    Image kingOfSpadesImg = new Image("cards/king_of_spades.png");
    Image queenOfSpadesImg = new Image("cards/queen_of_spades.png");
    Image aceImgOfSpades = new Image("cards/ace_of_spades.png");

    Image twoOfHeartsImg = new Image("cards/2_of_hearts.png");
    Image threeOfHeartsImg = new Image("cards/3_of_hearts.png");
    Image fourOfHeartsImg = new Image("cards/4_of_hearts.png");
    Image fiveOfHeartsImg = new Image("cards/5_of_hearts.png");
    Image sixOfHeartsImg = new Image("cards/6_of_hearts.png");
    Image severnOfHeartsImg = new Image("cards/7_of_hearts.png");
    Image eightOfHeartsImg = new Image("cards/8_of_hearts.png");
    Image nineOfHeartsImg = new Image("cards/9_of_hearts.png");
    Image tenOfHeartsImg = new Image("cards/10_of_hearts.png");
    Image jackOfHeartsImg = new Image("cards/jack_of_hearts.png");
    Image kingOfHeartsImg = new Image("cards/king_of_hearts.png");
    Image queenOfHeartsImg = new Image("cards/queen_of_hearts.png");
    Image aceImgOfHearts = new Image("cards/ace_of_hearts.png");


    public PackOfCards() {

        cardsValue.add(1); // Value 1 / 11
        cardsPic.add(aceImg);
        cardsValue.add(2); // Value 2
        cardsPic.add(twoOfClubsImg);
        cardsValue.add(3); // Value 3
        cardsPic.add(threeOfClubsImg);
        cardsValue.add(4); // Value 4
        cardsPic.add(fourOfClubsImg);
        cardsValue.add(5); // Value 5
        cardsPic.add(fiveOfClubsImg);
        cardsValue.add(6); // Value 6
        cardsPic.add(sixOfClubsImg);
        cardsValue.add(7); // Value 7
        cardsPic.add(severnOfClubsImg);
        cardsValue.add(8); // Value 8
        cardsPic.add(eightOfClubsImg);
        cardsValue.add(9); // Value 9
        cardsPic.add(nineOfClubsImg);
        cardsValue.add(10); // Value 10
        cardsPic.add(tenOfClubsImg);
        cardsValue.add(10); // Value 10
        cardsPic.add(jackOfClubsImg);
        cardsValue.add(10); // Value 10
        cardsPic.add(kingOfClubsImg);
        cardsValue.add(10); // Value 10
        cardsPic.add(queenOfClubsImg);


        cardsValue.add(1); // Value 1 / 11
        cardsPic.add(aceImg);
        cardsValue.add(2); // Value 2
        cardsPic.add(twoOfDiamondsImg);
        cardsValue.add(3); // Value 3
        cardsPic.add(threeOfDiamondsImg);
        cardsValue.add(4); // Value 4
        cardsPic.add(fourOfDiamondsImg);
        cardsValue.add(5); // Value 5
        cardsPic.add(fiveOfDiamondsImg);
        cardsValue.add(6); // Value 6
        cardsPic.add(sixOfDiamondsImg);
        cardsValue.add(7); // Value 7
        cardsPic.add(severnOfDiamondsImg);
        cardsValue.add(8); // Value 8
        cardsPic.add(eightOfDiamondsImg);
        cardsValue.add(9); // Value 9
        cardsPic.add(nineOfDiamondsImg);
        cardsValue.add(10); // Value 10
        cardsPic.add(tenOfDiamondsImg);
        cardsValue.add(10); // Value 10
        cardsPic.add(jackOfDiamondsImg);
        cardsValue.add(10); // Value 10
        cardsPic.add(kingOfDiamondsImg);
        cardsValue.add(10); // Value 10
        cardsPic.add(queenOfDiamondsImg);


        cardsValue.add(1); // Value 1 / 11
        cardsPic.add(aceImg);
        cardsValue.add(2); // Value 2
        cardsPic.add(twoOfSpadesImg);
        cardsValue.add(3); // Value 3
        cardsPic.add(threeOfSpadesImg);
        cardsValue.add(4); // Value 4
        cardsPic.add(fourOfSpadesImg);
        cardsValue.add(5); // Value 5
        cardsPic.add(fiveOfSpadesImg);
        cardsValue.add(6); // Value 6
        cardsPic.add(sixOfSpadesImg);
        cardsValue.add(7); // Value 7
        cardsPic.add(severnOfSpadesImg);
        cardsValue.add(8); // Value 8
        cardsPic.add(eightOfSpadesImg);
        cardsValue.add(9); // Value 9
        cardsPic.add(nineOfSpadesImg);
        cardsValue.add(10); // Value 10
        cardsPic.add(tenOfSpadesImg);
        cardsValue.add(10); // Value 10
        cardsPic.add(jackOfSpadesImg);
        cardsValue.add(10); // Value 10
        cardsPic.add(kingOfSpadesImg);
        cardsValue.add(10); // Value 10
        cardsPic.add(queenOfSpadesImg);


        cardsValue.add(1); // Value 1 / 11
        cardsPic.add(aceImg);
        cardsValue.add(2); // Value 2
        cardsPic.add(twoOfHeartsImg);
        cardsValue.add(3); // Value 3
        cardsPic.add(threeOfHeartsImg);
        cardsValue.add(4); // Value 4
        cardsPic.add(fourOfHeartsImg);
        cardsValue.add(5); // Value 5
        cardsPic.add(fiveOfHeartsImg);
        cardsValue.add(6); // Value 6
        cardsPic.add(sixOfHeartsImg);
        cardsValue.add(7); // Value 7
        cardsPic.add(severnOfHeartsImg);
        cardsValue.add(8); // Value 8
        cardsPic.add(eightOfHeartsImg);
        cardsValue.add(9); // Value 9
        cardsPic.add(nineOfHeartsImg);
        cardsValue.add(10); // Value 10
        cardsPic.add(tenOfHeartsImg);
        cardsValue.add(10); // Value 10
        cardsPic.add(jackOfHeartsImg);
        cardsValue.add(10); // Value 10
        cardsPic.add(kingOfHeartsImg);
        cardsValue.add(10); // Value 10
        cardsPic.add(queenOfHeartsImg);

    }
}