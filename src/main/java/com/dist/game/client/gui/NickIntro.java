package com.dist.game.client.gui;

import javafx.scene.control.Labeled;

import javax.swing.*;
import java.awt.*;

public class NickIntro {
    private JPanel rootPanel;
    private JTextArea textArea;
    private JButton accessButton;
    private JTextField textField1;

    private void createUIComponents() {
        // TODO: place custom component creation code here

        // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = rootPanel.getSize().width;
        int h = rootPanel.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        rootPanel.setLocation(x, y);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("NickIntro");
        frame.setContentPane(new NickIntro().rootPanel);
        new NickIntro().createUIComponents();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
