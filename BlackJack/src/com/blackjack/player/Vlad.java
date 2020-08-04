package com.blackjack.player;

import com.blackjack.game.Deck;
import com.blackjack.game.Game;

public class Vlad extends Player {

    @Override
    public boolean decision() {
        return getCurrentHandValue() < 19;
    }
}
