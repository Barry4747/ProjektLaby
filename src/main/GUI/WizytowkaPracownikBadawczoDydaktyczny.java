package main.GUI;

import main.java.PracownikBadawczoDydaktyczny;

import javax.swing.*;
import java.awt.*;

public class WizytowkaPracownikBadawczoDydaktyczny extends JPanel {
    private PracownikBadawczoDydaktyczny pracownik;

    public WizytowkaPracownikBadawczoDydaktyczny(PracownikBadawczoDydaktyczny pracownik){
        this.pracownik=pracownik;

        this.setLayout(null);
        this.setSize(800, 250);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel avatar = new JLabel();
        avatar.setBounds(10,10,150,180);
        avatar.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\barte\\Documents\\GitHub\\ProjektLaby\\src\\resources\\avatar.png").getImage().getScaledInstance(avatar.getWidth(), avatar.getHeight(), Image.SCALE_SMOOTH)));;

        JLabel imieINazwiskoLabel = new JLabel("<html>"+pracownik.getImie()+" "+pracownik.getNazwisko()+"<br>"+pracownik.getEmail()+"</html>");
        imieINazwiskoLabel.setBounds(10, 185, 300, 80);
        imieINazwiskoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel wiekLabel = new JLabel("Wiek: "+pracownik.getWiek());
        wiekLabel.setBounds(200, 20, 100, 30);
        wiekLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel peselLabel = new JLabel("Pesel: "+pracownik.getPESEL());
        peselLabel.setBounds(200, 80, 200, 30);
        peselLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel plecLabel = new JLabel("Plec: "+pracownik.getPlec());
        plecLabel.setBounds(200, 140, 200, 30);
        plecLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel stanowiskoLabel = new JLabel("Stanowisko: "+pracownik.getStanowisko());
        stanowiskoLabel.setBounds(200, 200, 300, 30);
        stanowiskoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel stazPracyLabel = new JLabel("Staz pracy: "+pracownik.getStazPracy());
        stazPracyLabel.setBounds(500, 20, 300, 30);
        stazPracyLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel pensjaLabel = new JLabel("Pensja: "+pracownik.getPensja());
        pensjaLabel.setBounds(500, 80, 300, 30);
        pensjaLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel premiaLabel = new JLabel("Premia: "+pracownik.getPremia());
        premiaLabel.setBounds(500, 140, 300, 30);
        premiaLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel liczbaPublikacjiLabel = new JLabel("Liczba publikacji: "+pracownik.getLiczbaPublikacji());
        liczbaPublikacjiLabel.setBounds(500, 200, 300, 30);
        liczbaPublikacjiLabel.setFont(new Font("Arial", Font.PLAIN, 16));



        this.add(avatar);
        this.add(imieINazwiskoLabel);
        this.add(wiekLabel);
        this.add(peselLabel);
        this.add(plecLabel);
        this.add(stanowiskoLabel);
        this.add(stazPracyLabel);
        this.add(pensjaLabel);
        this.add(premiaLabel);
        this.add(liczbaPublikacjiLabel);
    }
}
