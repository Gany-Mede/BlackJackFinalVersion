package com.blackjack.player;

public class HumanPlayer extends Player {
    /**
     * The decision is done by the user input not the decision method
     * @return
     */
    @Override
    public boolean decision() {
        return false;
    }
}
