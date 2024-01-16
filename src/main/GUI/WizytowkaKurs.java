package main.GUI;

import main.java.Kursy;
import main.java.Main;
import main.java.Osoba;
import main.java.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class WizytowkaKurs extends JPanel {
    private Kursy kurs;
    public WizytowkaKurs(Kursy kurs){
        this.kurs=kurs;

        setLayout(null);
        setSize(800, 250);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel kursImg = new JLabel();
        kursImg.setBounds(10,10,200,180);
        kursImg.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\barte\\Documents\\GitHub\\ProjektLaby\\src\\resources\\kurs.png").getImage().getScaledInstance(kursImg.getWidth(), kursImg.getHeight(), Image.SCALE_SMOOTH)));;




        JLabel nazwaLabel = new JLabel("<html>"+"Nazwa kursu: "+"<br>"+kurs.getNazwaKursu()+"</html>");
        nazwaLabel.setBounds(250, 10, 290, 50);
        nazwaLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        JLabel prowadzacyLabel = new JLabel("<html>"+"Prowadzący:"+"<br>"+kurs.getProwadzacy().getImie()+" "+kurs.getProwadzacy().getNazwisko()+"</html>");
        prowadzacyLabel.setBounds(250, 100, 250, 50);
        prowadzacyLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        JLabel pktLabel = new JLabel("Punkty ECTS: "+kurs.getPktECTS());
        pktLabel.setBounds(250, 190, 200, 30);
        pktLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        //tabela uczestnikow kursu
        String[] naglowek = {"Imię", "Nazwisko", "Numer indeksu"};

        ArrayList listaUczestnikow = new ArrayList<Student>();

        for(Osoba i : Main.osoba){
            if(i instanceof Student){
                for(Kursy j : ((Student) i).getListaKursow()){
                    if(kurs.getNazwaKursu().equals(j.getNazwaKursu())){
                        listaUczestnikow.add(i);
                    }
                }
            }
        }

        Object[][] dane = new Object[listaUczestnikow.size()][3];

        for(int i=0; i<listaUczestnikow.size(); i++){
            dane[i][0] = ((Student)listaUczestnikow.get(i)).getImie();
            dane[i][1] = ((Student)listaUczestnikow.get(i)).getNazwisko();
            dane[i][2] = ((Student)listaUczestnikow.get(i)).getNrIndeksu();
        }

        DefaultTableModel model = new DefaultTableModel(dane, naglowek);
        JScrollPane scrollPane = new JScrollPane(new JTable(model));
        scrollPane.setBounds(550,10,200,240);


        //dodawanie do panelu
        add(nazwaLabel);
        add(prowadzacyLabel);
        add(pktLabel);
        add(kursImg);
        add(scrollPane);

    }
}
