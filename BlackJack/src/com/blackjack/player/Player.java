package com.blackjack.player;

import com.blackjack.game.Deck;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private int currentHandValue;
    //a list of cards each person has on hand at the moment
    public List<Deck.Card> cardsOnHand = new ArrayList<>();
    /**
     * Draw cards from the deck and add to cards on hand
     * @param card
     */
    public void drawCards(Deck.Card card) {
        cardsOnHand.add(card);
    }
    /**
     * Reveal the first card
     */
    public void showFirstCard() {
        if ("HumanPlayer".equals(getClass().getSimpleName())) {
            System.out.println("Your first card is " + cardsOnHand.get(0));
        } else {
            System.out.println(this.getClass().getSimpleName() + "'s first card is " + cardsOnHand.get(0));
        }
    }
    /**
     *
     * @return The value of current hand
     */
    public int countCardValue() {
        int sum = 0;
        int aces = 0;

        for (Deck.Card card : cardsOnHand) {
            if (card.toString().contains("ACE")) {
                aces++;
            }
            sum = sum + card.getValue();
        }
        while (aces > 0 && sum > 21) {
            sum = sum - 10;
            aces--;
        }
        setCurrentHandValue(sum);
        return sum;
    }
    /**
     *
     * @return Reveal cards on hand
     */
    public List<Deck.Card> revealCards() {
        return cardsOnHand;
    }
    /**
     *
     * @return Current hand value
     */
    public int getCurrentHandValue() {
        return currentHandValue;
    }
    /**
     * Set current hand value
     * @param currentHandValue
     */
    public void setCurrentHandValue(int currentHandValue) {
        this.currentHandValue = currentHandValue;
    }
    /**
     *
     * @return true or false to stay or not to stay
     */
    public abstract boolean decision();
}