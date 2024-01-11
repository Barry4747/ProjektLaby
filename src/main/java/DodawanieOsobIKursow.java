package main.java;

import main.obserwator.NowyKursant;
import main.obserwator.Obserwator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DodawanieOsobIKursow {
    //DODAWANIE OSOB
    public static void dodajStudent(Scanner scan){
        String imie, nazwisko, pesel, wiek, plec, nrIndeksu, rokStudiow, nazwaKursu, erasmus, pierwszegoSt, drugiegoSt, stStacjonarne, stNiestacjonarne;
        List<Kursy> tempList = new ArrayList<>();

        System.out.println("Podaj imie");
        imie=scan.nextLine();

        System.out.println("Podaj nazwisko");
        nazwisko=scan.nextLine();

        String adresEmail;
        while (true) {
            System.out.println("Podaj adres Email : ");
            adresEmail = scan.nextLine();
            if (!adresEmail.contains("@") || adresEmail.indexOf("@") == 0 || adresEmail.indexOf("@") == adresEmail.length() - 1) {
                System.out.println("Email nieprawidlowy");
            } else {
                break;
            }
        }

        do {
            System.out.println("Podaj pesel");
            pesel=scan.nextLine();
        }while (!isNumeric(pesel)||pesel.length()!=11);

        do{
            System.out.println("Podaj wiek");
            wiek= scan.nextLine();
        }while(!isNumeric(wiek));

        System.out.println("Podaj plec");
        plec=scan.nextLine();

        do {
            System.out.println("Podaj numer indeksu");
            nrIndeksu=scan.nextLine();
        }while (!isNumeric(nrIndeksu)||nrIndeksu.length()!=6);

        do {
            System.out.println("Podaj rok studiow");
            rokStudiow=scan.nextLine();
        }while (!isNumeric(rokStudiow));

        LoopTemp:
        while(true){
            System.out.println("Podaj nazwe kursu do dodania");
            System.out.println("Wpisz 'koniec' aby zakonczyc dodawanie kursow");
            nazwaKursu= scan.nextLine();
            if (nazwaKursu.equals("koniec")){
                break LoopTemp;
            }else {
                for(int i = 0; i< Main.listaKursow.size(); i++){
                    if(Main.listaKursow.get(i).getNazwaKursu().equals(nazwaKursu)){
                        tempList.add(Main.listaKursow.get(i));
                        System.out.println("Dodano kurs!");
                        break;
                    }
                }
            }
        }

        do {
            System.out.println("Czy erasmus(true|false)");
            erasmus=scan.nextLine();
        }while (!isBoolean(erasmus));

        do {
            System.out.println("Czy studia I stopnia(true|false)");
            pierwszegoSt=scan.nextLine();
        }while (!isBoolean(pierwszegoSt));

        do {
            System.out.println("Czy studia II stopnia(true|false)");
            drugiegoSt=scan.nextLine();
        }while (!isBoolean(drugiegoSt));

        do {
            System.out.println("Czy studia stacjonarne(true|false)");
            stStacjonarne=scan.nextLine();
        }while (!isBoolean(stStacjonarne));

        do {
            System.out.println("Czy studia niestacjonarne(true|false)");
            stNiestacjonarne=scan.nextLine();
        }while (!isBoolean(stNiestacjonarne));

        for(Kursy i : tempList){
            i.getKursant().powiadomObserwadorow("Do kursu "+ i.getNazwaKursu()+ " dolaczyl "+ imie+" "+nazwisko);
        }

        Main.osoba.add(new Student(imie, nazwisko, adresEmail, pesel, Byte.parseByte(wiek), plec, nrIndeksu, Integer.parseInt(rokStudiow), tempList, Boolean.parseBoolean(erasmus), Boolean.parseBoolean(pierwszegoSt), Boolean.parseBoolean(drugiegoSt), Boolean.parseBoolean(stStacjonarne), Boolean.parseBoolean(stNiestacjonarne), new ArrayList<>()));
    }
    public static void dodajKurs(Scanner scan){
        String nazwa, prowadzacy, pktects;
        int indeksProwadzacego;

        System.out.println("Podaj nazwe kursu");
        nazwa=scan.nextLine();

        Looptmp:
        while (true){
            System.out.println("Podaj nazwisko prowadzacego kurs");
            prowadzacy=scan.nextLine();
            for(int i = 0; i< Main.osoba.size(); i++){
                if (Main.osoba.get(i).getNazwisko().equals(prowadzacy))
                    if (Main.osoba.get(i) instanceof PracownikBadawczoDydaktyczny){
                        indeksProwadzacego=i;
                        break Looptmp;
                    }
            }
        }

        do {
            System.out.println("Podaj ilosc punktow ECTS");
            pktects=scan.nextLine();
        }while (!isNumericF(pktects));


        Main.listaKursow.add(new Kursy(nazwa, (PracownikBadawczoDydaktyczny) Main.osoba.get(indeksProwadzacego), Float.parseFloat(pktects), new NowyKursant()));
        Main.listaKursow.get(Main.listaKursow.size()-1).getKursant().dodajObserwatora(new Obserwator(Main.osoba.get(indeksProwadzacego).getEmail()));
    }
    public static void dodajPracownikBadawczoDydaktyczny(Scanner scan){
        String imie, nazwisko, pesel, wiek, plec, stanowisko, staz, pensja, liczbaPublikacji;

        System.out.println("Podaj imie");
        imie=scan.nextLine();

        System.out.println("Podaj nazwisko");
        nazwisko=scan.nextLine();

        String adresEmail;
        while (true) {
            System.out.println("Podaj adres Email : ");
            adresEmail = scan.nextLine();
            if (!adresEmail.contains("@") || adresEmail.indexOf("@") == 0 || adresEmail.indexOf("@") == adresEmail.length() - 1) {
                System.out.println("Email nieprawidlowy");
            } else {
                break;
            }
        }

        do {
            System.out.println("Podaj pesel");
            pesel=scan.nextLine();
        }while (!isNumeric(pesel)||pesel.length()!=11);

        do{
            System.out.println("Podaj wiek");
            wiek= scan.nextLine();
        }while(!isNumeric(wiek));

        System.out.println("Podaj plec");
        plec=scan.nextLine();

        LoopStanowisko:
        while(true) {
            System.out.println("Wybierz numer stanowiska");
            for (int i = 0; i < PracownikBadawczoDydaktyczny.stanowiskoPracy.size(); i++) {
                System.out.println((i + 1) + ". " + PracownikBadawczoDydaktyczny.stanowiskoPracy.get(i));
            }
            stanowisko = scan.nextLine();
            if(isNumeric(stanowisko)){
                int tem = Integer.parseInt(stanowisko);
                if (tem>0&&tem<= PracownikBadawczoDydaktyczny.stanowiskoPracy.size()){
                    stanowisko= PracownikBadawczoDydaktyczny.stanowiskoPracy.get(tem-1);
                    break LoopStanowisko;
                }
            }
        }

        do {
            System.out.println("Podaj staz");
            staz=scan.nextLine();
        }while (!isNumeric(staz));

        do {
            System.out.println("Podaj pensje");
            pensja=scan.nextLine();
        }while (!isNumericF(pensja));

        do {
            System.out.println("Podaj liczbe publikacji");
            liczbaPublikacji=scan.nextLine();
        }while (!isNumeric(liczbaPublikacji));

        Main.osoba.add(new PracownikBadawczoDydaktyczny(imie, nazwisko, adresEmail, pesel, Byte.parseByte(wiek), plec, stanowisko, Byte.parseByte(staz), Float.parseFloat(pensja), 0, Integer.parseInt(liczbaPublikacji)));

    }
    public static void dodajPracownikAdministracyjny(Scanner scan){
        String imie, nazwisko, pesel, wiek, plec, stanowisko, staz, pensja, liczbaNadgodzin;

        System.out.println("Podaj imie");
        imie=scan.nextLine();

        System.out.println("Podaj nazwisko");
        nazwisko=scan.nextLine();

        String adresEmail;
        while (true) {
            System.out.println("Podaj adres Email : ");
            adresEmail = scan.nextLine();
            if (!adresEmail.contains("@") || adresEmail.indexOf("@") == 0 || adresEmail.indexOf("@") == adresEmail.length() - 1) {
                System.out.println("Email nieprawidlowy");
            } else {
                break;
            }
        }

        do {
            System.out.println("Podaj pesel");
            pesel=scan.nextLine();
        }while (!isNumeric(pesel)||pesel.length()!=11);

        do{
            System.out.println("Podaj wiek");
            wiek= scan.nextLine();
        }while(!isNumeric(wiek));

        System.out.println("Podaj plec");
        plec=scan.nextLine();

        LoopStanowisko:
        while(true) {
            System.out.println("Wybierz numer stanowiska");
            for (int i = 0; i < PracownikAdministracyjny.stanowiskoPracy.size(); i++) {
                System.out.println((i + 1) + ". " + PracownikAdministracyjny.stanowiskoPracy.get(i));
            }
            stanowisko = scan.nextLine();
            if(isNumeric(stanowisko)){
                int tem = Integer.parseInt(stanowisko);
                if (tem>0&&tem<= PracownikAdministracyjny.stanowiskoPracy.size()){
                    stanowisko= PracownikAdministracyjny.stanowiskoPracy.get(tem-1);
                    break LoopStanowisko;
                }
            }
        }

        do {
            System.out.println("Podaj staz");
            staz=scan.nextLine();
        }while (!isNumeric(staz));

        do {
            System.out.println("Podaj pensje");
            pensja=scan.nextLine();
        }while (!isNumericF(pensja));

        do {
            System.out.println("Podaj liczbe nadgodzin");
            liczbaNadgodzin=scan.nextLine();
        }while (!isNumeric(liczbaNadgodzin));

        Main.osoba.add(new PracownikBadawczoDydaktyczny(imie, nazwisko, adresEmail, pesel, Byte.parseByte(wiek), plec, stanowisko, Byte.parseByte(staz),  Float.parseFloat(pensja), 0, Integer.parseInt(liczbaNadgodzin)));
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
