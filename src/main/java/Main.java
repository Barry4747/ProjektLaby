package main.java;

import main.GUI.Event;
import main.GUI.GUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<Osoba> osoba = new ArrayList<>();
    public static List<Kursy> listaKursow = new ArrayList<>();
    public static void main(String[] args) {
        osoba = Serializacja.wczytajListeOsob();
        listaKursow = Serializacja.wczytajListeKursow();
        for(Kursy i: listaKursow){
            i.getKursant().setListaObserwatorow(Serializacja.wczytajListeObs(i));
        }

        PracownikBadawczoDydaktyczny.stanowiskoPracy.addAll(Arrays.asList("Asystent", "Adiunkt", "Profesor Nadzwyczajny", "Profesor Zwyczajny", "Wykładowca"));
        PracownikAdministracyjny.stanowiskoPracy.addAll(Arrays.asList("Referent", "Specjalista", "Starszy Specjalista"));

        GUI gui = new GUI();
        Event event = new Event(gui);
        event.wczytajGUI();
        Menu.startMenu();

        Serializacja.zapiszListeOsob(osoba);
        Serializacja.zapiszListeKursow(listaKursow);
        for(Kursy i: listaKursow){
            Serializacja.zapiszListeObs(i.getKursant().getListaObserwatorow(), i);
        }
    }


}

