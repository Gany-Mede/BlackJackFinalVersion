package com.blackjack.player;

import com.blackjack.game.Deck;

import java.util.Random;

public class Chris extends Player {
    @Override
//Chris Bot is going to stay randomly between 15 and 18
    public boolean decision() {
        int toStay;
        Random random = new Random();
        toStay = random.nextInt(18 - 15) + 15;
        return getCurrentHandValue() < toStay;
    }
}
