package com.blackjack.game;

public class BlackJackClient {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Game blackjack = new Game();
        try {
            blackjack.start();
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }
}