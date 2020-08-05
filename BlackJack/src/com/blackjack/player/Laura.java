package com.blackjack.player;

public class Laura extends Player {

    @Override
    public boolean decision() {
        return getCurrentHandValue() < 15;
    }
}