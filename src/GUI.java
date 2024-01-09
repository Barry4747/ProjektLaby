import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public JFrame ramka;
    public JPanel panelCentrumGlowny;
    public JPanel panelGoraGlowny;
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

        buttonSetup(buttonWyjscia, 750, 50);
        buttonSetup(buttonWyswietl, 100, 50);
        buttonSetup(buttonDodaj, 100, 150);
        buttonSetup(buttonSortuj, 100, 250);
        buttonSetup(buttonUsun, 100, 350);
        buttonSetup(buttonZapisz, 750, 150);
        buttonSetup(buttonDodajOcene, 100, 450);
        buttonSetup(buttonPremia, 100, 550);

        //panel boczny glowny lewy
        panelGoraGlowny = new JPanel();
        JLabel lebPanelLewy = new JLabel();
        Icon iconPWR = new ImageIcon("pwrIcon.png");
        lebPanelLewy.setIcon(iconPWR);
        panelGoraGlowny.add(lebPanelLewy);
        panelGoraGlowny.setSize(200,700);




        //dodawanie do panelu glownego
        panelGlowny.add(BorderLayout.WEST, panelGoraGlowny);
        panelGlowny.add(BorderLayout.CENTER, panelCentrumGlowny);


        ramka.add(panelGlowny);
        ramka.setSize(1300,700);
        ramka.setVisible(true);
    }
    public void buttonSetup(JButton button, int x, int y){
        button.setBounds(x,y,200,50);
        button.addActionListener(new Event(this));
        button.setBackground(Color.WHITE);
        button.setFont(new Font("Arial", Font.PLAIN, 12));
        panelCentrumGlowny.add(button);
    }
}
