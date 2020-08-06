package com.blackjack.game;

import com.blackjack.player.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Game {
    private int timesPlayed = 0;
    private int timesWon = 0;
    private Deck deck;
    private List<Player> players;
    private HumanPlayer humanPlayer;
    private static final String humanPlayerName;
    private static Scanner scanner = new Scanner(System.in);

    static {
        try {
            printBanner();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("~BROUGHT TO YOU BY INTERNATIONAL 21~");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" Here are the rules: \n The goal is to be the player that gets exactly 21" +
                "\n or as close to 21 as possible without going over. \n Each card is worth its face value." +
                "\n Jack, Queen, and King are worth 10 points. \n Aces can be worth either 1 or 11 points (whichever is more favorable)");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter your name: ");
        humanPlayerName = scanner.nextLine();
    }

    /** Starts the game by calling other methods
     * @throws InterruptedException
     */
    protected void start() throws InterruptedException {
        timesPlayed++;
        deck = new Deck();
        welcomeMessage();
        createPlayers();
        dealCards();
        botNextMove();
        stayOrHit();
    }

    /**
     * @throws IOException
     */
    private static void printBanner() throws IOException {
        File welcomeBanner = new File("images/welcome.txt");
        Scanner welcomeScanner = new Scanner(welcomeBanner);
        while (welcomeScanner.hasNextLine()) {
            System.out.println(welcomeScanner.nextLine());
        }
    }

    private void welcomeMessage() {
        System.out.println(humanPlayerName + "! You are playing against Chris, Laura, and Vlad");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("The Dealer deals the cards:\n");
    }

    private void createPlayers() {
        Dealer dealer = new Dealer();
        Chris chris = new Chris();
        Laura laura = new Laura();
        Vlad vlad = new Vlad();
        humanPlayer = new HumanPlayer();
        players = Arrays.asList(humanPlayer, chris, laura, vlad, dealer);
    }

    /**
     * @throws InterruptedException
     */
    //draw initial two cards per player
    private void dealCards() throws InterruptedException {
        for (Player player : players) {
            player.drawCards(deck.drawCard());
            Thread.sleep(1000);
            player.showFirstCard();
            player.drawCards(deck.drawCard());
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Thread.sleep(1000);
        System.out.println("The Dealer deals each player a second card...");
        Thread.sleep(1000);
        System.out.println("Each player now has the second card face down.\n");
        System.out.println("Your cards are: " + humanPlayer.revealCards() + ", with value of: " + humanPlayer.countCardValue());
        Thread.sleep(2000);
    }

    /**
     * @throws InterruptedException
     */
    private void stayOrHit() throws InterruptedException {
        boolean toHit;
        do {
            System.out.println("Would you like to STAY or HIT? Type \"s\" to stay or \"h\" to get another card");
            String choice = evaluateHitOrStayInput(scanner.nextLine().toLowerCase());
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

    /**
     * @return returns a card from the deck
     */
    private Deck.Card hit() {
        return deck.drawCard();
    }
    /**
     * @param choice To stay or hit prompt
     * @return an output based on what the user chose
     */
    private String evaluateHitOrStayInput(String choice) {
        String toReturn = null;
        boolean wrongInput;
        if (choice.equals("s") || choice.equals("h")) {
            return choice;
        } else {
            wrongInput = true;
        }
        while (wrongInput) {
            System.out.println("Please enter valid input, Type \"s\" to STAY or \"h\" to HIT");
            toReturn = scanner.nextLine().toLowerCase();
            if (toReturn.equals("s") || toReturn.equals("h")) {
                wrongInput = false;
            }
        }
        return toReturn;
    }

    private void botNextMove() {
        for (Player player : players) {
            if ("HumanPlayer".equals(player.getClass().getSimpleName())) {
                continue;
            }
            while (player.decision()) {
                player.drawCards(hit());
                player.setCurrentHandValue(player.countCardValue());
            }
        }
    }
    /**
     * @throws InterruptedException
     */
    private void revealAll() throws InterruptedException {
        System.out.println("\nRevealing each player's cards...");
        for (Player player : players) {
            Thread.sleep(1000);
            if ("HumanPlayer".equals(player.getClass().getSimpleName())) {
                System.out.print("\nYour cards are: " + humanPlayer.revealCards() + " with a value of: " + humanPlayer.countCardValue());
                isOver21(humanPlayer.countCardValue());
            } else {
                System.out.print("\n" + player.getClass().getSimpleName() + "'s cards are: " + player.revealCards() + ", with value of: " +
                        player.countCardValue());
                isOver21(player.countCardValue());
            }
        }
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        determineWinner();
    }
    /**
     *
     * @param score prints BUST if a player gets over 21
     */
    private void isOver21(int score) {
        String toReturn = score > 21 ? "!BUST!" : "";
        System.out.print(" " + toReturn);
    }
    /**
     * Determine the winner
     * @throws InterruptedException
     */
    private void determineWinner() throws InterruptedException {
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
    /**
     * Prompt user to play again
     * @throws InterruptedException
     */
    private void playAgain() throws InterruptedException {
        System.out.println("\nWould you like to play again? Type \"y\" for yes, and \"n\" for no");
        String reply = evaluatePlayAgainInput(scanner.nextLine().toLowerCase());
        if ("y".equals(reply)) {
            start();
        } else {
            System.out.println("You won " + timesWon + " out of " + timesPlayed);
            scanner.close();
            System.exit(0);
        }
    }
    /**
     *
     * @param input
     * @return Input validation to play again or not
     */
    private String evaluatePlayAgainInput(String input) {
        String toReturn = null;
        boolean wrongInput;
        if (input.equals("y") || input.equals("n")) {
            return input;
        } else {
            wrongInput = true;
        }
        while (wrongInput) {
            System.out.println("Please enter valid input, Type \"y\" for to PLAY again, and \"n\" to QUIT");
            toReturn = scanner.nextLine().toLowerCase();
            if (toReturn.equals("y") || toReturn.equals("n")) {
                wrongInput = false;
            }
        }
        return toReturn;
    }
}