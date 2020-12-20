package com.mainpackage;

public interface DeckInterface<T> {

    /*
        The generic type T was not used nor the nodes because having a stack implemented as an array, means you can
        shuffle the deck of cards without removing each of the cards from the deck and adding it to an array.
        With the deck implemented as an stack array, this means you can easily access each of the values and
        will make for more easier sorting.
     */
    // this is where you will define the method used for the Deck
    /**
     * add a new card to the top of the deck
     * @param newCard return the specified card that needs to be added to the deck
     * exit the system if the deck is full
     * no need for a return type, as this just adds the card
     */

    public void push(T newCard);

    /**
     * remove the top card from the deck and assign the previous card the top of the deck
     * @return a string value that is the card that is removed
     * exit the system if the deck is empty
     * String type will be picked, as the card will be a string type, default this method with generic type T
     */

    public T pop();

    /**
     * this will return true if the deck is empty and false if not
     * @return boolean as its a true or false
     * if its the default value for the top card of -1, then it will return as true that deck is empty
     */


    public boolean isDeckEmpty();


    /**
     * This will show the current state of the deck of cards, either its the full deck or the players hand
     */

    public void show();


    /**
     * this will shuffle all the cards that was shown to the user and then use the random class to randomise the cards
     * will then show the cards to the user that have been shuffled
     */
    public void shuffle();


    /**
     * This will deal the sorted cards to each player, once it reaches 13 cards, it will go to the next player until
     * the cards are empty from the full deck
     */
    public void deal();

    /**
     * This will add the cards to the deck object by the suit and rank of the card
     */

    public void addCards();


}
