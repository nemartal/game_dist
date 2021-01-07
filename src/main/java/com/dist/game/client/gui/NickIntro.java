package com.dist.game.client.gui;

import javafx.scene.control.Labeled;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NickIntro {
    private JPanel rootPanel;
    private JTextArea textArea;
    private JButton accessButton;
    private JTextField textField1;
    private JPanel panel1;

    /*public NickIntro() {
        $$$setupUI$$$();
    }

    private void createUIComponents() {
        textArea = new JTextArea();
        textArea.setText("Introduce Nick");
    }

    private void $$$setupUI$$$() {
        createUIComponents();
    }*/

    public static void main(String[] args) {
        JFrame frame = new JFrame("Preguntados");
        frame.setContentPane(new NickIntro().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
