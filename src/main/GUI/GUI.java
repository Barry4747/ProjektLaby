package main.GUI;

import main.java.Main;
import main.java.PracownikAdministracyjny;
import main.java.PracownikBadawczoDydaktyczny;
import main.java.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
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
    public JButton buttonDodajOcene;
    public JButton buttonPremia;
    public JRadioButton radioPremiaOpcja1;
    public JRadioButton radioPremiaOpcja2;
    public ButtonGroup grupaPremia;

    public void rysuj(){
        ramka= new JFrame();
        ramka.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
        buttonDodajOcene = new JButton("Dodaj ocene");
        buttonPremia = new JButton("Licz premie");

        buttonSetup(buttonWyjscia);
        buttonWyjscia.setBounds(750,50,200,50);

        buttonSetup(buttonWyswietl);
        buttonWyswietl.setBounds(100,50,200,50);

        buttonSetup(buttonDodaj);
        buttonDodaj.setBounds(100,150,200,50);

        buttonSetup(buttonSortuj);
        buttonSortuj.setBounds(100,250,200,50);

        buttonSetup(buttonUsun);
        buttonUsun.setBounds(100,350,200,50);

        buttonSetup(buttonZapisz);
        buttonZapisz.setBounds(750,150,200,50);

        buttonSetup(buttonDodajOcene);
        buttonDodajOcene.setBounds(100,450,200,50);

        buttonSetup(buttonPremia);
        buttonPremia.setBounds(100, 550, 200, 50);


        //action listeners


        //panel boczny glowny lewy
        panelLewyGlowny = new JPanel();
        JLabel lebPanelLewy = new JLabel();
        Icon iconPWR = new ImageIcon("C:\\Users\\barte\\Documents\\GitHub\\ProjektLaby\\src\\resources\\pwrIcon.png");
        lebPanelLewy.setIcon(iconPWR);
        panelLewyGlowny.add(lebPanelLewy);
        panelLewyGlowny.setSize(200,700);


        //scrollpane do wyswietlania

        List wizytowki = new ArrayList();

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

        wyswietlanieScrollPane.setBounds(600,200,800,800);
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
