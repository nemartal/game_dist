package com.dist.game.client.gui;

import com.dist.game.share.model.Question;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameRoom extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private String nick;
    private String codeRoom;


    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    private JButton btnAnswer1;
    private JButton btnAnswer2;
    private JButton btnAnswer3;
    private JButton btnAnswer4;
    private JLabel txtpnPregunta;

    private Question question;

    private int answered;

    public GameRoom(ObjectInputStream ois, ObjectOutputStream oos, String nick) {
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
        gbl_contentPane.rowWeights = new double[]{1.0, 1.0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0};
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

        JLabel txtPlayer1 = new JLabel();
        txtPlayer1.setText("Jugador 1");
        panel_2.add(txtPlayer1);

        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 5, 5);
        gbc_panel.fill = GridBagConstraints.HORIZONTAL;
        gbc_panel.gridx = 1;
        gbc_panel.gridy = 0;
        contentPane.add(panel, gbc_panel);

        JLabel txtpnPregunta = new JLabel();
        txtpnPregunta.setText("Pregunta");
        panel.add(txtpnPregunta);

        JPanel panel_3 = new JPanel();
        GridBagConstraints gbc_panel_3 = new GridBagConstraints();
        gbc_panel_3.anchor = GridBagConstraints.NORTHEAST;
        gbc_panel_3.insets = new Insets(0, 0, 5, 0);
        gbc_panel_3.gridx = 2;
        gbc_panel_3.gridy = 0;
        contentPane.add(panel_3, gbc_panel_3);

        JLabel txtPlayer2 = new JLabel();
        txtPlayer2.setText("Jugador 2");
        panel_3.add(txtPlayer2);

        JPanel panel_4 = new JPanel();
        GridBagConstraints gbc_panel_4 = new GridBagConstraints();
        gbc_panel_4.anchor = GridBagConstraints.SOUTHWEST;
        gbc_panel_4.insets = new Insets(0, 0, 0, 5);
        gbc_panel_4.gridx = 0;
        gbc_panel_4.gridy = 1;
        contentPane.add(panel_4, gbc_panel_4);

        JLabel txtPlayer3 = new JLabel();
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

        JLabel txtPlayer4 = new JLabel();
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

        txtpnPregunta = new JLabel();
        txtpnPregunta.setText("");
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

        btnAnswer1 = new JButton("");
        panel_1.add(btnAnswer1);

        btnAnswer2 = new JButton("");
        panel_1.add(btnAnswer2);

        btnAnswer3 = new JButton("");
        panel_1.add(btnAnswer3);

        btnAnswer4 = new JButton("");
        panel_1.add(btnAnswer4);

        JPanel panel_5 = new JPanel();
        GridBagConstraints gbc_panel_5 = new GridBagConstraints();
        gbc_panel_5.anchor = GridBagConstraints.SOUTHEAST;
        gbc_panel_5.gridx = 2;
        gbc_panel_5.gridy = 1;
        contentPane.add(panel_5, gbc_panel_5);

        btnAnswer1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendAnswer(0);
            }
        });
        btnAnswer2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendAnswer(1);
            }
        });
        btnAnswer3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendAnswer(2);
            }
        });
        btnAnswer4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendAnswer(3);
            }
        });
        nextQuestion();
    }

    private void nextQuestion(){
        // GET Question
        try {
            question = (Question) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.txtpnPregunta.setText(question.getText());
        this.btnAnswer1.setText(question.getAnswers().get(0).getText());
        this.btnAnswer2.setText(question.getAnswers().get(1).getText());
        this.btnAnswer3.setText(question.getAnswers().get(2).getText());
        this.btnAnswer4.setText(question.getAnswers().get(3).getText());

    }
    private void sendAnswer(int i) {
        try {
            answered++;
            this.oos.writeObject(question.getAnswers().get(i));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(answered < 20) {
            this.nextQuestion();
        }else{
            closeInterface();
            StatisticsRoom stats = new StatisticsRoom(ois, oos);
            stats.showInterface();

        }
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

