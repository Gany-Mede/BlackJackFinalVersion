package com.blackjack.game;

import com.blackjack.player.*;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void testThreeAces() {
        Chris chris = new Chris();
        chris.cardsOnHand.add(Deck.Card.ACE_CLUBS);
        chris.cardsOnHand.add(Deck.Card.ACE_DIAMONDS);
        chris.cardsOnHand.add(Deck.Card.ACE_HEARTS);
        Assert.assertEquals(13, chris.countCardValue());//
    }

}