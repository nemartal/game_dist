package com.dist.game.client.gui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class CreateEnterRoom extends JFrame  {

    private JPanel contentPane;
    private JTextField textField;
    private String nick = "";
    private String codeRoom = "";

    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public CreateEnterRoom(ObjectInputStream ois, ObjectOutputStream oos, String nick) {
        this.ois = ois;
        this.oos = oos;
        setNick(nick);

        setResizable(false);
        setTitle("Preguntados");
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;



        JTextPane textPanel = new JTextPane();
        textPanel.setEditable(false);
        textPanel.setText("¿Desea acceder a una sala o crear una nueva?");
        GridBagConstraints gbc_textPanel = new GridBagConstraints();
        gbc_textPanel.insets = new Insets(0, 0, 5, 4);
        gbc_textPanel.gridx = 1;
        gbc_textPanel.gridy = 0;
        contentPane.add(textPanel, gbc_textPanel);


        JPanel panel1 =  new JPanel();
        panel1.setBorder(null);
        GridBagConstraints gbc_panel1 = new GridBagConstraints();
        gbc_panel1.insets = new Insets(0, 0, 5, 4);
        gbc_panel1.gridx = 1;
        gbc_panel1.gridy = 2;
        contentPane.add(panel1, gbc_panel1);

        JButton btnAccessRoom = new JButton("Acceder a Sala");
        btnAccessRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openGameRoomEnter();
            }
        });
        panel1.add(btnAccessRoom);

        JButton btnCreateRoom = new JButton("Crear Sala");
        btnCreateRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openGameRoomNew();
            }
        });
        panel1.add(btnCreateRoom);

        JButton btnBack = new JButton("Atrás");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openIntroNickInterface();
            }
        });
        btnBack.setVerticalAlignment(SwingConstants.BOTTOM);
        btnBack.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_btnBack = new GridBagConstraints();
        gbc_btnBack.anchor = GridBagConstraints.WEST;
        gbc_btnBack.insets = new Insets(0, 0, 0, 5);
        gbc_btnBack.gridx = 1;
        gbc_btnBack.gridy = 3;
        contentPane.add(btnBack, gbc_btnBack);
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

    //Acceso a la sala IntroNick para volver atrás
    public void openIntroNickInterface() {
        closeInterface();
        //IntroNickCode in = new IntroNickCode();
        //in.introNick(getNick());
        //in.showInterface();
    }

    //Acceso a sala ya existente
    public void openGameRoomEnter() {
        closeInterface();
        //IntroNickCode inc = new IntroNickCode();
        //inc.introCodeRoom(getCodeRoom());
        //inc.showInterface();
    }

    //Acceso a elegir tipo juego
    public void openGameRoomNew() {
        closeInterface();
        GameSelection gs = new GameSelection(ois, oos, getNick());
        gs.showInterface();
    }


}

