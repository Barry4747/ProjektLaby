package main.java;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sortowanie {
    public static List poNazwisku(List<Osoba> osoby){
        Comparator<Osoba> comparator = Comparator.comparing(Osoba::getNazwisko);
        Collections.sort(osoby, comparator);
        for(Osoba i : osoby){
            System.out.println(i.getNazwisko()+" "+i.getImie());
        }return osoby;
    }
    public static List poImieniuINazwisku(List<Osoba> osoby){
        Comparator<Osoba> comparator = Comparator.comparing(Osoba::getNazwisko).thenComparing(Osoba::getImie);
        Collections.sort(osoby, comparator);
        for(Osoba i : osoby){
            System.out.println(i.getNazwisko()+" "+i.getImie());
        }return osoby;
    }
    public static List poNazwiskuIWieku(List<Osoba> osoby){
        Comparator<Osoba> comparator = Comparator.comparing(Osoba::getNazwisko).thenComparing(Comparator.comparingInt(Osoba::getWiek).reversed());
        Collections.sort(osoby, comparator);
        for(Osoba i : osoby){
            System.out.println(i.getNazwisko()+" "+i.getImie()+" "+i.getWiek());
        }return osoby;
    }
    public static List kursPoECTS(List<Kursy> listaKursow){
        Comparator<Kursy> comparator = Comparator.comparingDouble(Kursy::getPktECTS);
        Collections.sort(listaKursow, comparator);
        for (Kursy i : listaKursow){
            System.out.println(i.getNazwaKursu() + " " + i.getPktECTS());
        }return listaKursow;
    }
    public static List kursPoNazwisko(List<Kursy> listaKursow){
        Comparator<Kursy> comparator = Comparator.comparing(k -> k.getProwadzacy().getNazwisko());
        Collections.sort(listaKursow, comparator);
        for(Kursy i : listaKursow){
            System.out.println(i.getNazwaKursu() + " " + i.getProwadzacy().getNazwisko());
        }return listaKursow;
    }
}
