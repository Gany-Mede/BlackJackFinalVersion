package com.blackjack.player;

import com.blackjack.game.Deck;

public class Dealer extends Player {

    @Override
    public boolean decision() {
        return currentHandValue < 17;
    }

}
