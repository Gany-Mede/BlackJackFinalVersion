package com.blackjack.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackjackGUI {
    private JButton HITButton;
    public JPanel gameBoard;
    private JButton STAYButton;

    public BlackjackGUI() {
        STAYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "No more cards");
            }
        });
    }
}
