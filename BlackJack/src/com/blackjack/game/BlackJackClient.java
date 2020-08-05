package com.blackjack.game;

public class BlackJackClient {
    public static void main(String[] args) {
        Game blackjack = new Game();

        try {
            blackjack.start();
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }
}