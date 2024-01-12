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
    public JPanel panelCentrumGlowny;
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
    private List wizytowki;

    public void rysuj(){
        ramka= new JFrame();
        ramka.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ramka.setTitle("Politechnika Wrocławska");

        panelGlowny = new JPanel();
        panelGlowny.setLayout(new BorderLayout());

        panelCentrumGlowny = new JPanel();
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
        buttonWyjscia = new JButton("Wyjscie");
        buttonWyswietl = new JButton("Wyświetl");
        buttonDodaj = new JButton("Dodaj");
        buttonSortuj = new JButton("Sortuj");
        buttonUsun = new JButton("Usun");
        buttonZapisz = new JButton("Zapisz");
        buttonPremia = new JButton("Licz premie");

        buttonWyjscia.setFont(new Font("Arial", Font.PLAIN, 12));
        buttonWyjscia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ramka.dispose();
            }
        });
        buttonWyjscia.setBounds(0,180,200,50);
        buttonWyjscia.setFocusPainted(false);
        buttonWyjscia.setBackground(new Color(224, 127, 115, 255));

        buttonWyswietl.setFont(new Font("Arial", Font.PLAIN, 12));
        buttonWyswietl.setBounds(0,0,200,50);
        buttonWyswietl.setFocusPainted(false);
        buttonWyswietl.setBackground(new Color(224, 127, 115, 255));

        buttonDodaj.setFont(new Font("Arial", Font.PLAIN, 12));
        buttonDodaj.setBounds(0,60,200,50);
        buttonDodaj.setFocusPainted(false);
        buttonDodaj.setBackground(new Color(224, 127, 115, 255));

        buttonUsun.setFont(new Font("Arial", Font.PLAIN, 12));
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


        //action listeners


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

        wizytowki = new ArrayList();

        for(int i=0; i<Main.osoba.size(); i++){
            if(Main.osoba.get(i) instanceof Student){
                wizytowki.add(new WizytowkaStudent((Student) Main.osoba.get(i)));
            }else if(Main.osoba.get(i) instanceof PracownikAdministracyjny){
                wizytowki.add(new WizytowkaPracownikAdministracyjny((PracownikAdministracyjny) Main.osoba.get(i)));
            } else if (Main.osoba.get(i) instanceof PracownikBadawczoDydaktyczny) {
                wizytowki.add(new WizytowkaPracownikBadawczoDydaktyczny((PracownikBadawczoDydaktyczny) Main.osoba.get(i)));
            }
        }

        Object[][] dane = new Object[wizytowki.size()][1];
        String[] naglowek = {"Osoby"};

        for(int i=0; i<wizytowki.size(); i++){
            dane[i][0] = wizytowki.get(i);
        }
        DefaultTableModel model = new DefaultTableModel(dane, naglowek);
        JTable tabela = new JTable(model);
        tabela.getColumnModel().getColumn(0).setCellRenderer(new PanelRenderer());
        tabela.setRowHeight(250);

        JScrollPane wyswietlanieScrollPane = new JScrollPane(tabela, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        wyswietlanieScrollPane.setBounds(800,100,800,900);
        panelCentrumGlowny.add(wyswietlanieScrollPane);

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
    private static class PanelRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            return (Component) value;
        }
    }
}
