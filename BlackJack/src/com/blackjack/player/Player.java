package com.blackjack.player;

import com.blackjack.game.Deck;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private int currentHandValue;
    //a list of cards each person has on hand at the moment
    private List<Deck.Card> cardsOnHand = new ArrayList<>();


    public void drawCards(Deck.Card card) {
        cardsOnHand.add(card);
    }

    //reveal the first card
    public void showFirstCard() {
        if ("HumanPlayer".equals(getClass().getSimpleName())) {
            System.out.println("Your first card is " + cardsOnHand.get(0));
        } else {
            System.out.println(this.getClass().getSimpleName() + "'s first card is " + cardsOnHand.get(0));
        }
    }

    //count the card value with aces in mind
    public int countCardValue() {
        int sum = 0;
        int aces = 0;

        for (Deck.Card card : cardsOnHand) {
            if (card.toString().contains("ACE")) {
                aces++;
            }
            sum = sum + card.getValue();
        }
        if (sum > 21 && aces > 0) {
            sum = sum - 10;
            aces--;
        }
        setCurrentHandValue(sum);
        return sum;
    }

    public List<Deck.Card> revealCards() {
        return cardsOnHand;
    }

    public int getCurrentHandValue() {
        return currentHandValue;
    }

    public void setCurrentHandValue(int currentHandValue) {
        this.currentHandValue = currentHandValue;
    }

    public abstract boolean decision();
}