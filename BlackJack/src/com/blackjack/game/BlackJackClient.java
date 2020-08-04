package com.blackjack.game;

import javax.swing.*;

public class BlackJackClient {
    public static void main(String[] args) {

        //UI Swing code
        JFrame frame = new JFrame("BlackjackGUI");
        frame.setContentPane(new BlackjackGUI().gameBoard);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Game blackjack = new Game();
        try{
            blackjack.start();
        }
        catch (InterruptedException e){
            System.out.println(e.toString());
        }
    }
}
