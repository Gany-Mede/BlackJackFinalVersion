package com.blackjack.player;

public class Dealer extends Player {

    @Override
    public boolean decision() {
        return getCurrentHandValue() < 17;
    }
}