package com.blackjack.player;

import java.util.Random;

public class Chris extends Player {
    /**
     * Chris Bot is going to stay randomly between 15 and 18
     * @return
     */
    @Override
    public boolean decision() {
        int toStay;
        Random random = new Random();
        toStay = random.nextInt(18 - 15) + 15;
        return getCurrentHandValue() < toStay;
    }
}