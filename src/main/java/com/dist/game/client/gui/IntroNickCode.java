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

public class IntroNickCode extends JFrame {

    private JPanel contentPane;
    private String nick;
    private String codeRoom;

    private JTextField textField;

    public IntroNickCode() {

        setResizable(false);
        setTitle("Preguntados");
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.rowHeights = new int[]{0, 0, 110, 0};
        gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0 };
        gbl_contentPane.columnWeights = new double[] { 1.0 };
        contentPane.setLayout(gbl_contentPane);

    }


    // Si queremos guardar el nick
    public void introNick(String nick) {

        JTextPane txtpnPorFavorItroduzca = new JTextPane();
        txtpnPorFavorItroduzca.setText("Por favor itroduzca un nick para poder comenzar el juego");
        GridBagConstraints gbc_txtpnPorFavorItroduzca = new GridBagConstraints();
        gbc_txtpnPorFavorItroduzca.insets = new Insets(0, 0, 5, 4);
        gbc_txtpnPorFavorItroduzca.gridx = 0;
        gbc_txtpnPorFavorItroduzca.gridy = 1;
        contentPane.add(txtpnPorFavorItroduzca, gbc_txtpnPorFavorItroduzca);

        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.anchor = GridBagConstraints.NORTH;
        gbc_panel.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 2;
        contentPane.add(panel, gbc_panel);

        textField = new JTextField();
        panel.add(textField);
        //Si el nick tiene información se introduce en el cuadro de texto
        if(!nick.isEmpty()) {
            textField.setText(nick);
        }
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Acceder");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openCreateEnterRoom();
            }
        });
        panel.add(btnNewButton);
        captureNickInfo();

    }

    // Si queremos guardar el codigo de sala
    public void introCodeRoom(String codeRoom) {
        this.codeRoom = codeRoom;

        JTextPane txtpnPorFavorItroduzca = new JTextPane();
        txtpnPorFavorItroduzca.setText("Por favor itroduzca un codigo para poder comenzar el juego");
        GridBagConstraints gbc_txtpnPorFavorItroduzca = new GridBagConstraints();
        gbc_txtpnPorFavorItroduzca.insets = new Insets(0, 0, 5, 4);
        gbc_txtpnPorFavorItroduzca.gridx = 0;
        gbc_txtpnPorFavorItroduzca.gridy = 1;
        contentPane.add(txtpnPorFavorItroduzca, gbc_txtpnPorFavorItroduzca);

        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 5, 0);
        gbc_panel.anchor = GridBagConstraints.NORTH;
        gbc_panel.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 2;
        contentPane.add(panel, gbc_panel);

        textField = new JTextField();
        panel.add(textField);
        if(!codeRoom.isEmpty()) {
            textField.setText(codeRoom);
        }
        textField.setColumns(10);

        JButton btnNewButton = new JButton("Acceder");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openGameRoom();
            }
        });
        panel.add(btnNewButton);

        JButton btnBack = new JButton("Atrás");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openCreateEnterRoom();
            }
        });
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
        gbc_btnNewButton_1.gridx = 0;
        gbc_btnNewButton_1.gridy = 3;
        contentPane.add(btnBack, gbc_btnNewButton_1);
        captureCodeInfo();


    }

    public String getNick() {
        return this.nick;
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

    public void captureNickInfo() {
        setNick(textField.getText());
    }

    public void captureCodeInfo() {
        setCodeRoom(textField.getText());
    }

    public void openGameRoom() {
        closeInterface();
        GameRoom gs = new GameRoom();
        gs.showInterface();
    }

    public void openCreateEnterRoom() {
        closeInterface();
        CreateEnterRoom cer = new CreateEnterRoom(getNick());
        cer.showInterface();
    }

}
