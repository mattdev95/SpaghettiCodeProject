package com.mainpackage;


public class BridgeDealer extends Deck<String> {
    BridgeDealer(int size) {
        // define your super class
        super(size);

    }

    // setup the arrays and allocate memory to them, this is only for the sorting algorithms
    //  this is for the sorting of the deck of cards only
    //  array for player decks to be added from the Deck ADT
    private String[] player1_r = new String[13];
    private String[] player2_r = new String[13];
    private String[] player3_r = new String[13];
    private String[] player4_r = new String[13];
    // this will store the sorted cards by SUIT
    private String[] player1_temp_suit = new String[13];
    private String[] player2_temp_suit = new String[13];
    private String[] player3_temp_suit = new String[13];
    private String[] player4_temp_suit = new String[13];
    // this will store the sorted cards by RANK
    private String[] player1_temp = new String[13];
    private String[] player2_temp = new String[13];
    private String[] player3_temp = new String[13];
    private String[] player4_temp = new String[13];
    //   create an array of values for the index position of each rank
    private static int[] rankIndexPlayer1 = new int[13];
    //  create an array of values for the index position of each rank
    private static int[] rankIndexPlayer2 = new int[13];
    //  create an array of values for the index position of each rank
    private static int[] rankIndexPlayer3 = new int[13];
    //  create an array of values for the index position of each rank
    private static int[] rankIndexPlayer4 = new int[13];

