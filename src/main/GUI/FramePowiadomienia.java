package main.GUI;

import main.java.Kursy;
import main.java.Main;
import main.obserwator.Obserwator;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class FramePowiadomienia extends JFrame {

    public FramePowiadomienia(){
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000,910);

        JPanel panelGlowny = new JPanel();
        panelGlowny.setLayout(new BorderLayout());

        JLabel ikonaPowiadomienia = new JLabel();
        ikonaPowiadomienia.setSize(50,50);
        ikonaPowiadomienia.setOpaque(false);
        ikonaPowiadomienia.setBackground(new Color(0,0,0, 0));
        ikonaPowiadomienia.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\barte\\Documents\\GitHub\\ProjektLaby\\src\\resources\\powiadomienieIkona.png").getImage().getScaledInstance(ikonaPowiadomienia.getWidth(), ikonaPowiadomienia.getHeight(), Image.SCALE_SMOOTH)));
        JLabel labelGora = new JLabel("POWIADOMIENIA O NOWYCH UCZESTNIKACH KURSÓW");
        labelGora.setSize(400,50);

        JPanel panelGora = new JPanel();
        panelGora.setLayout(new FlowLayout());
        panelGora.add(ikonaPowiadomienia);
        panelGora.add(labelGora);
        panelGlowny.add(BorderLayout.NORTH, panelGora);


        JPanel panelCentrum = new JPanel();
        panelCentrum.setBorder(new LineBorder(Color.BLACK, 5));
        panelCentrum.setLayout(null);

        JPanel panelDoScrolla = new JPanel();
        panelDoScrolla.setBackground(new Color(240,252,255));
        panelDoScrolla.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        panelCentrum.add(panelDoScrolla);
        panelDoScrolla.setPreferredSize(new Dimension(900, 700));
        panelDoScrolla.setLayout(new FlowLayout(FlowLayout.CENTER));

        JScrollPane scrollPane = new JScrollPane(panelDoScrolla);
        JScrollBar predkosc = scrollPane.getVerticalScrollBar();
        predkosc.setUnitIncrement(20);
        predkosc.setBlockIncrement(40);

        scrollPane.setBackground(new Color(240,252,255));
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(30, 25, 900, 700);

        for (Kursy i : Main.listaKursow)
            for (Obserwator j : i.getKursant().getListaObserwatorow())
                for (String k : j.getPowiadomienia()){
                    PowiadomieniePanel powiadomieniePanel = new PowiadomieniePanel(j,k, scrollPane);
                    panelDoScrolla.add(powiadomieniePanel);
                }

        panelDoScrolla.setPreferredSize(new Dimension(900, panelDoScrolla.getComponentCount() * ((scrollPane.getHeight() / 5) + 10)));


        panelCentrum.add(scrollPane);
        panelGlowny.add(BorderLayout.CENTER, panelCentrum);
        add(panelGlowny);
        setVisible(true);
    }
}

class PowiadomieniePanel extends JPanel{
    private Obserwator obserwator;
    private String powiadomienie;
    public PowiadomieniePanel(Obserwator obserwator, String powiadomienie, JScrollPane scrollPane){
        this.obserwator=obserwator;
        this.powiadomienie=powiadomienie;

        setLayout(null);
        setBackground(new Color(251,244,244));
        setPreferredSize(new Dimension(scrollPane.getWidth() - 25, scrollPane.getHeight()/5));


        JLabel doLabel = new JLabel("DO: "+obserwator.getMail());
        doLabel.setBounds(0,0, scrollPane.getWidth() - 25,60);
        doLabel.setFont(new Font("Arial", Font.BOLD, 16));
        doLabel.setBorder(new LineBorder(Color.BLACK, 1));
        JLabel tresc = new JLabel(powiadomienie);
        tresc.setBounds(0,60,scrollPane.getWidth() - 25,(scrollPane.getHeight()/5)-60);
        tresc.setFont(new Font("Arial", Font.PLAIN, 16));
        tresc.setBorder(new LineBorder(Color.BLACK, 1));
        add(doLabel);
        add(tresc);


    }

}