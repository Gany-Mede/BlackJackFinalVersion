package com.blackjack.game;

import com.blackjack.player.*;
import org.junit.Before;
import org.junit.Test;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.blackjack.game.Game.deck;
import static org.junit.Assert.assertNotSame;

public class GameTest {
    private int currentHandValue;
    List<Player> players;

    @Test
    public void testShowFirstCard(){
        List<Deck.Card> cardsOnHand1 = new ArrayList<>();
        System.out.println(cardsOnHand1);
        List<Deck.Card> cardsOnHand2 = new ArrayList<>();
        System.out.println(cardsOnHand2);
        assertNotSame(cardsOnHand1, cardsOnHand2);
    }

//    @Before
//    public void drawCards(Deck.Card card) {
//        Dealer dealer = new Dealer();
//        Chris chris = new Chris();
//        Laura laura = new Laura();
//        Vlad vlad = new Vlad();
//        HumanPlayer humanPlayer = new HumanPlayer();
//        players = Arrays.asList(humanPlayer, chris, laura, vlad, dealer);
//        List<Deck.Card> cardsOnHand = new ArrayList<>();
//        cardsOnHand.add(card);
//
//        public void dealCards() throws InterruptedException {
//            {
//                for (Player player : players) {
//                    player.drawCards(deck.drawCard());
//                    Thread.sleep(1000);
//                    player.showFirstCard();
//                    player.drawCards(deck.drawCard());
//                }
//                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//                Thread.sleep(1000);
//                System.out.println("The Dealer deals each player a second card...");
//                System.out.println("Each player now has the second card face down.\n");
//                System.out.println("Your cards are: " + humanPlayer.revealCards() + ", with value of: " + humanPlayer.countCardValue());
//                Thread.sleep(2000);
//            }
//        }
//    }

    @Test
    public void testBotPlayerDecision() {
        List<Deck.Card>cardsOnHand = new ArrayList<>();
        drawCards(cardsOnHand);
        dealCards();

    }









}
