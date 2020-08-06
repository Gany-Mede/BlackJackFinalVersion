package com.blackjack.game;

import com.blackjack.player.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertNotSame;

public class GameTest {

    @Test
    public void testThreeAces() {
        Chris chris = new Chris();
        chris.cardsOnHand.add(Deck.Card.ACE_CLUBS);
        chris.cardsOnHand.add(Deck.Card.ACE_DIAMONDS);
        chris.cardsOnHand.add(Deck.Card.ACE_HEARTS);
        Assert.assertEquals(13, chris.countCardValue());//
    }

//    @Test
//    public void testShowFirstCard() {
//        Game game = new Game();
//        Laura laura = new Laura();
//        laura.drawCards(game.hit());
//        Vlad vlad = new Vlad();
//        vlad.drawCards(game.hit());
//        assertNotSame(vlad.cardsOnHand, laura.cardsOnHand);
//    }
}