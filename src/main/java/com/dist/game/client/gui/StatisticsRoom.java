package com.dist.game.client.gui;


import com.dist.game.share.model.Stats;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class StatisticsRoom extends JFrame {

    private JPanel contentPane;
    private String nick;
    private String codeRoom;

    private JTextField textField;

    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    private Map<String, Stats> stats;
    private Map<String,String> player ;

    public StatisticsRoom(ObjectInputStream ois, ObjectOutputStream oos) {

        this.ois = ois;
        this.oos = oos;

        showStats();

        setResizable(false);
        setTitle("Preguntados");
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        JPanel statsPlayer1 = new JPanel();
        statsPlayer1.setBorder(new LineBorder(new Color(0, 0, 0)));
        GridBagConstraints gbc_statsPlayer1 = new GridBagConstraints();
        gbc_statsPlayer1.insets = new Insets(0, 0, 5, 5);
        gbc_statsPlayer1.fill = GridBagConstraints.BOTH;
        gbc_statsPlayer1.gridx = 0;
        gbc_statsPlayer1.gridy = 0;
        contentPane.add(statsPlayer1, gbc_statsPlayer1);
        GridBagLayout gbl_statsPlayer1 = new GridBagLayout();
        gbl_statsPlayer1.columnWidths = new int[]{0, 0, 0, 0, 0};
        gbl_statsPlayer1.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_statsPlayer1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_statsPlayer1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        statsPlayer1.setLayout(gbl_statsPlayer1);


        JLabel lblNewLabel = new JLabel("  "+);
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        statsPlayer1.add(lblNewLabel, gbc_lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("  Respuestas correctas: ");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 1;
        statsPlayer1.add(lblNewLabel_1, gbc_lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("  Respuestas Incorrectas: ");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 2;
        statsPlayer1.add(lblNewLabel_2, gbc_lblNewLabel_2);

        JLabel lblNewLabel_12 = new JLabel("  Tiempo transcurrido: ");
        GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
        gbc_lblNewLabel_12.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_12.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_12.gridx = 0;
        gbc_lblNewLabel_12.gridy = 3;
        statsPlayer1.add(lblNewLabel_12, gbc_lblNewLabel_12);

        JPanel statsPlayer2 = new JPanel();
        statsPlayer2.setBorder(new LineBorder(new Color(0, 0, 0)));
        GridBagConstraints gbc_statsPlayer2 = new GridBagConstraints();
        gbc_statsPlayer2.insets = new Insets(0, 0, 5, 0);
        gbc_statsPlayer2.fill = GridBagConstraints.BOTH;
        gbc_statsPlayer2.gridx = 1;
        gbc_statsPlayer2.gridy = 0;
        contentPane.add(statsPlayer2, gbc_statsPlayer2);
        GridBagLayout gbl_statsPlayer2 = new GridBagLayout();
        gbl_statsPlayer2.columnWidths = new int[]{0, 0};
        gbl_statsPlayer2.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_statsPlayer2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_statsPlayer2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        statsPlayer2.setLayout(gbl_statsPlayer2);

        JLabel lblNewLabel_3 = new JLabel("  Jugador2");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 0;
        statsPlayer2.add(lblNewLabel_3, gbc_lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("  Respuestas correctas: ");
        GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
        gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_4.gridx = 0;
        gbc_lblNewLabel_4.gridy = 1;
        statsPlayer2.add(lblNewLabel_4, gbc_lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("  Respuestas Incorrectas: ");
        GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
        gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_5.gridx = 0;
        gbc_lblNewLabel_5.gridy = 2;
        statsPlayer2.add(lblNewLabel_5, gbc_lblNewLabel_5);

        JLabel lblNewLabel_14 = new JLabel("  Tiempo transcurrido: ");
        GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
        gbc_lblNewLabel_14.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_14.gridx = 0;
        gbc_lblNewLabel_14.gridy = 3;
        statsPlayer2.add(lblNewLabel_14, gbc_lblNewLabel_14);

        JPanel statsPlayer3 = new JPanel();
        statsPlayer3.setBorder(new LineBorder(new Color(0, 0, 0)));
        GridBagConstraints gbc_statsPlayer3 = new GridBagConstraints();
        gbc_statsPlayer3.insets = new Insets(0, 0, 0, 5);
        gbc_statsPlayer3.fill = GridBagConstraints.BOTH;
        gbc_statsPlayer3.gridx = 0;
        gbc_statsPlayer3.gridy = 1;
        contentPane.add(statsPlayer3, gbc_statsPlayer3);
        GridBagLayout gbl_statsPlayer3 = new GridBagLayout();
        gbl_statsPlayer3.columnWidths = new int[]{0, 0};
        gbl_statsPlayer3.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_statsPlayer3.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_statsPlayer3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        statsPlayer3.setLayout(gbl_statsPlayer3);

        JLabel lblNewLabel_9 = new JLabel("  Jugador3");
        GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
        gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_9.gridx = 0;
        gbc_lblNewLabel_9.gridy = 0;
        statsPlayer3.add(lblNewLabel_9, gbc_lblNewLabel_9);

        JLabel lblNewLabel_10 = new JLabel("  Respuestas correctas: ");
        GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
        gbc_lblNewLabel_10.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_10.gridx = 0;
        gbc_lblNewLabel_10.gridy = 1;
        statsPlayer3.add(lblNewLabel_10, gbc_lblNewLabel_10);

        JLabel lblNewLabel_11 = new JLabel("  Respuestas Incorrectas: ");
        GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
        gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_11.gridx = 0;
        gbc_lblNewLabel_11.gridy = 2;
        statsPlayer3.add(lblNewLabel_11, gbc_lblNewLabel_11);

        JLabel lblNewLabel_13 = new JLabel("  Tiempo transcurrido: ");
        GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
        gbc_lblNewLabel_13.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_13.gridx = 0;
        gbc_lblNewLabel_13.gridy = 3;
        statsPlayer3.add(lblNewLabel_13, gbc_lblNewLabel_13);

        JPanel statsPlayer4 = new JPanel();
        statsPlayer4.setBorder(new LineBorder(new Color(0, 0, 0)));
        GridBagConstraints gbc_statsPlayer4 = new GridBagConstraints();
        gbc_statsPlayer4.fill = GridBagConstraints.BOTH;
        gbc_statsPlayer4.gridx = 1;
        gbc_statsPlayer4.gridy = 1;
        contentPane.add(statsPlayer4, gbc_statsPlayer4);
        GridBagLayout gbl_statsPlayer4 = new GridBagLayout();
        gbl_statsPlayer4.columnWidths = new int[]{0, 0};
        gbl_statsPlayer4.rowHeights = new int[]{0, 0, 0, 0, 0};
        gbl_statsPlayer4.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_statsPlayer4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        statsPlayer4.setLayout(gbl_statsPlayer4);

        JLabel lblNewLabel_6 = new JLabel("  Jugador4");
        GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
        gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_6.gridx = 0;
        gbc_lblNewLabel_6.gridy = 0;
        statsPlayer4.add(lblNewLabel_6, gbc_lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("  Respuestas correctas: ");
        GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
        gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_7.gridx = 0;
        gbc_lblNewLabel_7.gridy = 1;
        statsPlayer4.add(lblNewLabel_7, gbc_lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("  Respuestas Incorrectas: ");
        GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
        gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_8.gridx = 0;
        gbc_lblNewLabel_8.gridy = 2;
        statsPlayer4.add(lblNewLabel_8, gbc_lblNewLabel_8);

        JLabel lblNewLabel_15 = new JLabel("  Tiempo transcurrido: ");
        GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
        gbc_lblNewLabel_15.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel_15.gridx = 0;
        gbc_lblNewLabel_15.gridy = 3;
        statsPlayer4.add(lblNewLabel_15, gbc_lblNewLabel_15);

    }



    public void showInterface() {
        setVisible(true);

    }

    public void closeInterface() {
        setVisible(false);
    }

    private void showStats(){
        try {
            //<Id, Stats>
            Map<String, Stats> stats = (Map<String, Stats>) this.ois.readObject();
            // <Id,nick>
            Map<String,String> player = (Map<String, String>) this.ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