    // I have implemented in a way, that each player has its own sorting algorithm, this allows the popping of the cards
    // from the stack and adding it to an array and then converting the array to a index position array with the first
    // index being 1. Then the index position array is then is converted back to the cards, which are then sorted and
    // added to player deck in the ADT. This was probably not the best of way, but it was the most efficient way I found
    // through using this implementation. For next time I would implement the Card object and the manipulate with the use
    // of the toString method and add the cards as enums and not as an array of strings.
    private void player1_sort() {

        // this removes the cards from the player1 deck into an array to be sorted
        for (int i = 0; i < 13; i++) {
            player1_r[i] = player1.pop();
        }

        // we want to create an array of index positions of the ranks, so we can sort the index position and then convert back to the cards
        for (int j = 0; j < 13; j++) {
            if (player1_r[j].contains("Hearts")) {
                rankIndexPlayer1[j] = 1;

            } else if (player1_r[j].contains("Clubs")) {
                rankIndexPlayer1[j] = 2;

            } else if (player1_r[j].contains("Diamonds")) {
                rankIndexPlayer1[j] = 3;

            } else if (player1_r[j].contains("Spades")) {
                rankIndexPlayer1[j] = 4;

            }
        }

        // setup your local variables
        int count = 0;
        int cardCount = 0;
        while (count != 4) {
            // this will check if there is ones in the rankindex_r array
            for (int i = 0; i < 13; i++) {
                // this will be a pointer to check the card if its 1
                int playerCard1 = rankIndexPlayer1[i];
                // if a 1 has been found, then you want to set the first index position to the index postion of i
                if (playerCard1 == 1) {
                    player1_temp[cardCount] = player1_r[i];
                    cardCount++;

                }
            }
            // interate the count, as 1 has been found
            count++;
            // check if there is twos in the array
            for (int i = 0; i < 13; i++) {
                // this will be a pointer to check the card if its 2
                int playerCard2 = rankIndexPlayer1[i];
                // if a 2 has been found, then you want to set the first index position to the index postion of i
                if (playerCard2 == 2) {
                    player1_temp[cardCount] = player1_r[i];
                    cardCount++;
                }
            }
            count++;
            for (int i = 0; i < 13; i++) {
                // this will be a pointer to check the card if its 3
                int playerCard3 = rankIndexPlayer1[i];
                // if a 3 has been found, then you want to set the first index position to the index postion of i
                if (playerCard3 == 3) {
                    player1_temp[cardCount] = player1_r[i];
                    cardCount++;
                }
            }
            count++;
            for (int i = 0; i < 13; i++) {
                // this will be a pointer to check the card if its 4
                int playerCard4 = rankIndexPlayer1[i];
                // if a 4 has been found, then you want to set the first index position to the index postion of i
                if (playerCard4 == 4) {
                    player1_temp[cardCount] = player1_r[i];
                    cardCount++;
                }
            }
            count++;

        }

        // this will convert the order of the suit******************************************************************
        // setup your local variables

        // int count = 0;
        // int cardCount = 0;
        // set your local variables
        int suitCount = 0;
        int cardCount1 = 0;
        // this is redunant
        int player1_count = 0;
        int found = 0;
        int y = 0;
        // int playerCard1 = 0;
        while (suitCount != 4) {
            // this will check if there is ones in the
            for (int i = 0; i < 13; i++) {

                    // the position will start at zero, as this will check if there are hearts in the deck of cards
                    if (y == 0) {
                        // this will check all the while loops has ran
                        while (found != 13) {
                            int j = 0;
                            // loop through all values to find that defined values
                            while (j < 13) {
                                if (player1_temp[j].contains("2 of Hearts")) {
                                    // this will equal the found position
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                          //  System.out.println(cardCount1 + " 1");
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("3 of Hearts")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;

                                    break;

                                }
                                j++;
                            }

                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("4 of Hearts")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;

                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("5 of Hearts")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }

                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("6 of Hearts")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("7 of Hearts")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("8 of Hearts")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("9 of Hearts")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("10 of Hearts")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("Jack of Hearts")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("Queen of Hearts")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("King of Hearts")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("Ace of Hearts")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            y++;
                            found++;



                        }
                        suitCount++;
                        found = 0;

                    // now y should be equal to one
                    } else if (y == 1) {
                        // now go through if clubs have been found
                        while (found != 13) {
                            int j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("2 of Clubs")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("3 of Clubs")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;

                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("4 of Clubs")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;

                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("5 of Clubs")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }

                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("6 of Clubs")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("7 of Clubs")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("8 of Clubs")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("9 of Clubs")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("10 of Clubs")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("Jack of Clubs")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("Queen of Clubs")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("King of Clubs")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("Ace of Clubs")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            y++;
                            found++;



                        }
                        suitCount++;
                        found = 0;
                        // should now equal to 2
                    } else if (y == 2) {
                        // if a 1 has been found, then you want to set the first index position to the index postion of i
                        while (found != 13) {
                            int j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("2 of Diamonds")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;

                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("3 of Diamonds")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;

                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("4 of Diamonds")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;

                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("5 of Diamonds")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }

                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("6 of Diamonds")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("7 of Diamonds")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("8 of Diamonds")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("9 of Diamonds")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("10 of Diamonds")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("Jack of Diamonds")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("Queen of Diamonds")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("King of Diamonds")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("Ace of Diamonds")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            y++;
                            found++;



                        }
                        suitCount++;
                        found = 0;

                    } else if(y == 3){
                        while (found != 13) {
                            int j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("2 of Spades")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;

                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("3 of Spades")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;

                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("4 of Spades")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;

                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("5 of Spades")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }

                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("6 of Spades")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("7 of Spades")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("8 of Spades")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("9 of Spades")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("10 of Spades")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("Jack of Spades")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("Queen of Spades")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;

                            while (j < 13) {
                                if (player1_temp[j].contains("King of Spades")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            found++;
                            j = 0;
                            while (j < 13) {
                                if (player1_temp[j].contains("Ace of Spades")) {
                                    player1_temp_suit[cardCount1] = player1_temp[j];
                                    cardCount1++;
                                    player1_count++;
                                    break;

                                }
                                j++;
                            }
                            y++;
                            found++;



                        }
                        suitCount++;
                    }
                    //  break;


            }

        }

        for (int i = 0; i < 13; i++) {
            // this will add the sorted array to the player
            player1.push(player1_temp_suit[i]);
        }

    }


        // this will push the sorted cards to the deck ADT





    private void player2_sort() {

        // this removes the cards from the player1 deck into an array to be sorted
        for (int i = 0; i < 13; i++) {
            player2_r[i] = player2.pop();
        }

        // we want to create an array of index positions of the ranks, so we can sort the index position and then convert back to the cards
        for (int j = 0; j < 13; j++) {
            if (player2_r[j].contains("Hearts")) {
                rankIndexPlayer2[j] = 1;

            } else if (player2_r[j].contains("Clubs")) {
                rankIndexPlayer2[j] = 2;

            } else if (player2_r[j].contains("Diamonds")) {
                rankIndexPlayer2[j] = 3;

            } else if (player2_r[j].contains("Spades")) {
                rankIndexPlayer2[j] = 4;

            }
        }



//        for(int i = 0; i< 13; i++){
//            System.out.println(suitIndexPlayer1[i]);
//        }


        // setup your local variables
        int count = 0;
        int cardCount = 0;
        while (count != 4) {
            // this will check if there is ones in the rankindex_r array
            for (int i = 0; i < 13; i++) {
                // this will be a pointer to check the card if its 1
                int playerCard1 = rankIndexPlayer2[i];
                // if a 1 has been found, then you want to set the first index position to the index postion of i
                if (playerCard1 == 1) {
                    player2_temp[cardCount] = player2_r[i];
                    cardCount++;

                }
            }
            // interate the count, as 1 has been found
            count++;
            // check if there is twos in the array
            for (int i = 0; i < 13; i++) {
                // this will be a pointer to check the card if its 2
                int playerCard2 = rankIndexPlayer2[i];
                // if a 2 has been found, then you want to set the first index position to the index postion of i
                if (playerCard2 == 2) {
                    player2_temp[cardCount] = player2_r[i];
                    cardCount++;
                }
            }
            count++;
            for (int i = 0; i < 13; i++) {
                // this will be a pointer to check the card if its 3
                int playerCard3 = rankIndexPlayer2[i];
                // if a 3 has been found, then you want to set the first index position to the index postion of i
                if (playerCard3 == 3) {
                    player2_temp[cardCount] = player2_r[i];
                    cardCount++;
                }
            }
            count++;
            for (int i = 0; i < 13; i++) {
                // this will be a pointer to check the card if its 4
                int playerCard4 = rankIndexPlayer2[i];
                // if a 4 has been found, then you want to set the first index position to the index postion of i
                if (playerCard4 == 4) {
                    player2_temp[cardCount] = player2_r[i];
                    cardCount++;
                }
            }
            count++;

        }

        // this will convert the order of the suit******************************************************************
        // setup your local variables

        // int count = 0;
        // int cardCount = 0;

        int suitCount = 0;
        int cardCount1 = 0;
        int player1_count = 0;
        int found = 0;
        int y = 0;
        // int playerCard1 = 0;
        while (suitCount != 4) {
            // this will check if there is ones in the
            for (int i = 0; i < 13; i++) {

                // this will be a pointer to check the card if its 1
                //int playerCard1 = suitIndexPlayer2[i];
                // if a 1 has been found, then you want to set the first index position to the index postion of i


                if (y == 0) {
                    while (found != 13) {
                        int j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("2 of Hearts")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        //  System.out.println(cardCount1 + " 1");
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("3 of Hearts")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("4 of Hearts")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("5 of Hearts")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("6 of Hearts")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("7 of Hearts")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("8 of Hearts")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("9 of Hearts")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("10 of Hearts")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("Jack of Hearts")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("Queen of Hearts")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("King of Hearts")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("Ace of Hearts")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        y++;
                        found++;



                    }
                    suitCount++;
                    found = 0;


                } else if (y == 1) {
                    while (found != 13) {
                        int j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("2 of Clubs")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("3 of Clubs")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("4 of Clubs")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("5 of Clubs")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("6 of Clubs")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("7 of Clubs")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("8 of Clubs")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("9 of Clubs")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("10 of Clubs")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("Jack of Clubs")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("Queen of Clubs")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("King of Clubs")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("Ace of Clubs")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        y++;
                        found++;



                    }
                    suitCount++;
                    found = 0;
                } else if (y == 2) {
                    // if a 1 has been found, then you want to set the first index position to the index postion of i
                    while (found != 13) {
                        int j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("2 of Diamonds")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("3 of Diamonds")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("4 of Diamonds")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("5 of Diamonds")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("6 of Diamonds")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("7 of Diamonds")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("8 of Diamonds")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("9 of Diamonds")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("10 of Diamonds")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("Jack of Diamonds")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("Queen of Diamonds")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("King of Diamonds")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("Ace of Diamonds")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        y++;
                        found++;



                    }
                    suitCount++;
                    found = 0;

                } else if(y == 3){
                    while (found != 13) {
                        int j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("2 of Spades")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("3 of Spades")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("4 of Spades")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("5 of Spades")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("6 of Spades")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("7 of Spades")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("8 of Spades")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("9 of Spades")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("10 of Spades")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("Jack of Spades")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("Queen of Spades")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player2_temp[j].contains("King of Spades")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player2_temp[j].contains("Ace of Spades")) {
                                player2_temp_suit[cardCount1] = player2_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        y++;
                        found++;



                    }
                    suitCount++;
                }
                //  break;





            }

        }

        for (int i = 0; i < 13; i++) {

            player2.push(player2_temp_suit[i]);
        }

    }



    private void player3_sort() {

        // this removes the cards from the player1 deck into an array to be sorted
        for (int i = 0; i < 13; i++) {
            player3_r[i] = player3.pop();
        }

        // we want to create an array of index positions of the ranks, so we can sort the index position and then convert back to the cards
        for (int j = 0; j < 13; j++) {
            if (player3_r[j].contains("Hearts")) {
                rankIndexPlayer3[j] = 1;

            } else if (player3_r[j].contains("Clubs")) {
                rankIndexPlayer3[j] = 2;

            } else if (player3_r[j].contains("Diamonds")) {
                rankIndexPlayer3[j] = 3;

            } else if (player3_r[j].contains("Spades")) {
                rankIndexPlayer3[j] = 4;

            }
        }



//        for(int i = 0; i< 13; i++){
//            System.out.println(suitIndexPlayer1[i]);
//        }


        // setup your local variables
        int count = 0;
        int cardCount = 0;
        while (count != 4) {
            // this will check if there is ones in the rankindex_r array
            for (int i = 0; i < 13; i++) {
                // this will be a pointer to check the card if its 1
                int playerCard1 = rankIndexPlayer3[i];
                // if a 1 has been found, then you want to set the first index position to the index postion of i
                if (playerCard1 == 1) {
                    player3_temp[cardCount] = player3_r[i];
                    cardCount++;

                }
            }
            // interate the count, as 1 has been found
            count++;
            // check if there is twos in the array
            for (int i = 0; i < 13; i++) {
                // this will be a pointer to check the card if its 2
                int playerCard2 = rankIndexPlayer3[i];
                // if a 2 has been found, then you want to set the first index position to the index postion of i
                if (playerCard2 == 2) {
                    player3_temp[cardCount] = player3_r[i];
                    cardCount++;
                }
            }
            count++;
            for (int i = 0; i < 13; i++) {
                // this will be a pointer to check the card if its 3
                int playerCard3 = rankIndexPlayer3[i];
                // if a 3 has been found, then you want to set the first index position to the index postion of i
                if (playerCard3 == 3) {
                    player3_temp[cardCount] = player3_r[i];
                    cardCount++;
                }
            }
            count++;
            for (int i = 0; i < 13; i++) {
                // this will be a pointer to check the card if its 4
                int playerCard4 = rankIndexPlayer3[i];
                // if a 4 has been found, then you want to set the first index position to the index postion of i
                if (playerCard4 == 4) {
                    player3_temp[cardCount] = player3_r[i];
                    cardCount++;
                }
            }
            count++;

        }

        // this will convert the order of the suit******************************************************************
        // setup your local variables

        // int count = 0;
        // int cardCount = 0;

        int suitCount = 0;
        int cardCount1 = 0;
        int player1_count = 0;
        int found = 0;
        int y = 0;
        // int playerCard1 = 0;
        while (suitCount != 4) {
            // this will check if there is ones in the
            for (int i = 0; i < 13; i++) {

                // this will be a pointer to check the card if its 1
                //int playerCard1 = suitIndexPlayer2[i];
                // if a 1 has been found, then you want to set the first index position to the index postion of i


                if (y == 0) {
                    while (found != 13) {
                        int j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("2 of Hearts")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        //  System.out.println(cardCount1 + " 1");
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("3 of Hearts")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;


                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("4 of Hearts")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("5 of Hearts")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("6 of Hearts")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("7 of Hearts")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("8 of Hearts")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("9 of Hearts")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("10 of Hearts")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("Jack of Hearts")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("Queen of Hearts")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("King of Hearts")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("Ace of Hearts")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        y++;
                        found++;



                    }
                    suitCount++;
                    found = 0;


                } else if (y == 1) {
                    while (found != 13) {
                        int j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("2 of Clubs")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("3 of Clubs")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("4 of Clubs")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("5 of Clubs")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("6 of Clubs")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("7 of Clubs")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("8 of Clubs")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("9 of Clubs")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("10 of Clubs")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("Jack of Clubs")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("Queen of Clubs")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("King of Clubs")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("Ace of Clubs")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        y++;
                        found++;



                    }
                    suitCount++;
                    found = 0;
                } else if (y == 2) {
                    // if a 1 has been found, then you want to set the first index position to the index postion of i
                    while (found != 13) {
                        int j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("2 of Diamonds")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("3 of Diamonds")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("4 of Diamonds")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("5 of Diamonds")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("6 of Diamonds")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("7 of Diamonds")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("8 of Diamonds")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("9 of Diamonds")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("10 of Diamonds")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("Jack of Diamonds")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("Queen of Diamonds")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("King of Diamonds")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("Ace of Diamonds")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        y++;
                        found++;



                    }
                    suitCount++;
                    found = 0;

                } else if(y == 3){
                    while (found != 13) {
                        int j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("2 of Spades")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("3 of Spades")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("4 of Spades")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("5 of Spades")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("6 of Spades")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("7 of Spades")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("8 of Spades")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("9 of Spades")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("10 of Spades")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("Jack of Spades")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("Queen of Spades")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player3_temp[j].contains("King of Spades")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player3_temp[j].contains("Ace of Spades")) {
                                player3_temp_suit[cardCount1] = player3_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        y++;
                        found++;



                    }
                    suitCount++;
                }
                //  break;





            }

        }

        for (int i = 0; i < 13; i++) {

            player3.push(player3_temp_suit[i]);
        }

    }
    //
    private void player4_sort() {

        // this removes the cards from the player1 deck into an array to be sorted
        for (int i = 0; i < 13; i++) {
            player4_r[i] = player4.pop();
        }

        // we want to create an array of index positions of the ranks, so we can sort the index position and then convert back to the cards
        for (int j = 0; j < 13; j++) {
            if (player4_r[j].contains("Hearts")) {
                rankIndexPlayer4[j] = 1;

            } else if (player4_r[j].contains("Clubs")) {
                rankIndexPlayer4[j] = 2;

            } else if (player4_r[j].contains("Diamonds")) {
                rankIndexPlayer4[j] = 3;

            } else if (player4_r[j].contains("Spades")) {
                rankIndexPlayer4[j] = 4;

            }
        }



//        for(int i = 0; i< 13; i++){
//            System.out.println(suitIndexPlayer1[i]);
//        }


        // setup your local variables
        int count = 0;
        int cardCount = 0;
        while (count != 4) {
            // this will check if there is ones in the rankindex_r array
            for (int i = 0; i < 13; i++) {
                // this will be a pointer to check the card if its 1
                int playerCard1 = rankIndexPlayer4[i];
                // if a 1 has been found, then you want to set the first index position to the index postion of i
                if (playerCard1 == 1) {
                    player4_temp[cardCount] = player4_r[i];
                    cardCount++;

                }
            }
            // interate the count, as 1 has been found
            count++;
            // check if there is twos in the array
            for (int i = 0; i < 13; i++) {
                // this will be a pointer to check the card if its 2
                int playerCard2 = rankIndexPlayer4[i];
                // if a 2 has been found, then you want to set the first index position to the index postion of i
                if (playerCard2 == 2) {
                    player4_temp[cardCount] = player4_r[i];
                    cardCount++;
                }
            }
            count++;
            for (int i = 0; i < 13; i++) {
                // this will be a pointer to check the card if its 3
                int playerCard3 = rankIndexPlayer4[i];
                // if a 3 has been found, then you want to set the first index position to the index postion of i
                if (playerCard3 == 3) {
                    player4_temp[cardCount] = player4_r[i];
                    cardCount++;
                }
            }
            count++;
            for (int i = 0; i < 13; i++) {
                // this will be a pointer to check the card if its 4
                int playerCard4 = rankIndexPlayer4[i];
                // if a 4 has been found, then you want to set the first index position to the index postion of i
                if (playerCard4 == 4) {
                    player4_temp[cardCount] = player4_r[i];
                    cardCount++;
                }
            }
            count++;

        }

        // this will convert the order of the suit******************************************************************
        // setup your local variables

        // int count = 0;
        // int cardCount = 0;

        int suitCount = 0;
        int cardCount1 = 0;
        int player1_count = 0;
        int found = 0;
        int y = 0;
        // int playerCard1 = 0;
        while (suitCount != 4) {
            // this will check if there is ones in the
            for (int i = 0; i < 13; i++) {

                // this will be a pointer to check the card if its 1
                //int playerCard1 = suitIndexPlayer2[i];
                // if a 1 has been found, then you want to set the first index position to the index postion of i


                if (y == 0) {
                    while (found != 13) {
                        int j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("2 of Hearts")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        //  System.out.println(cardCount1 + " 1");
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("3 of Hearts")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;


                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("4 of Hearts")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("5 of Hearts")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("6 of Hearts")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("7 of Hearts")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("8 of Hearts")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("9 of Hearts")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("10 of Hearts")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("Jack of Hearts")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("Queen of Hearts")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("King of Hearts")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("Ace of Hearts")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        y++;
                        found++;



                    }
                    suitCount++;
                    found = 0;


                } else if (y == 1) {
                    while (found != 13) {
                        int j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("2 of Clubs")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("3 of Clubs")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("4 of Clubs")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("5 of Clubs")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("6 of Clubs")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("7 of Clubs")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("8 of Clubs")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("9 of Clubs")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("10 of Clubs")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("Jack of Clubs")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("Queen of Clubs")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("King of Clubs")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("Ace of Clubs")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        y++;
                        found++;



                    }
                    suitCount++;
                    found = 0;
                } else if (y == 2) {
                    // if a 1 has been found, then you want to set the first index position to the index postion of i
                    while (found != 13) {
                        int j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("2 of Diamonds")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("3 of Diamonds")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("4 of Diamonds")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("5 of Diamonds")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("6 of Diamonds")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("7 of Diamonds")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("8 of Diamonds")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("9 of Diamonds")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("10 of Diamonds")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("Jack of Diamonds")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("Queen of Diamonds")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("King of Diamonds")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("Ace of Diamonds")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        y++;
                        found++;



                    }
                    suitCount++;
                    found = 0;

                } else if(y == 3){
                    while (found != 13) {
                        int j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("2 of Spades")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("3 of Spades")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("4 of Spades")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;

                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("5 of Spades")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }

                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("6 of Spades")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("7 of Spades")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("8 of Spades")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("9 of Spades")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("10 of Spades")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("Jack of Spades")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("Queen of Spades")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;

                        while (j < 13) {
                            if (player4_temp[j].contains("King of Spades")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        found++;
                        j = 0;
                        while (j < 13) {
                            if (player4_temp[j].contains("Ace of Spades")) {
                                player4_temp_suit[cardCount1] = player4_temp[j];
                                cardCount1++;
                                player1_count++;
                                break;

                            }
                            j++;
                        }
                        y++;
                        found++;



                    }
                    suitCount++;
                }
                //  break;


            }

        }

        for (int i = 0; i < 13; i++) {

            player4.push(player4_temp_suit[i]);
        }


    }

    private void sort() {
        // this will call each of the methods and sort each player
        player1_sort();
        player2_sort();
        player3_sort();
        player4_sort();

    }

    //and a show hand method will also need to be
    //implemented to display the cards in an individual player’s hand.
    private void showHand() {

        System.out.println("Player 1 Hand");
        System.out.println("**************************");
        player1.show();
        System.out.println("**************************");
        System.out.println("Player 2 Hand");
        System.out.println("**************************");
        player2.show();
        System.out.println("**************************");
        System.out.println("Player 3 Hand");
        System.out.println("**************************");
        player3.show();
        System.out.println("**************************");
        System.out.println("Player 4 Hand");
        System.out.println("**************************");
        player4.show();

    }

    public static void main(String[] args) {

        System.out.println("Adding the cards now......");
        // this will add the cards to the deck by calling the add cards method in the ADT
        fullDeckOfCards.addCards();
        System.out.println("****************************************");
        // This will show all the cards in the deck
        System.out.println("************Showing cards****************");
        fullDeckOfCards.show();
        System.out.println("******************Shuffle*****************");
        fullDeckOfCards.shuffle();
        System.out.println("******************show shuffle*****************");
        fullDeckOfCards.show();
        // then deal out the cards to the four players
        System.out.println("***********Dealing to the four players**********");
        fullDeckOfCards.deal();
        System.out.println("************************************");
        // create an instance of the bridge deal class, so we can access the methods
        BridgeDealer dealCards = new BridgeDealer(13);
        System.out.println("***********Showing the four players hands**********");
        // call the show hand method
        dealCards.showHand();
        System.out.println("**************Sorting cards*************");
        // this sort the cards in each players hands
        dealCards.sort();
        System.out.println("**************Show sorted cards*************");
        // then show hand will be sorted cards
        dealCards.showHand();

    }

}