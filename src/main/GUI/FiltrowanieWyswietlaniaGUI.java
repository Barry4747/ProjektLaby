package main.GUI;

import main.java.*;
import main.java.Menu;
import main.strategiaPremia.PremiaZaNadgodziny;
import main.strategiaPremia.PremiaZaPublikacje;
import main.strategiaPremia.PremiaZaStaz;
import main.strategiaPremia.StrategiaPremia;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class FiltrowanieWyswietlaniaGUI extends JPanel {
    private ArrayList osoby;
    private ArrayList kursy;

    private JButton wszyscyButton;
    private JButton studenciButton;
    private JButton pracownicyButton;
    private JButton kursyButton;
    private DefaultTableModel model;
    private JTable tabela;
    private JComboBox<String> comboBox;
    private JComboBox<String> comboBoxKursy;

    public FiltrowanieWyswietlaniaGUI(DefaultTableModel model, JTable tabela){
        this.tabela=tabela;
        this.model=model;
        this.setLayout(null);

        osoby = (ArrayList) Main.osoba;

        FiltrujStudentow filtrujStudentow = new FiltrujStudentow();
        filtrujStudentow.setBounds(100,100,400,400);
        filtrujStudentow.setVisible(false);

        FiltrujPracownikow filtrujPracownikow = new FiltrujPracownikow();
        filtrujPracownikow.setBounds(100,100,400,400);
        filtrujPracownikow.setVisible(false);

        FiltrujKursy filtrujKursy = new FiltrujKursy();
        filtrujKursy.setBounds(100,100,400,400);
        filtrujKursy.setVisible(false);

        JButton usunPowtorki = new JButton("USUŃ POWTÓRKI");
        usunPowtorki.setBounds(345,525,250,70);
        usunPowtorki.setBackground(Color.WHITE);
        usunPowtorki.setVisible(true);

        this.add(filtrujStudentow);
        this.add(filtrujPracownikow);
        this.add(filtrujKursy);
        this.add(usunPowtorki);

        wszyscyButton = new JButton("WSZYSCY");
        studenciButton = new JButton("STUDENCI");
        pracownicyButton = new JButton("PRACOWNICY");
        kursyButton = new JButton("KURSY");

        buttonSetup(wszyscyButton, 0,0);
        buttonSetup(studenciButton, 150, 0);
        buttonSetup(pracownicyButton, 300,0);
        buttonSetup(kursyButton, 450, 0);

        wszyscyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrujPracownikow.setVisible(false);
                filtrujStudentow.setVisible(false);
                filtrujKursy.setVisible(false);
                comboBoxKursy.setVisible(false);
                comboBox.setVisible(true);
                usunPowtorki.setVisible(true);


                osoby= (ArrayList) Main.osoba;
                Object[][] noweDane = new Object[Main.osoba.size()][1];

                for(int i = 0; i< Main.osoba.size(); i++){
                    if(Main.osoba.get(i) instanceof Student){
                        noweDane[i][0]=new WizytowkaStudent((Student) Main.osoba.get(i));
                    } else if(Main.osoba.get(i) instanceof PracownikBadawczoDydaktyczny){
                        noweDane[i][0]=new WizytowkaPracownikBadawczoDydaktyczny((PracownikBadawczoDydaktyczny) Main.osoba.get(i));
                    } else if (Main.osoba.get(i) instanceof  PracownikAdministracyjny) {
                        noweDane[i][0]=new WizytowkaPracownikAdministracyjny(((PracownikAdministracyjny) Main.osoba.get(i)));
                    }
                }
                aktualizujTabele(noweDane);
            }
        });
        studenciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrujPracownikow.setVisible(false);
                filtrujStudentow.setVisible(true);
                filtrujKursy.setVisible(false);
                comboBoxKursy.setVisible(false);
                comboBox.setVisible(true);
                usunPowtorki.setVisible(false);

                osoby = (ArrayList) Menu.wyswietlStudentow();

                Object[][] noweDane = new Object[osoby.size()][1];

                for(int i=0; i<osoby.size(); i++){
                    noweDane[i][0] = new WizytowkaStudent((Student) osoby.get(i));
                }
                aktualizujTabele(noweDane);
            }
        });
        pracownicyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrujPracownikow.setVisible(true);
                filtrujStudentow.setVisible(false);
                filtrujKursy.setVisible(false);
                comboBoxKursy.setVisible(false);
                comboBox.setVisible(true);
                usunPowtorki.setVisible(false);
                osoby = (ArrayList) Menu.wyswietlPracownikUczelni();

                Object[][] noweDane = new Object[osoby.size()][1];

                for(int i=0; i<osoby.size(); i++){
                    if(osoby.get(i) instanceof PracownikAdministracyjny) {
                        noweDane[i][0] = new WizytowkaPracownikAdministracyjny((PracownikAdministracyjny) osoby.get(i));
                    }else{
                        noweDane[i][0] = new WizytowkaPracownikBadawczoDydaktyczny((PracownikBadawczoDydaktyczny) osoby.get(i));
                    }
                }
                aktualizujTabele(noweDane);
            }

        });

        kursyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrujPracownikow.setVisible(false);
                filtrujStudentow.setVisible(false);
                filtrujKursy.setVisible(true);
                comboBoxKursy.setVisible(true);
                comboBox.setVisible(false);
                usunPowtorki.setVisible(false);

                kursy = (ArrayList) Menu.wyswietlWszystkieKursy();

                Object[][] noweDane = new Object[Main.listaKursow.size()][1];

                for(int i=0; i<Main.listaKursow.size(); i++){
                    noweDane[i][0] = new WizytowkaKurs(Main.listaKursow.get(i));
                }
                aktualizujTabele(noweDane);
            }
        });

        usunPowtorki.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.usunPowtorki();
            }
        });


        //sortowanie

        JLabel ikonaSortowania = new JLabel();
        ikonaSortowania.setSize(50,50);
        ikonaSortowania.setOpaque(true);
        ikonaSortowania.setBackground(Color.WHITE);
        ikonaSortowania.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\barte\\Documents\\GitHub\\ProjektLaby\\src\\resources\\sort.png").getImage().getScaledInstance(ikonaSortowania.getWidth(), ikonaSortowania.getHeight(), Image.SCALE_SMOOTH)));

        String[] options = {
                "nazwisko",
                "nazwisko i imie",
                "nazwisko i wiek"
        };

        comboBox = new JComboBox<>(options);
        comboBox.setSize(100,50);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[][] noweDane = new Object[osoby.size()][1];
                String selectedOption = (String) comboBox.getSelectedItem();
                switch (selectedOption) {
                    case "nazwisko":
                        osoby= (ArrayList) Sortowanie.poNazwisku(osoby);
                        for(int i = 0; i< osoby.size(); i++){
                            if(osoby.get(i) instanceof Student){
                                noweDane[i][0]=new WizytowkaStudent((Student) osoby.get(i));
                            } else if(osoby.get(i) instanceof PracownikBadawczoDydaktyczny){
                                noweDane[i][0]=new WizytowkaPracownikBadawczoDydaktyczny((PracownikBadawczoDydaktyczny) osoby.get(i));
                            } else if (osoby.get(i) instanceof  PracownikAdministracyjny) {
                                noweDane[i][0]=new WizytowkaPracownikAdministracyjny(((PracownikAdministracyjny) osoby.get(i)));
                            }
                        }
                        aktualizujTabele(noweDane);
                        break;
                    case "nazwisko i imie":
                        osoby= (ArrayList) Sortowanie.poImieniuINazwisku(osoby);
                        for(int i = 0; i< osoby.size(); i++){
                            if(osoby.get(i) instanceof Student){
                                noweDane[i][0]=new WizytowkaStudent((Student) osoby.get(i));
                            } else if(osoby.get(i) instanceof PracownikBadawczoDydaktyczny){
                                noweDane[i][0]=new WizytowkaPracownikBadawczoDydaktyczny((PracownikBadawczoDydaktyczny) osoby.get(i));
                            } else if (osoby.get(i) instanceof  PracownikAdministracyjny) {
                                noweDane[i][0]=new WizytowkaPracownikAdministracyjny(((PracownikAdministracyjny) osoby.get(i)));
                            }
                        }
                        aktualizujTabele(noweDane);
                        break;
                    case "nazwisko i wiek":
                        osoby= (ArrayList) Sortowanie.poNazwiskuIWieku(osoby);
                        for(int i = 0; i< osoby.size(); i++){
                            if(osoby.get(i) instanceof Student){
                                noweDane[i][0]=new WizytowkaStudent((Student) osoby.get(i));
                            } else if(osoby.get(i) instanceof PracownikBadawczoDydaktyczny){
                                noweDane[i][0]=new WizytowkaPracownikBadawczoDydaktyczny((PracownikBadawczoDydaktyczny) osoby.get(i));
                            } else if (osoby.get(i) instanceof  PracownikAdministracyjny) {
                                noweDane[i][0]=new WizytowkaPracownikAdministracyjny(((PracownikAdministracyjny) osoby.get(i)));
                            }
                        }
                        aktualizujTabele(noweDane);
                        break;
                    default:
                        break;
                }
            }
        });
        ikonaSortowania.setBounds(0,550,50,50);
        comboBox.setBounds(50,550,200,50);
        this.add(comboBox);
        this.add(ikonaSortowania);

        //sortowanie kursow
        String[] optionsKursy = {
                "nazwisko prowadzącego",
                "punkty ECTS"
        };

        comboBoxKursy = new JComboBox<>(optionsKursy);
        comboBoxKursy.setSize(100,50);

        comboBoxKursy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[][] noweDane = new Object[kursy.size()][1];
                String selectedOption = (String) comboBoxKursy.getSelectedItem();
                switch (selectedOption) {
                    case "nazwisko prowadzącego":
                        kursy= (ArrayList) Sortowanie.kursPoNazwisko(kursy);
                        for(int i = 0; i< kursy.size(); i++){
                            noweDane[i][0] = new WizytowkaKurs((Kursy) kursy.get(i));
                        }
                        aktualizujTabele(noweDane);
                        break;
                    case "punkty ECTS":
                        kursy= (ArrayList) Sortowanie.kursPoECTS(kursy);
                        for(int i = 0; i< kursy.size(); i++){
                            noweDane[i][0] = new WizytowkaKurs((Kursy) kursy.get(i));
                        }
                        aktualizujTabele(noweDane);
                        break;
                    default:
                        break;
                }
            }
        });
        comboBoxKursy.setBounds(50,550,200,50);
        this.add(comboBoxKursy);
        comboBoxKursy.setVisible(false);

    }


    public void buttonSetup(JButton button, int x, int y){
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBounds(x,y,150,50);
        button.setFocusPainted(false);
        button.setBackground(Color.WHITE);
        this.add(button);
    }
    public void aktualizujTabele(Object[][] noweDane){
        String[] naglowek = {"Osoby"};
        model.setDataVector(noweDane, naglowek);
        tabela.getColumnModel().getColumn(0).setCellRenderer(new PanelRenderer());
    }

    private class PanelRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            return (Component) value;
        }
    }

    class FiltrujStudentow extends JPanel{
        private JLabel labelNazwisko;
        private JLabel labelImie;
        private JLabel labelId;
        private JLabel labelRok;
        private JLabel labelKurs;
        private JTextField txtNazwisko;
        private JTextField txtImie;
        private JTextField txtId;
        private JTextField txtRok;
        private JTextField txtKurs;
        private JButton zatwierdz;
        private JButton usunFiltry;
        public FiltrujStudentow(){
            this.setLayout(new GridLayout(6,2,10,10));
            labelImie=new JLabel("IMIE:");
            setupLabel(labelImie);
            labelNazwisko=new JLabel("NAZWISKO:");
            setupLabel(labelNazwisko);
            labelId = new JLabel("NUMER INDEKSU:");
            setupLabel(labelId);
            labelRok = new JLabel("ROK STUDIOW:");
            setupLabel(labelRok);
            labelKurs = new JLabel("NAZWA KURSU:");
            setupLabel(labelKurs);
            txtNazwisko=new JTextField();
            txtNazwisko.setBorder(new LineBorder(Color.BLACK, 2));
            txtImie=new JTextField();
            txtImie.setBorder(new LineBorder(Color.BLACK, 2));
            txtId=new JTextField();
            txtId.setBorder(new LineBorder(Color.BLACK, 2));
            txtRok=new JTextField();
            txtRok.setBorder(new LineBorder(Color.BLACK, 2));
            txtKurs=new JTextField();
            txtKurs.setBorder(new LineBorder(Color.BLACK, 2));

            usunFiltry = new JButton("USUN FILTRY");
            usunFiltry.setBackground(Color.WHITE);
            usunFiltry.setFont(new Font("Arial", Font.PLAIN, 16));
            usunFiltry.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtImie.setText("");
                    txtNazwisko.setText("");
                    txtId.setText("");
                    txtRok.setText("");
                    txtKurs.setText("");
                }
            });

            zatwierdz = new JButton("FILTRUJ");
            zatwierdz.setBackground(Color.WHITE);
            zatwierdz.setFont(new Font("Arial", Font.PLAIN, 16));
            zatwierdz.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Objects.equals(txtNazwisko.getText(), "") && Objects.equals(txtImie.getText(), "") && Objects.equals(txtId.getText(), "")
                            && Objects.equals(txtRok.getText(), "") && Objects.equals(txtKurs.getText(), "")){
                        osoby= (ArrayList) Menu.wyswietlStudentow();
                        Object[][] noweDane = new Object[osoby.size()][1];

                        for(int i=0; i<osoby.size(); i++){
                            noweDane[i][0] = new WizytowkaStudent((Student) osoby.get(i));
                        }
                        aktualizujTabele(noweDane);
                    }else{
                        osoby = new ArrayList();
                        osoby.addAll(Menu.wyszukajPoNazwiskoStudent(txtNazwisko.getText()));
                        osoby.addAll(Menu.wyszukajPoImieStudent(txtImie.getText()));
                        osoby.addAll(Menu.wyszukajPoNrIndeksu(txtId.getText()));
                        if(txtRok.getText().matches("[0-9]+")) {
                            osoby.addAll(Menu.wyszukajPoRokStudiow(Integer.parseInt(txtRok.getText())));
                        }
                        osoby.addAll(Menu.wyszukajPoNazwaKursuStudent(txtKurs.getText()));

                        Object[][] noweDane = new Object[osoby.size()][1];

                        for(int i=0; i<osoby.size(); i++){
                            noweDane[i][0] = new WizytowkaStudent((Student) osoby.get(i));
                        }
                        aktualizujTabele(noweDane);
                    }
                }
            });

            this.add(labelNazwisko);
            this.add(txtNazwisko);
            this.add(labelImie);
            this.add(txtImie);
            this.add(labelId);
            this.add(txtId);
            this.add(labelRok);
            this.add(txtRok);
            this.add(labelKurs);
            this.add(txtKurs);
            this.add(zatwierdz);
            this.add(usunFiltry);
            this.setBackground(new Color(126, 126, 126, 255));
        }
        public void setupLabel(JLabel label){
            label.setBorder(new LineBorder(Color.BLACK, 2));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 16));
            label.setOpaque(true);
            label.setBackground(new Color(187, 186, 186, 255));
        }
    }

    class FiltrujPracownikow extends JPanel{
        private JLabel labelNazwisko;
        private JLabel labelImie;
        private JLabel labelStanowisko;
        private JLabel labelStaz;
        private JLabel labelNadgodziny;
        private JLabel labelPensja;
        private JLabel labelPremia;
        private JComboBox<String> comboBoxPremia;
        private JTextField txtNazwisko;
        private JTextField txtImie;
        private JTextField txtStanowisko;
        private JTextField txtStaz;
        private JTextField txtNadgodziny;
        private JTextField txtPensja;
        private JButton zatwierdz;
        private JButton usunFiltry;
        public FiltrujPracownikow(){
            this.setLayout(new GridLayout(8,2,10,10));
            labelImie=new JLabel("IMIE:");
            setupLabel(labelImie);
            labelNazwisko=new JLabel("NAZWISKO:");
            setupLabel(labelNazwisko);
            labelStanowisko = new JLabel("STANOWISKO:");
            setupLabel(labelStanowisko);
            labelStaz = new JLabel("STAZ PRACY:");
            setupLabel(labelStaz);
            labelNadgodziny = new JLabel("LICZBA NADGODZIN:");
            setupLabel(labelNadgodziny);
            labelPensja = new JLabel("PENSJ: ");
            setupLabel(labelPensja);
            labelPremia = new JLabel("LICZ PREMIE PO: ");
            setupLabel(labelPremia);
            txtNazwisko=new JTextField();
            txtNazwisko.setBorder(new LineBorder(Color.BLACK, 2));
            txtImie=new JTextField();
            txtImie.setBorder(new LineBorder(Color.BLACK, 2));
            txtStanowisko=new JTextField();
            txtStanowisko.setBorder(new LineBorder(Color.BLACK, 2));
            txtStaz=new JTextField();
            txtStaz.setBorder(new LineBorder(Color.BLACK, 2));
            txtNadgodziny=new JTextField();
            txtNadgodziny.setBorder(new LineBorder(Color.BLACK, 2));
            txtPensja=new JTextField();
            txtPensja.setBorder(new LineBorder(Color.BLACK, 2));

            //combobox do liczenia premi
            String[] opcjePremia = {
                    "staz pracy",
                    "publikacje/nadgodziny"
            };

            comboBoxPremia = new JComboBox<>(opcjePremia);

            comboBoxPremia.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<PracownikUczelni> tempPracownicy = new ArrayList<>();
                    StrategiaPremia strategiaPremia= new PremiaZaStaz();
                    for(Osoba i : Main.osoba){
                        if(i instanceof PracownikUczelni) {
                            tempPracownicy.add((PracownikUczelni) i);
                        }
                    }
                    Object[][] noweDane = new Object[tempPracownicy.size()][1];
                    String selectedOption = (String) comboBoxPremia.getSelectedItem();
                    switch (selectedOption) {
                        case "staz pracy":
                            strategiaPremia = new PremiaZaStaz();
                            for(PracownikUczelni i : tempPracownicy){
                                i.setPremia(strategiaPremia.liczPremie(i));
                            }
                            break;
                        case "publikacje/nadgodziny":
                            for(PracownikUczelni i : tempPracownicy){
                                if(i instanceof PracownikAdministracyjny){
                                    strategiaPremia=new PremiaZaNadgodziny();
                                    i.setPremia(strategiaPremia.liczPremie(i));
                                }else {
                                    strategiaPremia = new PremiaZaPublikacje();
                                    i.setPremia(strategiaPremia.liczPremie(i));
                                }
                            }
                            break;
                        default:
                            break;
                    }
                    for(int i=0; i<tempPracownicy.size(); i++){
                        if(tempPracownicy.get(i) instanceof PracownikBadawczoDydaktyczny) {
                            noweDane[i][0] = new WizytowkaPracownikBadawczoDydaktyczny((PracownikBadawczoDydaktyczny) tempPracownicy.get(i));
                        }else{
                            noweDane[i][0] = new WizytowkaPracownikAdministracyjny((PracownikAdministracyjny) tempPracownicy.get(i));
                        }
                    }

                    aktualizujTabele(noweDane);
                }
            });


            usunFiltry = new JButton("USUN FILTRY");
            usunFiltry.setBackground(Color.WHITE);
            usunFiltry.setFont(new Font("Arial", Font.PLAIN, 16));
            usunFiltry.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtImie.setText("");
                    txtNazwisko.setText("");
                    txtStanowisko.setText("");
                    txtStaz.setText("");
                    txtNadgodziny.setText("");
                    txtPensja.setText("");
                }
            });

            zatwierdz = new JButton("FILTRUJ");
            zatwierdz.setBackground(Color.WHITE);
            zatwierdz.setFont(new Font("Arial", Font.PLAIN, 16));
            zatwierdz.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Objects.equals(txtNazwisko.getText(), "") && Objects.equals(txtImie.getText(), "") && Objects.equals(txtStanowisko.getText(), "")
                            && Objects.equals(txtStaz.getText(), "") && Objects.equals(txtNadgodziny.getText(), "")&& Objects.equals(txtPensja.getText(), "")){
                        osoby= (ArrayList) Menu.wyswietlPracownikUczelni();
                        Object[][] noweDane = new Object[osoby.size()][1];

                        for(int i=0; i<osoby.size(); i++){
                            if(osoby.get(i) instanceof PracownikAdministracyjny) {
                                noweDane[i][0] = new WizytowkaPracownikAdministracyjny((PracownikAdministracyjny) osoby.get(i));
                            }else{
                                noweDane[i][0] = new WizytowkaPracownikBadawczoDydaktyczny((PracownikBadawczoDydaktyczny) osoby.get(i));
                            }
                        }
                        aktualizujTabele(noweDane);
                    }else{
                        osoby = new ArrayList();
                        osoby.addAll(Menu.wyszukajPoNazwiskoPracownik(txtNazwisko.getText()));
                        osoby.addAll(Menu.wyszukajPoImiePracownik(txtImie.getText()));
                        osoby.addAll(Menu.wyszukajPoStanowisko(txtStanowisko.getText()));
                        if(txtStaz.getText().matches("[0-9]+")) {
                            osoby.addAll(Menu.wyszukajPoStazPracy((byte) Integer.parseInt(txtStaz.getText())));
                        }
                        if(txtNadgodziny.getText().matches("[0-9]+")) {
                            osoby.addAll(Menu.wyszukajPoLiczbaNadgodzin(Integer.parseInt(txtNadgodziny.getText())));
                        }
                        if(txtPensja.getText().matches("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?")) {
                            osoby.addAll(Menu.wyszukajPoPensja(Float.parseFloat(txtPensja.getText())));
                        }

                        Object[][] noweDane = new Object[osoby.size()][1];

                        for(int i=0; i<osoby.size(); i++){
                            if(osoby.get(i) instanceof PracownikAdministracyjny) {
                                noweDane[i][0] = new WizytowkaPracownikAdministracyjny((PracownikAdministracyjny) osoby.get(i));
                            }else{
                                noweDane[i][0] = new WizytowkaPracownikBadawczoDydaktyczny((PracownikBadawczoDydaktyczny) osoby.get(i));
                            }
                        }
                        aktualizujTabele(noweDane);
                    }
                }
            });

            this.add(labelNazwisko);
            this.add(txtNazwisko);
            this.add(labelImie);
            this.add(txtImie);
            this.add(labelStanowisko);
            this.add(txtStanowisko);
            this.add(labelStaz);
            this.add(txtStaz);
            this.add(labelNadgodziny);
            this.add(txtNadgodziny);
            this.add(labelPensja);
            this.add(txtPensja);
            this.add(labelPremia);
            this.add(comboBoxPremia);
            this.add(zatwierdz);
            this.add(usunFiltry);
            this.setBackground(new Color(126, 126, 126, 255));
        }
        public void setupLabel(JLabel label){
            label.setBorder(new LineBorder(Color.BLACK, 2));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 16));
            label.setOpaque(true);
            label.setBackground(new Color(187, 186, 186, 255));
        }
    }


    class FiltrujKursy extends JPanel{
        private JLabel nazwa;
        private JLabel prowadzacy;
        private JLabel pkt;
        private JTextField nazwatxt;
        private JTextField prowadzacytxt;
        private JTextField pkttxt;
        private JButton zatwierdz;
        private JButton usunFiltry;
        public FiltrujKursy(){
            this.setLayout(new GridLayout(7,2,10,10));
            nazwa=new JLabel("NAZWA:");
            setupLabel(nazwa);
            prowadzacy=new JLabel("NAZWISKO PROWADZĄCEGO:");
            setupLabel(prowadzacy);
            pkt = new JLabel("ILOŚĆ PUNKTÓW:");
            setupLabel(pkt);
            nazwatxt=new JTextField();
            nazwatxt.setBorder(new LineBorder(Color.BLACK, 2));
            prowadzacytxt=new JTextField();
            prowadzacytxt.setBorder(new LineBorder(Color.BLACK, 2));
            pkttxt=new JTextField();
            pkttxt.setBorder(new LineBorder(Color.BLACK, 2));

            usunFiltry = new JButton("USUN FILTRY");
            usunFiltry.setBackground(Color.WHITE);
            usunFiltry.setFont(new Font("Arial", Font.PLAIN, 16));
            usunFiltry.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nazwatxt.setText("");
                    prowadzacytxt.setText("");
                    pkttxt.setText("");
                }
            });

            zatwierdz = new JButton("FILTRUJ");
            zatwierdz.setBackground(Color.WHITE);
            zatwierdz.setFont(new Font("Arial", Font.PLAIN, 16));
            zatwierdz.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Objects.equals(nazwatxt.getText(), "") && Objects.equals(prowadzacytxt.getText(), "") && Objects.equals(pkttxt.getText(), "")){
                        kursy = (ArrayList) Main.listaKursow;
                        Object[][] noweDane = new Object[kursy.size()][1];

                        for(int i=0; i<kursy.size(); i++){
                            noweDane[i][0] = new WizytowkaKurs((Kursy) kursy.get(i));
                        }
                        aktualizujTabele(noweDane);
                    }else{
                        kursy = new ArrayList();
                        kursy.addAll(Menu.wyszukajPoNazwaKursu(nazwatxt.getText()));
                        kursy.addAll(Menu.wyszukajPoNazwiskuProwadzacego(prowadzacytxt.getText()));
                        if(pkttxt.getText().matches("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?")) {
                            kursy.addAll(Menu.wyszukajPoPktECTS(Float.parseFloat(pkttxt.getText())));
                        }

                        Object[][] noweDane = new Object[kursy.size()][1];

                        for(int i=0; i<kursy.size(); i++){
                            noweDane[i][0]= new WizytowkaKurs((Kursy) kursy.get(i));
                        }
                        aktualizujTabele(noweDane);
                    }
                }
            });

            this.add(nazwa);
            this.add(nazwatxt);
            this.add(prowadzacy);
            this.add(prowadzacytxt);
            this.add(pkt);
            this.add(pkttxt);
            this.add(zatwierdz);
            this.add(usunFiltry);
            this.setBackground(new Color(126, 126, 126, 255));
        }
        public void setupLabel(JLabel label){
            label.setBorder(new LineBorder(Color.BLACK, 2));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 16));
            label.setOpaque(true);
            label.setBackground(new Color(187, 186, 186, 255));
        }
    }
}

