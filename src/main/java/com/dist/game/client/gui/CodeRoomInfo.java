package com.dist.game.client.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CodeRoomInfo extends JFrame {

    private JPanel contentPane;
    private String nick;
    private String codeRoom;

    private JTextField textField;

    public CodeRoomInfo(String codeRoom) {

        setResizable(false);
        setTitle("Preguntados");
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("El codigo de la sala es: "+codeRoom);
        lblNewLabel.setBounds(95, 118, 275, 16);
        contentPane.add(lblNewLabel);

    }



    public void showInterface() {
        setVisible(true);

    }

    public void closeInterface() {
        setVisible(false);
    }
}
