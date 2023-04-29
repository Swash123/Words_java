package com.System;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class Window extends JFrame {
    JTextArea areaPane;
    JPanel pnlMsg;
    JLabel lblWords;
    JLabel lblLetters;
    Window(){
        areaPane=new JTextArea();
        pnlMsg=new JPanel();
        lblWords=new JLabel();
        lblLetters=new JLabel();



        lblWords.setText("Total Words: 0");
        lblLetters.setText("Total Letters: 0");

        lblLetters.setPreferredSize(new Dimension(370,90));
        lblWords.setPreferredSize(new Dimension(370,90));

        pnlMsg.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));

        areaPane.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                lblWords.setText("Total Words: "+totWords(areaPane.getText()));
                lblLetters.setText("Total Letters: "+totLetters(areaPane.getText()));

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                lblWords.setText("Total Words: "+totWords(areaPane.getText()));
                lblLetters.setText("Total Letters: "+totLetters(areaPane.getText()));
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                lblWords.setText("Total Words: "+totWords(areaPane.getText()));
                lblLetters.setText("Total Letters: "+totLetters(areaPane.getText()));
            }
        });


        positioning();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(400,600);

    }

    private void positioning(){
        this.setLayout(new GridLayout(2,1,0,30));
        this.add(areaPane);
        this.add(pnlMsg);


        pnlMsg.setLayout(new FlowLayout(FlowLayout.TRAILING,0,20));
        pnlMsg.add(lblWords);
        pnlMsg.add(lblLetters);


    }

    public int totWords(String text){
        String[] words=text.split(" ");
        return words.length;
    }
    public int totLetters(String text){
        int total=0;
        for(char character : text.toCharArray()){
            if(Character.isLetter(character)){
                total++;
            }
        }
        return total;
    }
}
