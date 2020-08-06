package com.blackjack.player;

public class Vlad extends Player {
    /**
     *
     * @return
     */
    @Override
    public boolean decision() {
        return getCurrentHandValue() < 19;
    }
}