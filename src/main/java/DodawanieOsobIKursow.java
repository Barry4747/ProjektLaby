package main.java;

import main.obserwator.NowyKursant;
import main.obserwator.Obserwator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DodawanieOsobIKursow {
    //DODAWANIE OSOB
    public static void dodajStudent(String imie, String nazwisko, String adresEmail, String pesel, String wiek, String plec, String nrIndeksu, String rokStudiow,  boolean erasmus,
                                    boolean pierwszegoSt, boolean drugiegoSt, boolean stStacjonarne, boolean stNiestacjonarne, ArrayList<Kursy> tempList){
        for(Kursy i : tempList){
            i.getKursant().powiadomObserwadorow("Do kursu "+ i.getNazwaKursu()+ " dolaczyl "+ imie+" "+nazwisko);
        }

        Main.osoba.add(new Student(imie, nazwisko, adresEmail, pesel, Byte.parseByte(wiek), plec, nrIndeksu, Integer.parseInt(rokStudiow), tempList, erasmus, pierwszegoSt, drugiegoSt, stStacjonarne, stNiestacjonarne));
    }
    public static void dodajKurs(String nazwa, PracownikBadawczoDydaktyczny prowadzacy, String punkty){

        Main.listaKursow.add(new Kursy(nazwa, (PracownikBadawczoDydaktyczny) prowadzacy, Float.parseFloat(punkty), new NowyKursant()));
        Main.listaKursow.get(Main.listaKursow.size()-1).getKursant().dodajObserwatora(new Obserwator(prowadzacy.getEmail()));
    }
    public static void dodajPracownikBadawczoDydaktyczny(String imie, String nazwisko, String adresEmail, String pesel, String wiek, String plec, String stanowisko, String staz,
                                                         String pensja, String liczbaPublikacji){

        Main.osoba.add(new PracownikBadawczoDydaktyczny(imie, nazwisko, adresEmail, pesel, Byte.parseByte(wiek), plec, stanowisko, Byte.parseByte(staz), Float.parseFloat(pensja), 0, Integer.parseInt(liczbaPublikacji)));

    }
    public static void dodajPracownikAdministracyjny(String imie, String nazwisko, String adresEmail, String pesel, String wiek, String plec, String stanowisko, String staz,
                                                     String pensja, String liczbaNadgodzin){
        Main.osoba.add(new PracownikAdministracyjny(imie, nazwisko, adresEmail, pesel, Byte.parseByte(wiek), plec, stanowisko, Byte.parseByte(staz),  Float.parseFloat(pensja), 0, Integer.parseInt(liczbaNadgodzin)));
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public static boolean isNumericF(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public static boolean isBoolean(String str) {
        if(str.equals("true")||str.equals("false")){
            return true;
        }else{
            return false;
        }
    }
}
