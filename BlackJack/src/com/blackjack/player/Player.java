package com.blackjack.player;

import com.blackjack.game.Deck;
import com.blackjack.game.Game;

public abstract class Player {
     int currentHand;
     Deck.Card firstCard;
     Deck.Card secondCard;

    //set first card then reveal it
    public void setFirstCard(Deck.Card card){
        this.firstCard = card;
        showFirstCard();
    }
    public void showFirstCard(){
        if("HumanPlayer".equals(getClass().getSimpleName())){
            System.out.println("Your first card is " + firstCard);
        }
        else{
            System.out.println(this.getClass().getSimpleName() + "'s first card is " + firstCard);
        }
    }
    public void setSecondCard(Deck.Card card){
        this.secondCard = card;
    }

    public Deck.Card getFirstCard() {
        return firstCard;
    }

    public Deck.Card getSecondCard() {
        return secondCard;
    }

    public abstract void decision();

}
