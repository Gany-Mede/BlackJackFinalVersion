package com.blackjack.player;

public class Vlad extends Player {

    @Override
    public boolean decision() {
        return getCurrentHandValue() < 19;
    }
}