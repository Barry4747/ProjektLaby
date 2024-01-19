package main.GUI;

import main.java.Menu;
import main.java.PracownikBadawczoDydaktyczny;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Objects;

import main.java.*;

public class PanelDodawania extends JPanel {
    private JButton studenci;
    private JButton pracownikBadawczo;
    private JButton pracownikAdministracyjny;
    private JButton kurs;
    private String plec;
    private String prowadzacy;

    public PanelDodawania(){
        setLayout(null);

        studenci = new JButton("STUDENCI");
        pracownikBadawczo = new JButton("PRACOWNIK BADAWCZO-DYDAKTYCZNY");
        pracownikAdministracyjny = new JButton("PRACOWNIK ADMINISTRACYJNY");
        kurs = new JButton("KURSY");

        buttonSetup(studenci, 0,0);
        buttonSetup(pracownikBadawczo, 150, 0);
        buttonSetup(pracownikAdministracyjny, 450,0);
        buttonSetup(kurs, 750, 0);
        pracownikBadawczo.setSize(300,50);
        pracownikAdministracyjny.setSize(300,50);

        DodajStudent dodajStudent = new DodajStudent();
        dodajStudent.setBounds(150,100,600,600);
        dodajStudent.setVisible(false);
        dodajStudent.setOpaque(false);
        add(dodajStudent);

        DodajPracownikBadawczo dodajPracownikBadawczo = new DodajPracownikBadawczo();
        dodajPracownikBadawczo.setBounds(150, 100,600,600);
        dodajPracownikBadawczo.setVisible(false);
        dodajPracownikBadawczo.setOpaque(false);
        add(dodajPracownikBadawczo);

        DodajPracownikAdministracyjny dodajPracownikAdministracyjny = new DodajPracownikAdministracyjny();
        dodajPracownikAdministracyjny.setBounds(150,100,600,600);
        dodajPracownikAdministracyjny.setVisible(false);
        dodajPracownikAdministracyjny.setOpaque(false);
        add(dodajPracownikAdministracyjny);

        DodajKurs dodajKurs = new DodajKurs();
        dodajKurs.setBounds(150,250,600,300);
        dodajKurs.setVisible(false);
        dodajKurs.setOpaque(false);
        add(dodajKurs);

        studenci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajStudent.setVisible(true);
                dodajPracownikBadawczo.setVisible(false);
                dodajPracownikAdministracyjny.setVisible(false);
                dodajKurs.setVisible(false);
            }
        });
        pracownikBadawczo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajStudent.setVisible(false);
                dodajPracownikBadawczo.setVisible(true);
                dodajPracownikAdministracyjny.setVisible(false);
                dodajKurs.setVisible(false);
            }
        });

        pracownikAdministracyjny.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajStudent.setVisible(false);
                dodajPracownikBadawczo.setVisible(false);
                dodajPracownikAdministracyjny.setVisible(true);
                dodajKurs.setVisible(false);
            }
        });

        kurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodajStudent.setVisible(false);
                dodajPracownikBadawczo.setVisible(false);
                dodajPracownikAdministracyjny.setVisible(false);
                dodajKurs.setVisible(true);
            }
        });

        add(studenci);
        add(pracownikBadawczo);
        add(pracownikAdministracyjny);
        add(kurs);
    }

    public void buttonSetup(JButton button, int x, int y){
        button.setFont(new Font("Arial", Font.PLAIN, 13));
        button.setBounds(x,y,150,50);
        button.setFocusPainted(false);
        button.setBackground(Color.WHITE);
        this.add(button);
    }

    class DodajStudent extends JPanel{

        public DodajStudent(){
            setLayout(new GridLayout(15,2,10,10));

            JLabel imieL = new JLabel("Podaj imię:");
            setupLabel(imieL);
            JLabel nazwiskoL = new JLabel("Podaj nazwisko:");
            setupLabel(nazwiskoL);
            JLabel emailL = new JLabel("Podaj email:");
            setupLabel(emailL);
            JLabel peselL = new JLabel("Podaj PESEL:");
            setupLabel(peselL);
            JLabel wiekL = new JLabel("Podaj wiek:");
            setupLabel(wiekL);
            JLabel plecL = new JLabel("Podaj płeć");
            setupLabel(plecL);
            JLabel nrIndeksuL = new JLabel("Podaj numer indeksu:");
            setupLabel(nrIndeksuL);
            JLabel rokStudiowL = new JLabel("Podaj rok studiów:");
            setupLabel(rokStudiowL);
            JLabel kursyL = new JLabel("Wybierz kursy:");
            setupLabel(kursyL);
            JLabel erasmusL = new JLabel("Erasmus:");
            setupLabel(erasmusL);
            JLabel IstopniaL = new JLabel("Studia I stopnia:");
            setupLabel(IstopniaL);
            JLabel IIstopniaL = new JLabel("Studia II stopnia:");
            setupLabel(IIstopniaL);
            JLabel stacjonarneL = new JLabel("Studia stacjonarne:");
            setupLabel(stacjonarneL);
            JLabel niestacjonarneL = new JLabel("Studia niestacjonarne:");
            setupLabel(niestacjonarneL);

            JTextField imieT = new JTextField();
            JTextField nazwiskoT = new JTextField();
            JTextField emailT = new JTextField();
            JTextField peselT = new JTextField();
            JTextField wiekT = new JTextField();
            JComboBox<String> plecC = new JComboBox<>(new String[]{"Mężczyzna", "Kobieta"});
            JTextField nrIndeksuT = new JTextField();
            JTextField rokStudiowT = new JTextField();
            //TODO: dodawanie kursów
            JButton kursyB = new JButton("DODAJ KURSY");
            JRadioButton erasmusR = new JRadioButton("erasmus");
            JRadioButton IstopniaR = new JRadioButton("I stopnia");
            JRadioButton IIstopniaR = new JRadioButton("II stopnia");
            JRadioButton stacjonarneR = new JRadioButton("stacjonarne");
            JRadioButton niestacjonarneR = new JRadioButton("niestacjonarne");

            add(imieL); add(imieT);
            add(nazwiskoL); add(nazwiskoT);
            add(emailL); add(emailT);
            add(peselL); add(peselT);
            add(wiekL); add(wiekT);
            add(plecL); add(plecC);
            add(nrIndeksuL); add(nrIndeksuT);
            add(rokStudiowL); add(rokStudiowT);
            add(kursyL); add(kursyB);
            add(erasmusL); add(erasmusR);
            add(IstopniaL); add(IstopniaR);
            add(IIstopniaL); add(IIstopniaR);
            add(stacjonarneL); add(stacjonarneR);
            add(niestacjonarneL); add(niestacjonarneR);

            plecC.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    plec = "mężczyzna";
                    plec= (String) plecC.getSelectedItem();
                }
            });

            JButton dodaj = new JButton("DODAJ");
            dodaj.setBackground(Color.WHITE);
            add(dodaj);


            kursyB.setBackground(Color.WHITE);
            ArrayList listaKursowTemp = new ArrayList();
            kursyB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame ramkaKursow = new JFrame("Wybor kursow");
                    JCheckBox[] checkBoxes = new JCheckBox[Main.listaKursow.size()];
                    JPanel panelNaCheckBoxy = new JPanel();
                    panelNaCheckBoxy.setLayout(new BoxLayout(panelNaCheckBoxy, BoxLayout.Y_AXIS));
                    for(int i=0 ; i<checkBoxes.length; i++){
                        panelNaCheckBoxy.add(checkBoxes[i]=new JCheckBox(Main.listaKursow.get(i).getNazwaKursu()));
                    }
                    JScrollPane scrollPane = new JScrollPane(panelNaCheckBoxy);
                    scrollPane.setBounds(600,600,200,300);
                    ramkaKursow.setSize(200,300);
                    ramkaKursow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    ramkaKursow.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            listaKursowTemp.clear();
                            for(int i=0; i<checkBoxes.length; i++){
                                if(checkBoxes[i].isSelected()){
                                    listaKursowTemp.add(Main.listaKursow.get(i));
                                }
                            }
                            ramkaKursow.dispose();
                        }
                    });
                    ramkaKursow.add(panelNaCheckBoxy);
                    ramkaKursow.setVisible(true);
                }
            });


            dodaj.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DodawanieOsobIKursow.dodajStudent(imieT.getText(), nazwiskoT.getText(), emailT.getText(), peselT.getText(), wiekT.getText(), plec, nrIndeksuT.getText(), rokStudiowT.getText(),
                            erasmusR.isSelected(), IstopniaR.isSelected(), IIstopniaR.isSelected(), stacjonarneR.isSelected(), niestacjonarneR.isSelected(), listaKursowTemp);
                    imieT.setText("");
                    nazwiskoT.setText("");
                    emailT.setText("");
                    peselT.setText("");
                    wiekT.setText("");
                    nrIndeksuT.setText("");
                    rokStudiowT.setText("");
                    erasmusR.setSelected(false);
                    IstopniaR.setSelected(false);
                    IIstopniaR.setSelected(false);
                    stacjonarneR.setSelected(false);
                    niestacjonarneR.setSelected(false);
                    JOptionPane.showMessageDialog(null, "Dodano nową osobę!", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                }
            });

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

    class DodajPracownikBadawczo extends JPanel{
        private String stanowisko;

        public DodajPracownikBadawczo(){
            setLayout(new GridLayout(11,2,10,10));

            JLabel imieL = new JLabel("Podaj imię:");
            setupLabel(imieL);
            JLabel nazwiskoL = new JLabel("Podaj nazwisko:");
            setupLabel(nazwiskoL);
            JLabel emailL = new JLabel("Podaj email:");
            setupLabel(emailL);
            JLabel peselL = new JLabel("Podaj PESEL:");
            setupLabel(peselL);
            JLabel wiekL = new JLabel("Podaj wiek:");
            setupLabel(wiekL);
            JLabel plecL = new JLabel("Podaj płeć");
            setupLabel(plecL);
            JLabel stanowiskoL = new JLabel("Wybierz stanowisko:");
            setupLabel(stanowiskoL);
            JLabel stazL = new JLabel("Podaj staz pracy:");
            setupLabel(stazL);
            JLabel pensjaL = new JLabel("Podaj pensje:");
            setupLabel(pensjaL);
            JLabel liczbaPublikacjiL = new JLabel("Podaj liczbe publikacji:");
            setupLabel(liczbaPublikacjiL);

            String[] dostepneStanowiska = new String[PracownikBadawczoDydaktyczny.stanowiskoPracy.size()];
            for(int i=0; i<PracownikBadawczoDydaktyczny.stanowiskoPracy.size(); i++){
                dostepneStanowiska[i]=PracownikBadawczoDydaktyczny.stanowiskoPracy.get(i);
            }


            JTextField imieT = new JTextField();
            JTextField nazwiskoT = new JTextField();
            JTextField emailT = new JTextField();
            JTextField peselT = new JTextField();
            JTextField wiekT = new JTextField();
            JComboBox<String> plecC = new JComboBox<>(new String[]{"Mężczyzna", "Kobieta"});
            JComboBox<String> stanowiskoC = new JComboBox(dostepneStanowiska);
            JTextField stazT = new JTextField();
            JTextField pensjaT = new JTextField();
            JTextField liczbaPublikacjiT = new JTextField();


            add(imieL); add(imieT);
            add(nazwiskoL); add(nazwiskoT);
            add(emailL); add(emailT);
            add(peselL); add(peselT);
            add(wiekL); add(wiekT);
            add(plecL); add(plecC);
            add(stanowiskoL); add(stanowiskoC);
            add(stazL); add(stazT);
            add(pensjaL); add(pensjaT);
            add(liczbaPublikacjiL); add(liczbaPublikacjiT);

            plecC.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    plec = "mężczyzna";
                    plec = (String) plecC.getSelectedItem();
                }
            });

            stanowiskoC.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stanowisko = (String) stanowiskoC.getSelectedItem();
                }
            });

            JButton dodaj = new JButton("DODAJ");
            dodaj.setBackground(Color.WHITE);
            add(dodaj);
            dodaj.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DodawanieOsobIKursow.dodajPracownikBadawczoDydaktyczny(imieT.getText(), nazwiskoT.getText(), emailT.getText(), peselT.getText(), wiekT.getText(), plec,
                            stanowisko, stazT.getText(), pensjaT.getText(), liczbaPublikacjiT.getText());
                    imieT.setText("");
                    nazwiskoT.setText("");
                    emailT.setText("");
                    peselT.setText("");
                    wiekT.setText("");
                    stazT.setText("");
                    pensjaT.setText("");
                    liczbaPublikacjiT.setText("");
                    JOptionPane.showMessageDialog(null, "Dodano nową osobę!", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                }
            });
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

    class DodajPracownikAdministracyjny extends JPanel{
        private String stanowisko;

        public DodajPracownikAdministracyjny(){
            setLayout(new GridLayout(11,2,10,10));

            JLabel imieL = new JLabel("Podaj imię:");
            setupLabel(imieL);
            JLabel nazwiskoL = new JLabel("Podaj nazwisko:");
            setupLabel(nazwiskoL);
            JLabel emailL = new JLabel("Podaj email:");
            setupLabel(emailL);
            JLabel peselL = new JLabel("Podaj PESEL:");
            setupLabel(peselL);
            JLabel wiekL = new JLabel("Podaj wiek:");
            setupLabel(wiekL);
            JLabel plecL = new JLabel("Podaj płeć");
            setupLabel(plecL);
            JLabel stanowiskoL = new JLabel("Wybierz stanowisko:");
            setupLabel(stanowiskoL);
            JLabel stazL = new JLabel("Podaj staz pracy:");
            setupLabel(stazL);
            JLabel pensjaL = new JLabel("Podaj pensje:");
            setupLabel(pensjaL);
            JLabel liczbaNadgodzinL = new JLabel("Podaj liczbe nadgodzin:");
            setupLabel(liczbaNadgodzinL);

            String[] dostepneStanowiska = new String[PracownikAdministracyjny.stanowiskoPracy.size()];
            for(int i=0; i<PracownikAdministracyjny.stanowiskoPracy.size(); i++){
                dostepneStanowiska[i]=PracownikAdministracyjny.stanowiskoPracy.get(i);
            }


            JTextField imieT = new JTextField();
            JTextField nazwiskoT = new JTextField();
            JTextField emailT = new JTextField();
            JTextField peselT = new JTextField();
            JTextField wiekT = new JTextField();
            JComboBox<String> plecC = new JComboBox<>(new String[]{"Mężczyzna", "Kobieta"});
            JComboBox<String> stanowiskoC = new JComboBox(dostepneStanowiska);
            JTextField stazT = new JTextField();
            JTextField pensjaT = new JTextField();
            JTextField liczbaNadgodzinT = new JTextField();


            add(imieL); add(imieT);
            add(nazwiskoL); add(nazwiskoT);
            add(emailL); add(emailT);
            add(peselL); add(peselT);
            add(wiekL); add(wiekT);
            add(plecL); add(plecC);
            add(stanowiskoL); add(stanowiskoC);
            add(stazL); add(stazT);
            add(pensjaL); add(pensjaT);
            add(liczbaNadgodzinL); add(liczbaNadgodzinT);

            plecC.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    plec = "mężczyzna";
                    plec = (String) plecC.getSelectedItem();
                }
            });

            stanowiskoC.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stanowisko = (String) stanowiskoC.getSelectedItem();
                }
            });

            JButton dodaj = new JButton("DODAJ");
            dodaj.setBackground(Color.WHITE);
            add(dodaj);
            dodaj.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DodawanieOsobIKursow.dodajPracownikAdministracyjny(imieT.getText(), nazwiskoT.getText(), emailT.getText(), peselT.getText(), wiekT.getText(), plec,
                            stanowisko, stazT.getText(), pensjaT.getText(), liczbaNadgodzinT.getText());
                    imieT.setText("");
                    nazwiskoT.setText("");
                    emailT.setText("");
                    peselT.setText("");
                    wiekT.setText("");
                    stazT.setText("");
                    pensjaT.setText("");
                    liczbaNadgodzinT.setText("");
                    JOptionPane.showMessageDialog(null, "Dodano nową osobę!", "Informacja", JOptionPane.INFORMATION_MESSAGE);

                }
            });
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
    class DodajKurs extends JPanel{

        public DodajKurs(){
            setLayout(new GridLayout(4,2,10,10));

            JLabel nazwaL = new JLabel("Podaj nazwe kursu: ");
            setupLabel(nazwaL);
            JLabel prowadzacyL = new JLabel("Wybierz prowadzącego: ");
            setupLabel(prowadzacyL);
            JLabel punktyL = new JLabel("Podaj liczbę punktów ECTS:");
            setupLabel(punktyL);

            ArrayList<PracownikBadawczoDydaktyczny> listaPracownikow = new ArrayList<>();
            ArrayList<String> listaImion = new ArrayList<>();

            for(Object i : Menu.wyswietlPracownikUczelni()){
                if(i instanceof PracownikBadawczoDydaktyczny){
                    listaPracownikow.add((PracownikBadawczoDydaktyczny) i);
                }
            }

            String[] wybory = new String[listaPracownikow.size()];

            for(int i=0; i<listaPracownikow.size(); i++){
                wybory[i] = listaPracownikow.get(i).getImie()+" "+listaPracownikow.get(i).getNazwisko();
            }

            JTextField nazwaT = new JTextField();
            JComboBox<String> prowadzacyC = new JComboBox<>(wybory);
            JTextField punktyT = new JTextField();

            add(nazwaL); add(nazwaT);
            add(prowadzacyL); add(prowadzacyC);
            add(punktyL); add(punktyT);

            prowadzacyC.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    prowadzacy = (String) prowadzacyC.getSelectedItem();
                }
            });
            JButton dodaj = new JButton("DODAJ");
            dodaj.setBackground(Color.WHITE);
            add(dodaj);
            dodaj.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PracownikBadawczoDydaktyczny temp= listaPracownikow.get(0);
                    for(int i=0; i<listaPracownikow.size(); i++){
                        if(Objects.equals(prowadzacy, listaPracownikow.get(i).getImie() + " " + listaPracownikow.get(i).getNazwisko())){
                            temp=listaPracownikow.get(i);
                        }
                    }
                    DodawanieOsobIKursow.dodajKurs(nazwaT.getText(), temp, punktyT.getText());
                    nazwaT.setText("");
                    punktyT.setText("");
                    JOptionPane.showMessageDialog(null, "Dodano nowy kurs!", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                }
            });

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
