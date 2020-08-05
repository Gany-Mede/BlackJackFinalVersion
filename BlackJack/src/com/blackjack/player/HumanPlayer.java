package com.blackjack.player;

public class HumanPlayer extends Player {
    //the decision is done by the user input not the decision method
    @Override
    public boolean decision() {
        return false;
    }
}