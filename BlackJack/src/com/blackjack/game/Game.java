package com.blackjack.game;

import com.blackjack.player.*;

import java.util.*;

public class Game {
    int timesPlayed = 0;
    int timesWon = 0;
    public static Deck deck;
    List<Player> players;
    HumanPlayer humanPlayer;
    private static final String humanPlayerName;
    static Scanner scanner = new Scanner(System.in);

    static {
        System.out.println("WELCOME TO BLACKJACK");
        System.out.println("BROUGHT TO YOU BY INTERNATIONAL 21");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter your name: ");
        humanPlayerName = scanner.nextLine();
    }

    public void start() throws InterruptedException {
        timesPlayed++;
        deck = new Deck();
        welcomeMessage();
        createPlayers();
        dealCards();
        botNextMove();
        stayOrHit();

    }

    public void welcomeMessage() {
        System.out.println(humanPlayerName + "! You are playing against Chris, Laura, and Vlad");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("The Dealer deals the cards:\n");
    }

    public void createPlayers() {
        Dealer dealer = new Dealer();
        Chris chris = new Chris();
        Laura laura = new Laura();
        Vlad vlad = new Vlad();
        humanPlayer = new HumanPlayer();
        players = Arrays.asList(humanPlayer, chris, laura, vlad, dealer);
    }
    //draw initial two cards per player
    public void dealCards() throws InterruptedException {
        for (Player player : players) {
            player.drawCards(deck.drawCard());
            Thread.sleep(1000);
            player.showFirstCard();
            player.drawCards(deck.drawCard());
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Thread.sleep(1000);
        System.out.println("The Dealer deals each player a second card...");
        System.out.println("Each player now has the second card face down.\n");
        System.out.println("Your cards are: " + humanPlayer.revealCards() + ", with value of: " + humanPlayer.countCardValue());
        Thread.sleep(2000);
    }

    public void stayOrHit() throws InterruptedException {
        boolean toHit;
        do {
            System.out.println("Would you like to STAY or HIT? Type \"s\" to stay and \"h\" to get another card");
            String choice = scanner.nextLine().toLowerCase();
            toHit = "h".equals(choice);
            if (toHit) {
                humanPlayer.drawCards(hit());
                System.out.println("Your cards now are: " + humanPlayer.revealCards() + ", with value of: " + humanPlayer.countCardValue());
                if (humanPlayer.countCardValue() > 21) {
                    revealAll();
                    break;
                }
                if (humanPlayer.countCardValue() == 21) {
                    System.out.println("CONGRATULATIONS! You got 21!");
                    revealAll();
                    break;
                }
            } else {
                revealAll();
            }
        }
        while (toHit);
    }

    public Deck.Card hit() {
        return deck.drawCard();
    }

    public void botNextMove() {
        for (Player player : players) {
            if ("HumanPlayer".equals(player.getClass().getSimpleName())) {
                continue;
            }
            if (player.decision()) {
                player.drawCards(hit());
            }
        }
    }

    public void revealAll() throws InterruptedException {
        System.out.println("\nRevealing each player's cards...");
        for (Player player : players) {
            Thread.sleep(1000);
            if ("HumanPlayer".equals(player.getClass().getSimpleName())) {
                System.out.println("Your cards are: " + humanPlayer.revealCards() + " with a value of: " + humanPlayer.countCardValue());
            } else {
                System.out.println(player.getClass().getSimpleName() + "'s cards are: " + player.revealCards() + ", with value of: " + player.countCardValue());
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        determineWinner();
    }

    public void determineWinner() throws InterruptedException {
        //creating an arraylist in case we have more than one winner (tie)
        List<Player> winner = new ArrayList<>();
        for (Player player : players) {
            if (winner.isEmpty() && player.countCardValue() < 22) {
                winner.add(player);
                continue;
            }

            if (player.countCardValue() < 22 && player.countCardValue() == winner.get(0).countCardValue()) {
                winner.add(player);

            } else if (player.countCardValue() < 22 && player.countCardValue() > winner.get(0).countCardValue()) {
                winner.clear();
                winner.add(player);
            }
        }
        System.out.println("The winner is: ");
        Thread.sleep(1000);
        String winnerDisplay;
        for (Player win : winner) {
            if ("HumanPlayer".equals(win.getClass().getSimpleName())) {
                System.out.println("YOU!!!");
                timesWon++;
            } else {
                System.out.println(win.getClass().getSimpleName() + "!");
            }
        }
        Thread.sleep(1000);
        playAgain();
    }

    public void playAgain() throws InterruptedException {
        System.out.println("Would you like to play again? Type \"y\" for yes, and \"n\" for no");
        String reply = scanner.nextLine().toLowerCase();
        if ("y".equals(reply)) {
            start();
        } else {
            System.out.println("You won " + timesWon + " out of " + timesPlayed);
            scanner.close();
            System.exit(0);
        }
    }
}