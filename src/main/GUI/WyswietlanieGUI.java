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

public class WyswietlanieGUI extends JPanel {
    private List wizytowki;
    public DefaultTableModel model;
    public JTable tabela;
    public WyswietlanieGUI(){
        wizytowki = new ArrayList();
        this.setLayout(new BorderLayout());

        for(int i = 0; i< Main.osoba.size(); i++){
            if(Main.osoba.get(i) instanceof Student){
                wizytowki.add(new WizytowkaStudent((Student) Main.osoba.get(i)));
            }else if(Main.osoba.get(i) instanceof PracownikAdministracyjny){
                wizytowki.add(new WizytowkaPracownikAdministracyjny((PracownikAdministracyjny) Main.osoba.get(i)));
            } else if (Main.osoba.get(i) instanceof PracownikBadawczoDydaktyczny) {
                wizytowki.add(new WizytowkaPracownikBadawczoDydaktyczny((PracownikBadawczoDydaktyczny) Main.osoba.get(i)));
            }
        }

        Object[][] dane = new Object[wizytowki.size()][1];
        String[] naglowek = {"UCZELNIA"};

        for(int i=0; i<wizytowki.size(); i++){
            dane[i][0] = wizytowki.get(i);
        }
        model = new DefaultTableModel(dane, naglowek);
        tabela = new JTable(model);
        tabela.getColumnModel().getColumn(0).setCellRenderer(new PanelRenderer());
        tabela.setRowHeight(250);

        JScrollPane wyswietlanieScrollPane = new JScrollPane(tabela, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //wyswietlanieScrollPane.setBounds(800,100,800,900);

        this.add(wyswietlanieScrollPane, BorderLayout.CENTER);
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

}
