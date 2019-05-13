package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.String;
import java.text.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.text.ParseException;


public class GameLayout extends MenuLayout {




    public static Container gameIsSelf() {




        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("#");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatter.setValidCharacters("0123456789");

        //paczka 11

        JFormattedTextField field11 = new JFormattedTextField(formatter);
        field11.setPreferredSize(new Dimension(20,20));
        JFormattedTextField field12 = new JFormattedTextField(formatter);
        JFormattedTextField field13 = new JFormattedTextField(formatter);
        JFormattedTextField field21 = new JFormattedTextField(formatter);
        JFormattedTextField field22 = new JFormattedTextField(formatter);
        JFormattedTextField field23 = new JFormattedTextField(formatter);
        JFormattedTextField field31 = new JFormattedTextField(formatter);
        JFormattedTextField field32 = new JFormattedTextField(formatter);
        JFormattedTextField field33 = new JFormattedTextField(formatter);

        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setSize(100,100);
        buttonPanel1.setLayout(new GridLayout(3,3));
        buttonPanel1.add(field11);
        buttonPanel1.add(field12);
        buttonPanel1.add(field13);
        buttonPanel1.add(field21);
        buttonPanel1.add(field22);
        buttonPanel1.add(field23);
        buttonPanel1.add(field31);
        buttonPanel1.add(field32);
        buttonPanel1.add(field33);

        //paczka 12

        JFormattedTextField field14 = new JFormattedTextField(formatter);
        field14.setPreferredSize(new Dimension(20,20));
        JFormattedTextField field15 = new JFormattedTextField(formatter);
        JFormattedTextField field16 = new JFormattedTextField(formatter);
        JFormattedTextField field24 = new JFormattedTextField(formatter);
        JFormattedTextField field25 = new JFormattedTextField(formatter);
        JFormattedTextField field26 = new JFormattedTextField(formatter);
        JFormattedTextField field34 = new JFormattedTextField(formatter);
        JFormattedTextField field35 = new JFormattedTextField(formatter);
        JFormattedTextField field36 = new JFormattedTextField(formatter);


        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.setSize(100,100);
        buttonPanel2.setLayout(new GridLayout(3,3));
        buttonPanel2.add(field14);
        buttonPanel2.add(field15);
        buttonPanel2.add(field16);
        buttonPanel2.add(field24);
        buttonPanel2.add(field25);
        buttonPanel2.add(field26);
        buttonPanel2.add(field34);
        buttonPanel2.add(field35);
        buttonPanel2.add(field36);

        //paczka 13

        JFormattedTextField field17 = new JFormattedTextField(formatter);
        field14.setPreferredSize(new Dimension(20,20));
        JFormattedTextField field18 = new JFormattedTextField(formatter);
        JFormattedTextField field19 = new JFormattedTextField(formatter);
        JFormattedTextField field27 = new JFormattedTextField(formatter);
        JFormattedTextField field28 = new JFormattedTextField(formatter);
        JFormattedTextField field29 = new JFormattedTextField(formatter);
        JFormattedTextField field37 = new JFormattedTextField(formatter);
        JFormattedTextField field38 = new JFormattedTextField(formatter);
        JFormattedTextField field39 = new JFormattedTextField(formatter);

        JPanel buttonPanel3 = new JPanel();
        buttonPanel3.setSize(100,100);
        buttonPanel3.setLayout(new GridLayout(3,3));
        buttonPanel3.add(field17);
        field17.setPreferredSize(new Dimension(20,20));
        buttonPanel3.add(field18);
        buttonPanel3.add(field19);
        buttonPanel3.add(field27);
        buttonPanel3.add(field28);
        buttonPanel3.add(field29);
        buttonPanel3.add(field37);
        buttonPanel3.add(field38);
        buttonPanel3.add(field39);

        //paczka 21

        JFormattedTextField field41 = new JFormattedTextField(formatter);
        field41.setPreferredSize(new Dimension(20,20));
        JFormattedTextField field42 = new JFormattedTextField(formatter);
        JFormattedTextField field43 = new JFormattedTextField(formatter);
        JFormattedTextField field51 = new JFormattedTextField(formatter);
        JFormattedTextField field52 = new JFormattedTextField(formatter);
        JFormattedTextField field53 = new JFormattedTextField(formatter);
        JFormattedTextField field61 = new JFormattedTextField(formatter);
        JFormattedTextField field62 = new JFormattedTextField(formatter);
        JFormattedTextField field63 = new JFormattedTextField(formatter);

        JPanel buttonPanel4 = new JPanel();
        buttonPanel4.setSize(100,100);
        buttonPanel4.setLayout(new GridLayout(3,3));
        buttonPanel4.add(field41);
        buttonPanel4.add(field42);
        buttonPanel4.add(field43);
        buttonPanel4.add(field51);
        buttonPanel4.add(field52);
        buttonPanel4.add(field53);
        buttonPanel4.add(field61);
        buttonPanel4.add(field62);
        buttonPanel4.add(field63);




        buttonPanel1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(
                        Color.white,
                        new Color(156, 156, 158)),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));
        buttonPanel2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(
                        Color.white,
                        new Color(156, 156, 158)),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));
        buttonPanel3.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(
                        Color.white,
                        new Color(156, 156, 158)),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));
        buttonPanel4.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(
                        Color.white,
                        new Color(156, 156, 158)),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));
/*

        FocusListener f11 = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
            System.out.println(field11.getValue());
            }
        };
        FocusListener f12 = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println(field12.getValue());
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println(field12.getValue());
            }
        };
        FocusListener f13 = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println(field13.getValue());
            }
        };


        field11.addFocusListener(f13);
        field12.addFocusListener(f11);
        field13.addFocusListener(f12);




*/



        JPanel rootPanel = new JPanel();
        // rootPanel.setLayout(new GridLayout(3,3));

rootPanel.add(buttonPanel1);
rootPanel.add(buttonPanel2);
rootPanel.add(buttonPanel3);
rootPanel.add(buttonPanel4);



        return rootPanel;
    }




}
