import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event implements ActionListener {
    private GUI gui;
    public Event(GUI gui){
        this.gui=gui;
    }
    public void wczytajGUI(){
        gui.rysuj();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==gui.buttonWyjscia){
            gui.ramka.dispose();
        }
        if(e.getSource()==gui.buttonWyswietl){

        }
        if(e.getSource()==gui.buttonDodaj){

        }
        if(e.getSource()==gui.buttonSortuj){

        }
        if(e.getSource()==gui.buttonUsun){

        }
        if(e.getSource()==gui.buttonZapisz){

        }
        if(e.getSource()==gui.buttonDodajOcene){

        }
        if(e.getSource()==gui.buttonPremia){

        }
    }
}
