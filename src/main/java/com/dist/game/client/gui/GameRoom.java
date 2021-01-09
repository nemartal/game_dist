package com.dist.game.client.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class GameRoom extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private String nick;
    private String codeRoom;

    public GameRoom() {

        setResizable(false);
        setTitle("Preguntados");
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.rowWeights = new double[] { 1.0, 1.0 };
        gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, 1.0 };
        contentPane.setLayout(gbl_contentPane);


    }

    public void gameRoomParty() {
        JPanel panel_2 = new JPanel();
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.anchor = GridBagConstraints.NORTHWEST;
        gbc_panel_2.insets = new Insets(0, 0, 5, 5);
        gbc_panel_2.gridx = 0;
        gbc_panel_2.gridy = 0;
        contentPane.add(panel_2, gbc_panel_2);

        JTextPane txtPlayer1 = new JTextPane();
        txtPlayer1.setEditable(false);
        txtPlayer1.setText("Jugador 1");
        panel_2.add(txtPlayer1);

        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 5, 5);
        gbc_panel.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel.gridx = 1;
        gbc_panel.gridy = 0;
        contentPane.add(panel, gbc_panel);

        JTextPane txtpnPregunta = new JTextPane();
        txtpnPregunta.setText("Pregunta");
        panel.add(txtpnPregunta);

        JPanel panel_3 = new JPanel();
        GridBagConstraints gbc_panel_3 = new GridBagConstraints();
        gbc_panel_3.anchor = GridBagConstraints.NORTHEAST;
        gbc_panel_3.insets = new Insets(0, 0, 5, 0);
        gbc_panel_3.gridx = 2;
        gbc_panel_3.gridy = 0;
        contentPane.add(panel_3, gbc_panel_3);

        JTextPane txtPlayer2 = new JTextPane();
        txtPlayer2.setEditable(false);
        txtPlayer2.setText("Jugador 2");
        panel_3.add(txtPlayer2);

        JPanel panel_4 = new JPanel();
        GridBagConstraints gbc_panel_4 = new GridBagConstraints();
        gbc_panel_4.anchor = GridBagConstraints.SOUTHWEST;
        gbc_panel_4.insets = new Insets(0, 0, 0, 5);
        gbc_panel_4.gridx = 0;
        gbc_panel_4.gridy = 1;
        contentPane.add(panel_4, gbc_panel_4);

        JTextPane txtPlayer3 = new JTextPane();
        txtPlayer3.setEditable(false);
        txtPlayer3.setText("Jugador 3");
        panel_4.add(txtPlayer3);

        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.insets = new Insets(0, 0, 0, 5);
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridx = 1;
        gbc_panel_1.gridy = 1;
        contentPane.add(panel_1, gbc_panel_1);
        panel_1.setLayout(new GridLayout(2, 2, 0, 0));

        JButton btnAnswer1 = new JButton("Respuesta 1");
        panel_1.add(btnAnswer1);

        JButton btnAnswer2 = new JButton("Respuesta 2");
        panel_1.add(btnAnswer2);

        JButton btnAnswer3 = new JButton("Respuesta 3");
        panel_1.add(btnAnswer3);

        JButton btnAnswer4 = new JButton("Respuesta 4");
        panel_1.add(btnAnswer4);

        JPanel panel_5 = new JPanel();
        GridBagConstraints gbc_panel_5 = new GridBagConstraints();
        gbc_panel_5.anchor = GridBagConstraints.SOUTHEAST;
        gbc_panel_5.gridx = 2;
        gbc_panel_5.gridy = 1;
        contentPane.add(panel_5, gbc_panel_5);

        JTextPane txtPlayer4 = new JTextPane();
        txtPlayer4.setEditable(false);
        txtPlayer4.setText("Jugador 4");
        panel_5.add(txtPlayer4);

    }

    public void gameRoomSpeed() {
        JPanel panel_2 = new JPanel();
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.anchor = GridBagConstraints.NORTHWEST;
        gbc_panel_2.insets = new Insets(0, 0, 5, 5);
        gbc_panel_2.gridx = 0;
        gbc_panel_2.gridy = 0;
        contentPane.add(panel_2, gbc_panel_2);

        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 5, 5);
        gbc_panel.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel.gridx = 1;
        gbc_panel.gridy = 0;
        contentPane.add(panel, gbc_panel);

        JTextPane txtpnPregunta = new JTextPane();
        txtpnPregunta.setText("Pregunta");
        panel.add(txtpnPregunta);

        JPanel panel_3 = new JPanel();
        GridBagConstraints gbc_panel_3 = new GridBagConstraints();
        gbc_panel_3.anchor = GridBagConstraints.NORTHEAST;
        gbc_panel_3.insets = new Insets(0, 0, 5, 0);
        gbc_panel_3.gridx = 2;
        gbc_panel_3.gridy = 0;
        contentPane.add(panel_3, gbc_panel_3);


        JPanel panel_4 = new JPanel();
        GridBagConstraints gbc_panel_4 = new GridBagConstraints();
        gbc_panel_4.anchor = GridBagConstraints.SOUTHWEST;
        gbc_panel_4.insets = new Insets(0, 0, 0, 5);
        gbc_panel_4.gridx = 0;
        gbc_panel_4.gridy = 1;
        contentPane.add(panel_4, gbc_panel_4);

        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.insets = new Insets(0, 0, 0, 5);
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridx = 1;
        gbc_panel_1.gridy = 1;
        contentPane.add(panel_1, gbc_panel_1);
        panel_1.setLayout(new GridLayout(2, 2, 0, 0));

        JButton btnAnswer1 = new JButton("Respuesta 1");
        panel_1.add(btnAnswer1);

        JButton btnAnswer2 = new JButton("Respuesta 2");
        panel_1.add(btnAnswer2);

        JButton btnAnswer3 = new JButton("Respuesta 3");
        panel_1.add(btnAnswer3);

        JButton btnAnswer4 = new JButton("Respuesta 4");
        panel_1.add(btnAnswer4);

        JPanel panel_5 = new JPanel();
        GridBagConstraints gbc_panel_5 = new GridBagConstraints();
        gbc_panel_5.anchor = GridBagConstraints.SOUTHEAST;
        gbc_panel_5.gridx = 2;
        gbc_panel_5.gridy = 1;
        contentPane.add(panel_5, gbc_panel_5);

    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getCodeRoom() {
        return codeRoom;
    }

    public void setCodeRoom(String codeRoom) {
        this.codeRoom = codeRoom;
    }

    public void showInterface() {
        setVisible(true);

    }

    public void closeInterface() {
        setVisible(false);
    }
}

