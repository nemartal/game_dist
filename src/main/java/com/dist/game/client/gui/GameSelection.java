package com.dist.game.client.gui;

import com.dist.game.share.model.GameAction;
import com.dist.game.share.model.GameType;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class GameSelection extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private String nick;
    private String codeRoom;

    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public GameSelection(ObjectInputStream ois, ObjectOutputStream oos, String nick) {
        this.ois = ois;
        this.oos = oos;

        this.nick = nick;

        setResizable(false);
        setTitle("Preguntados");
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        contentPane.setLayout(gbl_contentPane);

        JLabel txtpnSeleccioneElJuego = new JLabel();
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
        try {
            oos.writeObject(GameAction.CREATE);
            oos.writeObject(GameType.PARTY);
            String roomId = (String) ois.readObject();
            System.out.println(roomId);
            GameType type = (GameType) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        GameRoom gr = new GameRoom(ois, oos, nick);
        gr.gameRoomParty();
        gr.showInterface();

    }

    //Acceso a la sala de juego Speed
    public void openGameRoomSpeed() {
        closeInterface();
        CodeRoomInfo codeRoomInfo;
        try {
            oos.writeObject(GameAction.CREATE);
            oos.writeObject(GameType.SPEED);
            String roomId = (String) ois.readObject();
            System.out.println(roomId);
            GameType type = (GameType) ois.readObject();
            codeRoomInfo = new CodeRoomInfo(roomId);
            codeRoomInfo.showInterface();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        GameRoom gr = new GameRoom(ois, oos, nick);
        gr.gameRoomSpeed();
        gr.showInterface();
    }

    public void openCreateEnterRoom() {
        closeInterface();
        CreateEnterRoom cer = new CreateEnterRoom(ois, oos, nick);
        cer.showInterface();
    }


}

