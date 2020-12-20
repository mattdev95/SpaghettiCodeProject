package com.mainpackage;

import java.util.Random;

public class Deck<T> implements DeckInterface<T> {

    // create you instance variables
    // this will create an array of cards, this will be used to added the cards to.
    private String[] deckArray;
    // this will point the top card in the deck
    private int topCard;
    // this will define the capacity of deck, if its either 52 or 13
    private int deckCapacity;
    // this will be card count, for how many cards have been added to the deck
    private int cardCount = 0;

    // create your full deck of cards
    public static Deck<String> fullDeckOfCards = new Deck<String>(52);
    // create the player 1 deck
    public static Deck<String> player1 = new Deck<String>(13);
    // create the player 2 deck
    public static Deck<String> player2 = new Deck<String>(13);
    public static Deck<String> player3 = new Deck<String>(13);
    public static Deck<String> player4 = new Deck<String>(13);

    // create the rank contant variable that will start with the rank of the card, then the suit when added to the deck
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
            "King", "Ace"};
    // create your constant variable for the suits, as they will not change
    private static final String[] SUITS = {"Hearts", "Clubs", "Diamonds", "Spades"};

    // This contructor will initialise the deck of cards, will allow the defining of the size of the deck
    Deck(int deckSize) {
        // this will create a new array for the deck
        deckArray = new String[deckSize];
        // this points to the decksize
        deckCapacity = deckSize;
        // this will make sure there is the amount of cards that is supposed to have
        topCard = -1;
    }

    // this will push the new card to the deck
    public void push(T newCard) {
        // check if the top card has reached its limits
        if (topCard == deckCapacity) {
            // show an exit message
            System.out.println("The deck is full");
            System.exit(1);
        }
        // add to the check array the new card
        deckArray[++topCard] = (String) newCard;
    }


    public T pop() {
        // This will check if the there are no cards in the deck
        if (isDeckEmpty()) {
            // this will throw the empty stack exception
            System.out.println("The Deck is empty");
            // this will exit the program, if empty
            System.exit(1);
        }
        // this will remove a card from the deck
        return (T) deckArray[topCard--];
    }

    // to check if the deck is empty
    public boolean isDeckEmpty() {
        return topCard == -1;
    }

    public void show() {
        // this will show all the cards in the deck
        for (int i = 0; i < deckArray.length; i++) {
            System.out.println(deckArray[i]);

        }
    }

    public void deal() {

        // this will deal out cards to the four players
        for (int i = 0; i < 4; i++) {
            // this is a starting value
            int j = 0;
            // this will push the the cards individually to the four players
            while (j < 13) {
                // this will be pushed to player 1
                if (i == 0) {
                    player1.push(fullDeckOfCards.pop());
                    j++;
                    // this will be pushed to player 2
                } else if (i == 1) {
                    player2.push(fullDeckOfCards.pop());
                    j++;
                    // this will be pushed to player 3
                } else if (i == 2) {
                    player3.push(fullDeckOfCards.pop());
                    j++;
                    // this will be pushed to player 4
                } else if (i == 3) {
                    player4.push(fullDeckOfCards.pop());
                    j++;
                }

            }

        }

    }
    public void shuffle() {
        Random shuffleCards = new Random();
        int newIndex;
        String tempCard;

        //Anon (n.d.) https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/ [Accessed at: 30/09/20]
        // this will go through the deckArray in reverse order
        // the minus one will stop an ArrayOutOfBounds exception
        for (int i = deckArray.length - 1; i > -1; i--) {
            // this will be the pointer to the randomised card index value
            newIndex = shuffleCards.nextInt(i + 1);
            // this creates a temporary string pointer to the value of the deckArray with the new random index position
            tempCard = deckArray[newIndex];
            // this then updates the value of the deckArray of new the current value of i
            deckArray[newIndex] = deckArray[i];
            // the current index position of the deck array will point to the new random picked card in the deck
            deckArray[i] = tempCard;

        }

    }
    public void addCards() {

        // create an algorithm that adds the suit to the rank of the: Queens of Hearts
        // go through each suit, that would be a for loop and use a while loop to add each of the ranks to the suit

        for (int i = 0; i < SUITS.length; i++) {
            // this will take the current rank
            String takeSuit = SUITS[i];
            // this will intialise the variable to get each of the strings in the suit
            int j = 0;

            while (j < RANKS.length) {
                // this will equal the value of the suit
                String takeRank = RANKS[j];
                fullDeckOfCards.push((takeRank + " of " + takeSuit));
                //count++;
                j++;
                cardCount++;
            }

        }
        // then print out that the cards have been successfully added
        System.out.println("Cards added to the deck " + cardCount);

    }


}
