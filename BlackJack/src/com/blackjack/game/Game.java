package com.blackjack.game;

import com.blackjack.player.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    Deck deck = new Deck();
    Scanner scanner = new Scanner(System.in);
    public static String humanPlayerName;
    List<Player> players;

    public void start(){
        welcomeMessage();
        createPlayers();
        dealCards();
    }
    public void dealCards(){
        for (Player player : players){
            player.setFirstCard(deck.drawCard());
            player.setSecondCard(deck.drawCard());
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("The Dealer deals second cards");
        System.out.println("Each player now has the second card face down");
    }
    public void welcomeMessage(){
        System.out.println("WELCOME TO BLACKJACK");
        System.out.println("BROUGHT TO YOU BY INTERNATIONAL 21");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter your name: ");
        humanPlayerName = scanner.nextLine();
        System.out.println(humanPlayerName + "! You are playing against Chris, Laura, and Vlad");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("The Dealer deals the cards:");
    }
    public void createPlayers(){
        Dealer dealer = new Dealer();
        Chris chris = new Chris();
        Laura laura = new Laura();
        Vlad vlad = new Vlad();
        HumanPlayer humanPlayer = new HumanPlayer();

        players = Arrays.asList(humanPlayer,chris, laura, vlad,dealer);

    }

}

