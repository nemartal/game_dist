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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GameSelection extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private String nick;
    private String codeRoom;


    public GameSelection() {

        setResizable(false);
        setTitle("Preguntados");
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        contentPane.setLayout(gbl_contentPane);

        JTextPane txtpnSeleccioneElJuego = new JTextPane();
        txtpnSeleccioneElJuego.setText("Seleccione el juego al que desea acceder");
        GridBagConstraints gbc_txtpnSeleccioneElJuego = new GridBagConstraints();
        gbc_txtpnSeleccioneElJuego.insets = new Insets(0, 0, 5, 4);
        gbc_txtpnSeleccioneElJuego.gridx = 0;
        gbc_txtpnSeleccioneElJuego.gridy = 0;
        contentPane.add(txtpnSeleccioneElJuego, gbc_txtpnSeleccioneElJuego);

        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 5, 4);
        gbc_panel.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 1;
        contentPane.add(panel, gbc_panel);

        JButton btnNewButton_1 = new JButton("PARTY");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openGameRoomParty();
            }
        });
        panel.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("SPEED");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                openGameRoomSpeed();
            }
        });
        panel.add(btnNewButton_2);

        JButton btnNewButton = new JButton("Atrás");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openCreateEnterRoom();
            }
        });
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.anchor = GridBagConstraints.WEST;
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 2;
        contentPane.add(btnNewButton, gbc_btnNewButton);


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


    //Close interface
    public void showInterface() {
        setVisible(true);

    }

    //Close interface
    public void closeInterface() {
        setVisible(false);
    }

    //Acceso a la sala de juego Party
    public void openGameRoomParty() {
        closeInterface();
        GameRoom gr = new GameRoom();
        gr.gameRoomParty();
        gr.showInterface();

    }

    //Acceso a la sala de juego Speed
    public void openGameRoomSpeed() {
        closeInterface();
        GameRoom gr = new GameRoom();
        gr.gameRoomSpeed();
        gr.showInterface();
    }

    public void openCreateEnterRoom() {
        closeInterface();
        CreateEnterRoom cer = new CreateEnterRoom(getNick());
        cer.showInterface();
    }


}

