package com.blackjack.game;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DeckTest extends TestCase {



    private List<Deck.Card> deck;

    @Test
    public void testDeck() {
        deck = new LinkedList<>(Arrays.asList(Deck.Card.values()));
        System.out.println(deck);
        Collections.shuffle(deck);
        System.out.println(deck);
    }
    @Test
    public void testDrawCard() {
        deck = new LinkedList<>(Arrays.asList(Deck.Card.values()));
        System.out.println(deck);
        deck.remove(0);
        assertEquals(51, deck.size());
        System.out.println(deck);
        deck.remove(0);
        assertEquals(50, deck.size());
        System.out.println(deck);
    }


}