package com.blackjack.player;

import com.blackjack.game.Deck;
import com.blackjack.game.Game;

public class Laura extends Player {

    @Override
    public boolean decision() {
        return currentHandValue < 15;
    }
}
