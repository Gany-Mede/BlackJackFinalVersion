package com.blackjack.game;

import com.blackjack.player.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotSame;

public class GameTest {

    @Test
    public void testThreeAces(){
        Chris chris = new Chris();
        chris.cardsOnHand.add(Deck.Card.ACE_CLUBS);
        chris.cardsOnHand.add(Deck.Card.ACE_DIAMONDS);
        chris.cardsOnHand.add(Deck.Card.ACE_HEARTS);
        Assert.assertEquals(13, chris.countCardValue());//
    }

    @Test
    public void testShowFirstCard(){
        List<Deck.Card> cardsOnHand1 = new ArrayList<>();
        System.out.println(cardsOnHand1);
        List<Deck.Card> cardsOnHand2 = new ArrayList<>();
        System.out.println(cardsOnHand2);
        assertNotSame(cardsOnHand1, cardsOnHand2);
    }

//    @Test
//    public void testBotPlayerDecision() {
//        List<Deck.Card>cardsOnHand = new ArrayList<>();
//        drawCards(cardsOnHand);
//        dealCards();
//
//    }
}