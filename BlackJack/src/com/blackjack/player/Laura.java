package com.blackjack.player;

public class Laura extends Player {
    /**
     *
     * @return
     */
    @Override
    public boolean decision() {
        return getCurrentHandValue() < 15;
    }
}