package main.GUI;

import main.java.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WizytowkaStudent extends JPanel {
    private Student student;
    public WizytowkaStudent(Student student){
        this.student = student;

        this.setLayout(null);
        this.setSize(800, 250);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel avatar = new JLabel();
        avatar.setBounds(10,10,150,180);
        avatar.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\barte\\Documents\\GitHub\\ProjektLaby\\src\\resources\\avatar.png").getImage().getScaledInstance(avatar.getWidth(), avatar.getHeight(), Image.SCALE_SMOOTH)));;

        JLabel imieINazwiskoLabel = new JLabel("<html>"+student.getImie()+" "+student.getNazwisko()+"<br>"+student.getEmail()+"</html>");
        imieINazwiskoLabel.setBounds(10, 185, 300, 80);
        imieINazwiskoLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel wiekLabel = new JLabel("Wiek: "+student.getWiek());
        wiekLabel.setBounds(200, 10, 100, 30);
        wiekLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel peselLabel = new JLabel("Pesel: "+student.getPESEL());
        peselLabel.setBounds(200, 50, 200, 30);
        peselLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel plecLabel = new JLabel("Plec: "+student.getPlec());
        plecLabel.setBounds(200, 90, 200, 30);
        plecLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel numerIndeksuLabel = new JLabel("Numer indeksu: "+student.getNrIndeksu());
        numerIndeksuLabel.setBounds(200, 130, 200, 30);
        numerIndeksuLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        JLabel rokStudiowLabel = new JLabel("Rok studiow: "+student.getRokStudiow());
        rokStudiowLabel.setBounds(200, 170, 200, 30);
        rokStudiowLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        //tabela infgrmacji dodatkowych
        List dane = new ArrayList();
        if (student.isErasmus()){
            dane.add("erasmus");
        }
        if(student.isIstopnia()){
            dane.add("studia I stopnia");
        }
        if(student.isIIstopnia()){
            dane.add("studia II stopnia");
        }
        if(student.isStStacjonarne()){
            dane.add("studia stacjonarne");
        }
        if(student.isStNiestacjonarne()){
            dane.add("studia niestacjonarne");
        }
        Object[][] data = new Object[dane.size()][1];
        for(int i=0; i<dane.size(); i++){
            data[i][0]=dane.get(i);
        }
        String[] naglowki = {"Informacje dodatkowe"};

        DefaultTableModel model = new DefaultTableModel(data, naglowki);

        JTable informacjeDodatkoweTabela = new JTable(model);
        informacjeDodatkoweTabela.setSize(180,190);

        JScrollPane scrollPaneInformacje = new JScrollPane(informacjeDodatkoweTabela);
        scrollPaneInformacje.setBounds(400, 10, 180,190);


        //tabelka z nazwami kursow
        Object[][] data2 = new Object[student.getListaKursow().size()][1];

        for(int i=0; i<student.getListaKursow().size(); i++){
            data2[i][0]=student.getListaKursow().get(i).getNazwaKursu();
        }
        String[] naglowki2 = {"Kursy"};

        DefaultTableModel model2 = new DefaultTableModel(data2, naglowki2);

        JTable nazwyKursowTabela = new JTable(model2);
        nazwyKursowTabela.setSize(180,190);

        JScrollPane scrollPaneKursy = new JScrollPane(nazwyKursowTabela);
        scrollPaneKursy.setBounds(600, 10, 180,190);



        this.add(avatar);
        this.add(imieINazwiskoLabel);
        this.add(wiekLabel);
        this.add(peselLabel);
        this.add(plecLabel);
        this.add(numerIndeksuLabel);
        this.add(rokStudiowLabel);
        this.add(scrollPaneInformacje);
        this.add(scrollPaneKursy);

    }
}
