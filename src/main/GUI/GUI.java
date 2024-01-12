package main.GUI;

import main.java.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUI {
    public JFrame ramka;
    public GradientPanel panelCentrumGlowny;
    public JPanel panelLewyGlowny;
    public JPanel panelGlowny;
    public JPanel panelPremia;
    public JButton buttonWyjscia;
    public JButton buttonWyswietl;
    public JButton buttonDodaj;
    public JButton buttonSortuj;
    public JButton buttonUsun;
    public JButton buttonZapisz;
    public JButton buttonPremia;
    public JRadioButton radioPremiaOpcja1;
    public JRadioButton radioPremiaOpcja2;
    public ButtonGroup grupaPremia;

    public void rysuj(){
        ramka= new JFrame();
        ramka.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ramka.setTitle("Politechnika Wrocławska");

        panelGlowny = new JPanel();
        panelGlowny.setLayout(new BorderLayout());

        panelCentrumGlowny = new GradientPanel();
        panelCentrumGlowny.setLayout(null);

        panelPremia = new JPanel();
        panelPremia.setLayout(null);

        //panel premia
        radioPremiaOpcja1 = new JRadioButton("strategia 1");
        radioPremiaOpcja2 = new JRadioButton("strategia 2");
        grupaPremia = new ButtonGroup();
        grupaPremia.add(radioPremiaOpcja1);
        grupaPremia.add(radioPremiaOpcja2);


        //buttony panel glowny
        buttonWyjscia = new JButton("WYJSCIE");
        buttonWyswietl = new JButton("WYSWIETL");
        buttonDodaj = new JButton("DODAJ");
        buttonSortuj = new JButton("SORTUJ");
        buttonUsun = new JButton("USUN");
        buttonZapisz = new JButton("ZAPISZ");
        buttonPremia = new JButton("LICZ PREMIE");

        buttonWyjscia.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonWyjscia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ramka.dispose();
            }
        });
        buttonWyjscia.setBounds(0,180,200,50);
        buttonWyjscia.setFocusPainted(false);
        buttonWyjscia.setBackground(new Color(224, 127, 115, 255));

        buttonWyswietl.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonWyswietl.setBounds(0,0,200,50);
        buttonWyswietl.setFocusPainted(false);
        buttonWyswietl.setBackground(new Color(224, 127, 115, 255));

        buttonDodaj.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonDodaj.setBounds(0,60,200,50);
        buttonDodaj.setFocusPainted(false);
        buttonDodaj.setBackground(new Color(224, 127, 115, 255));

        buttonUsun.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonUsun.setBounds(0,120,200,50);
        buttonUsun.setFocusPainted(false);
        buttonUsun.setBackground(new Color(224, 127, 115, 255));


        buttonZapisz.setBounds(150,925, 40,50);
        buttonZapisz.setBackground(new Color(178, 178, 178, 186));
        buttonZapisz.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\barte\\Documents\\GitHub\\ProjektLaby\\src\\resources\\zapisz.png").getImage().getScaledInstance(buttonZapisz.getWidth(), buttonZapisz.getHeight(), Image.SCALE_SMOOTH)));
        buttonZapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Serializacja.zapiszListeOsob(Main.osoba);
                Serializacja.zapiszListeKursow(Main.listaKursow);
                for(Kursy i: Main.listaKursow){
                    Serializacja.zapiszListeObs(i.getKursant().getListaObserwatorow(), i);
                }
                JOptionPane.showMessageDialog(null, "Zapisano zmiany!", "Informacja", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.add(buttonWyswietl);
        panelMenu.add(buttonDodaj);
        panelMenu.add(buttonUsun);
        panelMenu.add(buttonWyjscia);
        panelMenu.setOpaque(true);
        panelMenu.setBackground(new Color(176, 29, 9, 255));
        panelMenu.setBounds(4,350, 250, 250);


        //panel boczny glowny lewy
        panelLewyGlowny = new JPanel();
        panelLewyGlowny.setLayout(new FlowLayout());
        JLabel lebPanelLewy = new JLabel();
        lebPanelLewy.setBounds(0,0,200,700);
        Icon iconPWR = new ImageIcon("C:\\Users\\barte\\Documents\\GitHub\\ProjektLaby\\src\\resources\\pwrIcon.png");
        lebPanelLewy.setIcon(iconPWR);
        lebPanelLewy.setLayout(null);
        lebPanelLewy.add(panelMenu);
        lebPanelLewy.add(buttonZapisz);
        panelLewyGlowny.add(lebPanelLewy);
        panelLewyGlowny.setSize(200,700);


        //scrollpane do wyswietlania

        WyswietlanieGUI wyswietlanieGUI = new WyswietlanieGUI();
        wyswietlanieGUI.setBounds(800,100,800,900);
        panelCentrumGlowny.add(wyswietlanieGUI);

        //panel filtrowania wyswietlania
        FiltrowanieWyswietlaniaGUI filtrowaniePanel = new FiltrowanieWyswietlaniaGUI();
        filtrowaniePanel.setBounds(100,200,600,600);
        filtrowaniePanel.setBackground(Color.GRAY);
        panelCentrumGlowny.add(filtrowaniePanel);


        //action listenery
        buttonWyswietl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wyswietlanieGUI.setVisible(true);
                filtrowaniePanel.setVisible(true);
            }
        });

        buttonDodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wyswietlanieGUI.setVisible(false);
                filtrowaniePanel.setVisible(false);
            }
        });


        //dodawanie do panelu glownego
        panelGlowny.add(BorderLayout.WEST, panelLewyGlowny);
        panelGlowny.add(BorderLayout.CENTER, panelCentrumGlowny);

        ramka.add(panelGlowny);
        ramka.setSize(1920,1080);
        ramka.setVisible(true);
    }
    public void buttonSetup(JButton button){
        button.setBackground(Color.WHITE);
        button.setFont(new Font("Arial", Font.PLAIN, 12));
        //panelCentrumGlowny.add(button);
    }
}

//gradient

class GradientPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Rysuj gradient od białego do szarego
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        GradientPaint gradient = new GradientPaint(0, 0, Color.WHITE, width, height, Color.GRAY);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, width, height);
    }
}
