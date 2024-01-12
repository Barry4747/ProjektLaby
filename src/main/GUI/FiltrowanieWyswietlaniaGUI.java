package main.GUI;

import javax.swing.*;
import java.awt.*;

public class FiltrowanieWyswietlaniaGUI extends JPanel {

    private JButton wszyscyButton;
    private JButton studenciButton;
    private JButton pracownicyButton;

    public FiltrowanieWyswietlaniaGUI(){
        this.setLayout(null);

        wszyscyButton = new JButton("WSZYSCY");
        studenciButton = new JButton("STUDENCI");
        pracownicyButton = new JButton("PRACOWNICY");

        buttonSetup(wszyscyButton, 0,0);
        buttonSetup(studenciButton, 200, 0);
        buttonSetup(pracownicyButton, 400,0);

        //TODO: dodanie action listenerow do filtrowania, ktore umozliwia przelaczanie sie miedzy filtrami w zaleznosci od tego jaki button zostal klikniety

    }
    public void buttonSetup(JButton button, int x, int y){
        button.setFont(new Font("Arial", Font.PLAIN, 18));
        button.setBounds(x,y,200,50);
        button.setFocusPainted(false);
        button.setBackground(Color.WHITE);
        this.add(button);
    }
}
