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

public class UsuwanieGUI extends JPanel {
    private DefaultTableModel model;
    private JTable tabela;
    private ArrayList osoby;

    private JButton wszyscyButton;
    private JButton studenciButton;
    private JButton pracownicyButton;
    private JButton kursyButton;

    public UsuwanieGUI(DefaultTableModel model, JTable tabela){
        this.tabela=tabela;
        this.model=model;
        this.setLayout(null);

        osoby = (ArrayList) Main.osoba;


        wszyscyButton = new JButton("WSZYSCY");
        studenciButton = new JButton("STUDENCI");
        pracownicyButton = new JButton("PRACOWNICY");
        kursyButton = new JButton("KURSY");

        buttonSetup(wszyscyButton, 0,0);
        buttonSetup(studenciButton, 150, 0);
        buttonSetup(pracownicyButton, 300,0);
        buttonSetup(kursyButton, 450, 0);

        UsunStudentow usunStudentow = new UsunStudentow();
        usunStudentow.setBounds(100,100,400,400);
        usunStudentow.setVisible(false);
        add(usunStudentow);

        UsunPracownikow usunPracownikow = new UsunPracownikow();
        usunPracownikow.setBounds(100,100,400,400);
        usunPracownikow.setVisible(false);
        add(usunPracownikow);

        UsunKurs usunKurs = new UsunKurs();
        usunKurs.setBounds(100,100,400,400);
        usunKurs.setVisible(false);
        add(usunKurs);

        wszyscyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usunStudentow.setVisible(false);
                usunPracownikow.setVisible(false);
                usunKurs.setVisible(false);
                osoby= (ArrayList) Main.osoba;
                Object[][] noweDane = new Object[Main.osoba.size()][1];

                for(int i = 0; i< Main.osoba.size(); i++){
                    if(Main.osoba.get(i) instanceof Student){
                        noweDane[i][0]=new WizytowkaStudent((Student) Main.osoba.get(i));
                    } else if(Main.osoba.get(i) instanceof PracownikBadawczoDydaktyczny){
                        noweDane[i][0]=new WizytowkaPracownikBadawczoDydaktyczny((PracownikBadawczoDydaktyczny) Main.osoba.get(i));
                    } else if (Main.osoba.get(i) instanceof PracownikAdministracyjny) {
                        noweDane[i][0]=new WizytowkaPracownikAdministracyjny(((PracownikAdministracyjny) Main.osoba.get(i)));
                    }
                }
                aktualizujTabele(noweDane);
            }
        });
        studenciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usunStudentow.setVisible(true);
                usunPracownikow.setVisible(false);
                usunKurs.setVisible(false);
                osoby = (ArrayList) main.java.Menu.wyswietlStudentow();

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
                usunStudentow.setVisible(false);
                usunPracownikow.setVisible(true);
                usunKurs.setVisible(false);
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
                usunStudentow.setVisible(false);
                usunPracownikow.setVisible(false);
                usunKurs.setVisible(true);

                Object[][] noweDane = new Object[Main.listaKursow.size()][1];

                for(int i=0; i<Main.listaKursow.size(); i++){
                    noweDane[i][0] = new WizytowkaKurs(Main.listaKursow.get(i));
                }
                aktualizujTabele(noweDane);
            }

        });

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

    class UsunStudentow extends JPanel{
        private JLabel labelNazwisko;
        private JLabel labelImie;
        private JLabel labelId;
        private JLabel labelRok;
        private JTextField txtNazwisko;
        private JTextField txtImie;
        private JTextField txtId;
        private JTextField txtRok;
        private JButton zatwierdz;
        private JButton usunFiltry;
        public UsunStudentow(){
            this.setLayout(new GridLayout(6,2,10,10));
            labelImie=new JLabel("IMIE:");
            setupLabel(labelImie);
            labelNazwisko=new JLabel("NAZWISKO:");
            setupLabel(labelNazwisko);
            labelId = new JLabel("NUMER INDEKSU:");
            setupLabel(labelId);
            labelRok = new JLabel("ROK STUDIOW:");
            setupLabel(labelRok);
            txtNazwisko=new JTextField();
            txtNazwisko.setBorder(new LineBorder(Color.BLACK, 2));
            txtImie=new JTextField();
            txtImie.setBorder(new LineBorder(Color.BLACK, 2));
            txtId=new JTextField();
            txtId.setBorder(new LineBorder(Color.BLACK, 2));
            txtRok=new JTextField();
            txtRok.setBorder(new LineBorder(Color.BLACK, 2));

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
                }
            });

            zatwierdz = new JButton("USUŃ");
            zatwierdz.setBackground(Color.WHITE);
            zatwierdz.setFont(new Font("Arial", Font.PLAIN, 16));
            zatwierdz.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Objects.equals(txtNazwisko.getText(), "") && Objects.equals(txtImie.getText(), "") && Objects.equals(txtId.getText(), "")
                            && Objects.equals(txtRok.getText(), "")){
                        osoby= (ArrayList) Menu.wyswietlStudentow();
                        Object[][] noweDane = new Object[osoby.size()][1];

                        for(int i=0; i<osoby.size(); i++){
                            noweDane[i][0] = new WizytowkaStudent((Student) osoby.get(i));
                        }
                        aktualizujTabele(noweDane);
                    }else{
                        osoby = new ArrayList();
                        Usuwanie.usunStudentaPoNazwisku(Main.osoba, txtNazwisko.getText());
                        Usuwanie.usunStudentaPoImieniu(Main.osoba, txtImie.getText());
                        Usuwanie.usunStudentaPoNrIndeksu(Main.osoba, txtId.getText());
                        if(txtRok.getText().matches("[0-9]+")) {
                            Usuwanie.usunStudentaPoRokuStudiow(Main.osoba, txtRok.getText());
                        }
                        osoby.addAll(Menu.wyswietlStudentow());

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
    class UsunPracownikow extends JPanel{
        private JLabel labelNazwisko;
        private JLabel labelImie;
        private JLabel labelStanowisko;
        private JLabel labelStaz;
        private JTextField txtNazwisko;
        private JTextField txtImie;
        private JTextField txtStanowisko;
        private JTextField txtStaz;
        private JButton zatwierdz;
        private JButton usunFiltry;
        public UsunPracownikow(){
            this.setLayout(new GridLayout(7,2,10,10));
            labelImie=new JLabel("IMIE:");
            setupLabel(labelImie);
            labelNazwisko=new JLabel("NAZWISKO:");
            setupLabel(labelNazwisko);
            labelStanowisko = new JLabel("STANOWISKO:");
            setupLabel(labelStanowisko);
            labelStaz = new JLabel("STAZ PRACY:");
            setupLabel(labelStaz);
            txtNazwisko=new JTextField();
            txtNazwisko.setBorder(new LineBorder(Color.BLACK, 2));
            txtImie=new JTextField();
            txtImie.setBorder(new LineBorder(Color.BLACK, 2));
            txtStanowisko=new JTextField();
            txtStanowisko.setBorder(new LineBorder(Color.BLACK, 2));
            txtStaz=new JTextField();
            txtStaz.setBorder(new LineBorder(Color.BLACK, 2));

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
                }
            });

            zatwierdz = new JButton("USUŃ");
            zatwierdz.setBackground(Color.WHITE);
            zatwierdz.setFont(new Font("Arial", Font.PLAIN, 16));
            zatwierdz.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Objects.equals(txtNazwisko.getText(), "") && Objects.equals(txtImie.getText(), "") && Objects.equals(txtStanowisko.getText(), "")
                            && Objects.equals(txtStaz.getText(), "")){
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
                        Usuwanie.usunPracownikPoNazwisku(Main.osoba, txtNazwisko.getText());
                        Usuwanie.usunPracownikPoImieniu(Main.osoba, txtImie.getText());
                        Usuwanie.usunPracownikPoStanowisku(Main.osoba, txtStanowisko.getText());
                        if(txtStaz.getText().matches("[0-9]+")) {
                            Usuwanie.usunPracownikPoStazuPracy(Main.osoba, txtStaz.getText());
                        }
                        osoby.addAll(Menu.wyswietlPracownikUczelni());

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

    class UsunKurs extends JPanel{
        private JLabel labelNazwa;
        private JLabel labelNazwisko;
        private JLabel labelPkt;
        private JTextField txtNazwa;
        private JTextField txtNazwisko;
        private JTextField txtPkt;
        private JButton zatwierdz;
        private JButton usunFiltry;
        public UsunKurs(){
            this.setLayout(new GridLayout(7,2,10,10));
            labelNazwa=new JLabel("NAZWA KURSU:");
            setupLabel(labelNazwa);
            labelNazwisko=new JLabel("NAZWISKO PROWADZĄCEGO:");
            setupLabel(labelNazwisko);
            labelPkt = new JLabel("ILOSC PUNKTOW ECTS:");
            setupLabel(labelPkt);
            txtNazwisko=new JTextField();
            txtNazwisko.setBorder(new LineBorder(Color.BLACK, 2));
            txtNazwa=new JTextField();
            txtNazwa.setBorder(new LineBorder(Color.BLACK, 2));
            txtPkt=new JTextField();
            txtPkt.setBorder(new LineBorder(Color.BLACK, 2));

            usunFiltry = new JButton("USUN FILTRY");
            usunFiltry.setBackground(Color.WHITE);
            usunFiltry.setFont(new Font("Arial", Font.PLAIN, 16));
            usunFiltry.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    txtNazwa.setText("");
                    txtNazwisko.setText("");
                    txtPkt.setText("");
                }
            });

            zatwierdz = new JButton("USUŃ");
            zatwierdz.setBackground(Color.WHITE);
            zatwierdz.setFont(new Font("Arial", Font.PLAIN, 16));
            zatwierdz.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Objects.equals(txtNazwa.getText(), "") && Objects.equals(txtNazwisko.getText(), "") && Objects.equals(txtPkt.getText(), "")){
                        Object[][] noweDane = new Object[Main.listaKursow.size()][1];

                        for(int i=0; i<Main.listaKursow.size(); i++){
                            noweDane[i][0] = new WizytowkaKurs(Main.listaKursow.get(i));
                        }
                        aktualizujTabele(noweDane);
                    }else{
                        ArrayList<Kursy> kursy = new ArrayList<>();
                        Usuwanie.usunKursPoNazwie(Main.listaKursow, txtNazwa.getText());
                        Usuwanie.usunKursPoNazwiskuProwadzacego(Main.listaKursow, txtNazwisko.getText());
                        Usuwanie.usunKursPoLiczbiePktECTS(Main.listaKursow, txtPkt.getText());
                        kursy.addAll(Menu.wyswietlWszystkieKursy());

                        Object[][] noweDane = new Object[kursy.size()][1];

                        for(int i=0; i<kursy.size(); i++){
                            noweDane[i][0] = new WizytowkaKurs(kursy.get(i));
                        }
                        aktualizujTabele(noweDane);
                    }
                }
            });

            this.add(labelNazwa);
            this.add(txtNazwa);
            this.add(labelNazwisko);
            this.add(txtNazwisko);
            this.add(labelPkt);
            this.add(txtPkt);
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
