package main.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event{
    private GUI gui;
    public Event(GUI gui){
        this.gui=gui;
    }
    public void wczytajGUI(){
        gui.rysuj();
    }
}
