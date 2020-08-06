package com.blackjack.player;

public class Dealer extends Player {
    /**
     *
     * @return
     */
    @Override
    public boolean decision() {
        return getCurrentHandValue() < 17;
    }
}