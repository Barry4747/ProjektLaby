package main.GUI;

import main.java.*;
import main.java.Menu;

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

    private JButton wszyscyButton;
    private JButton studenciButton;
    private JButton pracownicyButton;
    private JButton kursyButton;
    private DefaultTableModel model;
    private JTable tabela;

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

        this.add(filtrujStudentow);
        this.add(filtrujPracownikow);

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



        //sortowanie
        JPanel panelSortowanie = new JPanel();
        panelSortowanie.setLayout(new BoxLayout(panelSortowanie, BoxLayout.X_AXIS));
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

        JComboBox<String> comboBox = new JComboBox<>(options);
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

        //TODO: dodanie action listenerow do filtrowania, ktore umozliwia przelaczanie sie miedzy filtrami w zaleznosci od tego jaki button zostal klikniety

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
        private JTextField txtNazwisko;
        private JTextField txtImie;
        private JTextField txtStanowisko;
        private JTextField txtStaz;
        private JTextField txtNadgodziny;
        private JTextField txtPensja;
        private JButton zatwierdz;
        private JButton usunFiltry;
        public FiltrujPracownikow(){
            this.setLayout(new GridLayout(7,2,10,10));
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
                        osoby.addAll(Menu.wyszukajPoNazwiskoStudent(txtNazwisko.getText()));
                        osoby.addAll(Menu.wyszukajPoImieStudent(txtImie.getText()));
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

