package main.java;

import main.strategiaPremia.PremiaZaNadgodziny;
import main.strategiaPremia.PremiaZaPublikacje;
import main.strategiaPremia.PremiaZaStaz;
import main.strategiaPremia.StrategiaPremia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static boolean czyZnaleziono;
    private static List lista = new ArrayList();

    public static void startMenu(){
        menu();
        Scanner scan = new Scanner(System.in);
        Loop:
        while(true){
            String wybor = scan.nextLine();
            switch (wybor) {
                case "1":
                    opcjaWyswietl(wybor, scan);
                    break;
                case "2":
                    opcjaDodaj(wybor, scan);
                    break;
                case "3":
                    sortowanie(wybor, scan);
                    break;
                case "4":
                    usuwanie(wybor, scan);
                    break;
                case "5":
                    Serializacja.zapiszListeKursow(Main.listaKursow);
                    Serializacja.zapiszListeOsob(Main.osoba);
                    for(Kursy i: Main.listaKursow){
                        Serializacja.zapiszListeObs(i.getKursant().getListaObserwatorow(), i);
                    }
                    System.out.println("Zapisano zmiany");
                    break;
                case "7":
                    premia();
                    break;
                case "8":
                    usunPowtorki();
                    break;
                case "9":
                    break Loop;
                default:
                    System.out.println("Nieprawidlowa opcja!");
                    break;
            }
            menu();
        }
    }
    public static void opcjaWyswietl(String wybor, Scanner scan){
        Loop1:
        while (true) {
            menuWyswietl();
            wybor = scan.nextLine();
            switch (wybor) {
                case "1":
                    wyswietlWszystko();
                    wyswietlWszystkieKursy();

                    break;
                case "2":
                    wyswietlStudenci(wybor, scan);
                    break;
                case "3":
                    wyswietlKursy(wybor, scan);
                    break;
                case "4":
                    wyswietlPracownikow(wybor, scan);
                    break;
                case "5":
                    break Loop1;
                default:
                    System.out.println("Nieprawidlowa opcja!");
                    break;
            }
        }
    }

    public static void wyswietlStudenci(String wybor, Scanner scan){
        LoopStudenci:
        while (true) {
            menuWyswietlStudenci();
            wybor = scan.nextLine();
            switch (wybor) {
                case "1":
                    wyswietlStudentow();
                    break;
                case "2":
                    System.out.println("Podaj nazwisko");
                    wybor = scan.nextLine();
                    wyszukajPoNazwiskoStudent(wybor);
                    break;
                case "3":
                    System.out.println("Podaj imie");
                    wybor = scan.nextLine();
                    wyszukajPoImieStudent(wybor);
                    break;
                case "4":
                    System.out.println("Podaj nr indeksu");
                    wybor = scan.nextLine();
                    wyszukajPoNrIndeksu(wybor);
                    break;
                case "5":
                    System.out.println("Podaj rok studiow");
                    wybor = scan.nextLine();
                    if (isNumeric(wybor)) {
                        wyszukajPoRokStudiow(Integer.parseInt(wybor));
                    }else{
                        System.out.println("Podaj liczbe calkowita");
                    }
                    break;
                case "6":
                    System.out.println("Podaj nazwe kursu");
                    wybor = scan.nextLine();
                    wyszukajPoNazwaKursuStudent(wybor);
                    break;
                case "7":
                    break LoopStudenci;
                default:
                    System.out.println("Nieprawidlowa opcja!");
                    break;
            }
        }
    }
    public static void wyswietlKursy(String wybor, Scanner scan){
        LoopKursy:
        while (true){
            menuWyswietlKursy();
            wybor=scan.nextLine();
            switch (wybor){
                case "1":
                    wyswietlWszystkieKursy();
                    break;
                case "2":
                    System.out.println("Podaj nazwe kursu");
                    wybor=scan.nextLine();
                    wyszukajPoNazwaKursu(wybor);
                    break;
                case "3":
                    System.out.println("Podaj nazwisko prowadzacego");
                    wybor=scan.nextLine();
                    wyszukajPoNazwiskuProwadzacego(wybor);
                    break;
                case "4":
                    System.out.println("Podaj liczbe punktow ECTS");
                    wybor=scan.nextLine();
                    if(isNumericF(wybor)) {
                        wyszukajPoPktECTS(Float.parseFloat(wybor));
                    }else{
                        System.out.println("Musi byc liczba");
                    }
                case "5":
                    break LoopKursy;
                default:
                    System.out.println("Nieprawidlowa opcja!");
                    break;
            }

        }
    }
    public static void wyswietlPracownikow(String wybor, Scanner scan){
        LoopPracownicy:
        while(true){
            menuWyswietlPracownikow();
            wybor=scan.nextLine();
            switch (wybor){
                case "1":
                    wyswietlPracownikUczelni();
                    break;
                case "2":
                    System.out.println("Podaj nazwisko");
                    wybor=scan.nextLine();
                    wyszukajPoNazwiskoPracownik(wybor);
                    break;
                case "3":
                    System.out.println("Podaj imie");
                    wybor=scan.nextLine();
                    wyszukajPoImiePracownik(wybor);
                    break;
                case "4":
                    System.out.println("Podaj stanowisko");
                    wybor=scan.nextLine();
                    wyszukajPoStanowisko(wybor);
                    break;
                case "5":
                    System.out.println("Podaj staz pracy");
                    wybor = scan.nextLine();
                    if(isNumeric(wybor)){
                        wyszukajPoStazPracy(Byte.parseByte(wybor));
                    }else{
                        System.out.println("Musi byc liczba calkowita");
                    }
                    break;
                case "6":
                    System.out.println("Podaj liczbe nadgodzin");
                    wybor=scan.nextLine();
                    if(isNumeric(wybor)){
                        wyszukajPoLiczbaNadgodzin(Integer.parseInt(wybor));
                    }else{
                        System.out.println("Musi byc liczba calkowita");
                    }
                    break;
                case "7":
                    System.out.println("Podaj pensje");
                    wybor=scan.nextLine();
                    if(isNumericF(wybor)){
                        wyszukajPoPensja(Float.parseFloat(wybor));
                    }
                case "8":
                    break LoopPracownicy;
                default:
                    System.out.println("Nieprawidlowa opcja!");
                    break;
            }
        }
    }
    public static void opcjaDodaj(String wybor, Scanner scan){
//        LoopAdding:
//        while (true){
//            menuDodaj();
//            wybor=scan.nextLine();
//            switch (wybor){
//                case "1":
//                    DodawanieOsobIKursow.dodajStudent(scan);
//                    break;
//                case "2":
//                    DodawanieOsobIKursow.dodajKurs(scan);
//                    break;
//                case "3":
//                    DodawanieOsobIKursow.dodajPracownikBadawczoDydaktyczny(scan);
//                    break;
//                case "4":
//                    DodawanieOsobIKursow.dodajPracownikAdministracyjny(scan);
//                    break;
//                case "5":
//                    break LoopAdding;
//                default:
//                    System.out.println("Nieprawidlowa opcja");
//                    break;
//            }
//
//        }
    }

    public static void sortowanie(String wybor, Scanner scan){
        LoopSort:
        while (true){
            menuSortuj();
            wybor=scan.nextLine();
            switch (wybor){
                case "1":
                    Sortowanie.poNazwisku(Main.osoba);
                    break;
                case "2":
                    Sortowanie.poImieniuINazwisku(Main.osoba);
                    break;
                case "3":
                    Sortowanie.poNazwiskuIWieku(Main.osoba);
                    break;
                case "4":
                    Sortowanie.kursPoNazwisko(Main.listaKursow);
                    break;
                case "5":
                    Sortowanie.kursPoECTS(Main.listaKursow);
                    break;
                case "6":
                    break LoopSort;
                default:
                    System.out.println("Nieprawidlowa opcja");
                    break;
            }

        }
    }
    public static void usuwanie(String wybor, Scanner scan){
        LoopUsuwanie:
        while (true){
            menuUsun();
            wybor=scan.nextLine();
            switch (wybor){
                case "1":
                    usunPracownik(wybor, scan);
                    break;
                case "2":
                    usuwanieStudent(wybor, scan);
                    break;
                case "3":
                    usuwanieKurs(wybor, scan);
                    break;
                case "4":
                    break LoopUsuwanie;
                default:
                    System.out.println("Nieprawidlowa opcja");
                    break;
            }
        }
    }
    public static void usunPracownik(String wybor, Scanner scan){
        LoopUsuwanie:
        while (true){
            menuUsunPracownik();
            wybor=scan.nextLine();
            switch (wybor){
                case "1":
                    Usuwanie.usunPracownikPoNazwisku(Main.osoba, "");
                    break;
                case "2":
                    Usuwanie.usunPracownikPoImieniu(Main.osoba, "");
                    break;
                case "3":
                    Usuwanie.usunPracownikPoStazuPracy(Main.osoba, "");
                    break;
                case "4":
                    Usuwanie.usunPracownikPoStanowisku(Main.osoba, "");
                    break;
                case "5":
                    break LoopUsuwanie;
                default:
                    System.out.println("Nieprawidlowa opcja");
                    break;
            }
        }
    }
    public static void usuwanieStudent(String wybor, Scanner scan){
        LoopUsuwanie:
        while (true){
            menuUsunStudent();
            wybor=scan.nextLine();
            switch (wybor){
                case "1":
                    Usuwanie.usunStudentaPoNazwisku(Main.osoba, "");
                    break;
                case "2":
                    Usuwanie.usunStudentaPoImieniu(Main.osoba, "");
                    break;
                case "3":
                    Usuwanie.usunStudentaPoNrIndeksu(Main.osoba, "");
                    break;
                case "4":
                    Usuwanie.usunStudentaPoRokuStudiow(Main.osoba, "");
                    break;
                case "5":
                    break LoopUsuwanie;
                default:
                    System.out.println("Nieprawidlowa opcja");
                    break;
            }
        }
    }
    public static void usuwanieKurs(String wybor, Scanner scan){
        LoopUsuwanie:
        while (true){
            menuUsunKurs();
            wybor=scan.nextLine();
            switch (wybor){
                case "1":
                    Usuwanie.usunKursPoNazwie(Main.listaKursow, "");
                    break;
                case "2":
                    Usuwanie.usunKursPoNazwiskuProwadzacego(Main.listaKursow, "");
                    break;
                case "3":
                    Usuwanie.usunKursPoLiczbiePktECTS(Main.listaKursow, "");
                    break;
                case "4":
                    break LoopUsuwanie;
                default:
                    System.out.println("Nieprawidlowa opcja");
                    break;
            }
        }
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
    public static void menu(){
        System.out.println("MENU");
        System.out.println("1. Wyswietl");
        System.out.println("2. Dodaj");
        System.out.println("3. Sortuj");
        System.out.println("4. Usun");
        System.out.println("5. Zapisz zmiany");
        System.out.println("7. Licz premie (strategia)");
        System.out.println("8. Usun powtorki");
        System.out.println("9. Wyjscie");
    }
    public static void menuWyswietl(){
        System.out.println("WYSWIETL");
        System.out.println("1. wszystko");
        System.out.println("2. studenci");
        System.out.println("3. kursy");
        System.out.println("4. pracownicy uczelni");
        System.out.println("5. powrot");
    }
    //albo nazwiska, albo imienia, albo nr indeksu, albo roku studiów, albo nazwy kursu
    public static void menuWyswietlStudenci(){
        System.out.println("STUDENCI");
        System.out.println("1. wszyscy");
        System.out.println("2. po nazwisko");
        System.out.println("3. po imieniu");
        System.out.println("4. po nr indeksu");
        System.out.println("5. po roku studiow");
        System.out.println("6. po nazwie kursu");
        System.out.println("7. powrot");
    }
    public static void menuWyswietlKursy(){
        System.out.println("KURSY");
        System.out.println("1. wszystkie");
        System.out.println("2. po nazwie kursu");
        System.out.println("3. po nazwisku prowadzacego");
        System.out.println("4. po ilosci punktow ECTS");
        System.out.println("5. powrot");
    }
    public static void menuWyswietlPracownikow(){
        System.out.println("PRACOWNICY");
        System.out.println("1. wszyscy");
        System.out.println("2. po nazwisku");
        System.out.println("3. po imieniu");
        System.out.println("4. po stanowisku");
        System.out.println("5. po stazu pracy");
        System.out.println("6. po liczbie nadgodzin");
        System.out.println("7. po pensji");
        System.out.println("8. powrot");
    }
    public static void menuDodaj(){
        System.out.println("DODAJ");
        System.out.println("1. main.java.Student");
        System.out.println("2. Kurs");
        System.out.println("3. Pracownik Badawczo-Dydaktyczny");
        System.out.println("4. Pracownik Administracyjny");
        System.out.println("5. powrot");
    }

    public static void menuSortuj(){
        System.out.println("SORTUJ");
        System.out.println("1. Nazwisko");
        System.out.println("2. Nazwisko i imie");
        System.out.println("3. Nazwisko i wiek");
        System.out.println("4. Kurs po nazwisku prowadzacego");
        System.out.println("5. Kurs po ilosci punktow ECTS");
        System.out.println("6. powrot");
    }

    public static void menuUsun(){
        System.out.println("USUN");
        System.out.println("1. Pracownik");
        System.out.println("2. main.java.Student");
        System.out.println("3. Kurs");
        System.out.println("4. powrot");
    }
    public static void menuUsunPracownik(){
        System.out.println("USUN");
        System.out.println("1. Po nazwisku");
        System.out.println("2. Po imieniu");
        System.out.println("3. Po stazu pracy");
        System.out.println("4. Po stanowisku");
        System.out.println("5. powrot");
    }
    public static void menuUsunStudent(){
        System.out.println("USUN");
        System.out.println("1. Po nazwisku");
        System.out.println("2. Po imieniu");
        System.out.println("3. Po nr indeksu");
        System.out.println("4. Po roku studiow");
        System.out.println("5. powrot");
    }
    public static void menuUsunKurs(){
        System.out.println("USUN");
        System.out.println("1. Po nazwie kursu");
        System.out.println("2. Po nazwiku prowadzacego");
        System.out.println("3. Po pkt ECTS");
        System.out.println("4. powrot");
    }

    public static List wyswietlWszystko(){
        lista = new ArrayList();
        if(Main.osoba.isEmpty()){
            System.out.println("Nie ma osob na liscie!");
            return new ArrayList();
        }
        for(int i=0; i< Main.osoba.size(); i++) {
            Main.osoba.get(i).wyswietlInfo();
            lista.add(Main.osoba.get(i));
        }return lista;
    }
    public static List wyswietlStudentow(){
        czyZnaleziono = false;
        lista = new ArrayList();
        for(int i=0; i<Main.osoba.size(); i++)
            if(Main.osoba.get(i) instanceof Student) {
                Main.osoba.get(i).wyswietlInfo();
                czyZnaleziono=true;
                lista.add(Main.osoba.get(i));
            }
        if (!czyZnaleziono){
            System.out.println("Nie znaleziono studentow!");
            return new ArrayList();
        }return lista;
    }
    public static List wyswietlWszystkieKursy(){
        if(Main.listaKursow.isEmpty()){
            System.out.println("Lista kursow jest pusta!");
        }
        for(int i=0; i<Main.listaKursow.size(); i++){
            Main.listaKursow.get(i).wyswietlInfo();
        }return Main.listaKursow;
    }
    public static List wyswietlPracownikUczelni(){
        czyZnaleziono=false;
        lista = new ArrayList();
        for(int i=0; i<Main.osoba.size(); i++)
            if (Main.osoba.get(i) instanceof PracownikUczelni) {
                Main.osoba.get(i).wyswietlInfo();
                lista.add(Main.osoba.get(i));
                czyZnaleziono=true;
            }
        if(!czyZnaleziono){
            System.out.println("Nie znaleziono pracowniko!");
            return new ArrayList();
        }return lista;
    }

    public static List wyszukajPoImieStudent(String imie){
        czyZnaleziono=false;
        lista = new ArrayList();
        for(int i=0; i<Main.osoba.size(); i++)
            if(Main.osoba.get(i) instanceof Student) {
                if (Main.osoba.get(i).getImie().equals(imie)) {
                    Main.osoba.get(i).wyswietlInfo();
                    lista.add(Main.osoba.get(i));
                    czyZnaleziono = true;
                }
            }
        if(!czyZnaleziono){
            System.out.println("Nie znaleziono takiej osoby!");
            return new ArrayList();
        }return lista;
    }
    public static List wyszukajPoImiePracownik(String imie){
        czyZnaleziono=false;
        lista = new ArrayList();
        for(int i=0; i<Main.osoba.size(); i++)
            if(Main.osoba.get(i) instanceof PracownikUczelni) {
                if (Main.osoba.get(i).getImie().equals(imie)) {
                    Main.osoba.get(i).wyswietlInfo();
                    lista.add(Main.osoba.get(i));
                    czyZnaleziono = true;
                }
            }
        if(!czyZnaleziono){
            System.out.println("Nie znaleziono takiej osoby!");
            return new ArrayList<>();
        }return lista;
    }
    public static List wyszukajPoNazwiskoStudent(String nazwisko){
        czyZnaleziono=false;
        lista= new ArrayList();
        for(int i=0; i<Main.osoba.size(); i++)
            if(Main.osoba.get(i) instanceof Student) {
                if (Main.osoba.get(i).getNazwisko().equals(nazwisko)) {
                    Main.osoba.get(i).wyswietlInfo();
                    lista.add(Main.osoba.get(i));
                    czyZnaleziono = true;
                }
            }
        if(!czyZnaleziono){
            System.out.println("Nie znaleziono takiej osoby!");
            return new ArrayList();
        }return lista;
    }
    public static List wyszukajPoNazwiskoPracownik(String nazwisko){
        czyZnaleziono=false;
        lista = new ArrayList();
        for(int i=0; i<Main.osoba.size(); i++)
            if(Main.osoba.get(i) instanceof PracownikUczelni) {
                if (Main.osoba.get(i).getNazwisko().equals(nazwisko)) {
                    Main.osoba.get(i).wyswietlInfo();
                    lista.add(Main.osoba.get(i));
                    czyZnaleziono = true;
                }
            }
        if(!czyZnaleziono){
            System.out.println("Nie znaleziono takiej osoby!");
            return new ArrayList();
        }return lista;
    }

    //wyszukiwanie po polach z main.java.Student

    public static List wyszukajPoRokStudiow(int rok){
        czyZnaleziono=false;
        lista = new ArrayList();
        for(int i=0; i<Main.osoba.size(); i++)
            if (Main.osoba.get(i) instanceof Student)
                if (((Student) Main.osoba.get(i)).getRokStudiow()==rok) {
                    Main.osoba.get(i).wyswietlInfo();
                    lista.add(Main.osoba.get(i));
                    czyZnaleziono=true;
                }
        if(!czyZnaleziono){
            System.out.println("Nie znaleziono takiej osoby!");
            return new ArrayList();
        }return lista;
    }
    public static List wyszukajPoNrIndeksu(String numer){
        czyZnaleziono=false;
        lista = new ArrayList();
        for(int i=0; i<Main.osoba.size(); i++)
            if (Main.osoba.get(i) instanceof Student)
                if (((Student) Main.osoba.get(i)).getNrIndeksu().equals(numer)) {
                    Main.osoba.get(i).wyswietlInfo();
                    lista.add(Main.osoba.get(i));
                    czyZnaleziono=true;
                }
        if(!czyZnaleziono){
            System.out.println("Nie znaleziono takiej osoby!");
            return new ArrayList();
        }return lista;
    }
    public static List wyszukajPoNazwaKursuStudent(String nazwa){
        czyZnaleziono=false;
        lista = new ArrayList();
        for(int i=0; i<Main.osoba.size(); i++){
            if(Main.osoba.get(i) instanceof Student){
                for(int j = 0; j<((Student) Main.osoba.get(i)).getListaKursow().size(); j++){
                    if(((Student) Main.osoba.get(i)).getListaKursow().get(j).getNazwaKursu().equals(nazwa)){
                        Main.osoba.get(i).wyswietlInfo();
                        lista.add(Main.osoba.get(i));
                        czyZnaleziono=true;
                    }
                }
            }
        }
        if(!czyZnaleziono){
            System.out.println("Nie znaleziono takiej osoby!");
            return new ArrayList();
        }return lista;
    }
    //wyszukiwanie po polach dla main.java.Kursy
    public static List wyszukajPoNazwaKursu(String nazwa){
        czyZnaleziono=false;
        lista = new ArrayList();
        for(int i=0; i<Main.listaKursow.size(); i++){
            if(Main.listaKursow.get(i).getNazwaKursu().equals(nazwa)){
                Main.listaKursow.get(i).wyswietlInfo();
                lista.add(Main.listaKursow.get(i));
                czyZnaleziono=true;
            }
        }
        if (!czyZnaleziono){
            System.out.println("Nie znaleziono takiego kursu!");
            return new ArrayList();
        }return lista;
    }
    public static List wyszukajPoNazwiskuProwadzacego(String nazwisko){
        czyZnaleziono=false;
        lista = new ArrayList();
        for(int i=0; i<Main.listaKursow.size(); i++){
            if (Main.listaKursow.get(i).getProwadzacy().getNazwisko().equals(nazwisko)){
                Main.listaKursow.get(i).wyswietlInfo();
                lista.add(Main.listaKursow.get(i));
                czyZnaleziono=true;
            }
        }
        if (!czyZnaleziono){
            System.out.println("Nie znaleziono takiego kursu!");
            return new ArrayList();
        }return lista;
    }
    public static List wyszukajPoPktECTS(float punkty){
        czyZnaleziono=false;
        lista = new ArrayList();
        for(int i=0; i<Main.listaKursow.size(); i++){
            if (Main.listaKursow.get(i).getPktECTS()==punkty){
                Main.listaKursow.get(i).wyswietlInfo();
                lista.add(Main.listaKursow.get(i));
                czyZnaleziono=true;
            }
        }
        if (!czyZnaleziono){
            System.out.println("Nie znaleziono takiego kursu!");
            return new ArrayList();
        }return lista;
    }


    //wyszukiwanie po polach dla main.java.PracownikUczelni

    public static List wyszukajPoStanowisko(String stanowisko){
        czyZnaleziono=false;
        lista = new ArrayList();
        for(int i=0; i<Main.osoba.size(); i++){
            if(Main.osoba.get(i) instanceof PracownikUczelni){
                if(((PracownikUczelni)Main.osoba.get(i)).getStanowisko().equals(stanowisko)){
                    Main.osoba.get(i).wyswietlInfo();
                    lista.add(Main.osoba.get(i));
                    czyZnaleziono=true;
                }
            }
        }
        if(!czyZnaleziono){
            System.out.println("Nie znaleziono takiej osoby!");
            return new ArrayList<>();
        }return lista;
    }
    public static List wyszukajPoStazPracy(byte staz){
        czyZnaleziono=false;
        lista = new ArrayList();
        for(int i=0; i< Main.osoba.size(); i++)
            if(Main.osoba.get(i) instanceof PracownikUczelni)
                if(((PracownikUczelni) Main.osoba.get(i)).getStazPracy()==staz) {
                    Main.osoba.get(i).wyswietlInfo();
                    lista.add(Main.osoba.get(i));
                    czyZnaleziono=true;
                }
        if(!czyZnaleziono){
            System.out.println("Nie znaleziono takiej osoby!");
            return new ArrayList<>();
        }return lista;
    }
    public static List wyszukajPoLiczbaNadgodzin(int liczbaNadgodzin){
        czyZnaleziono=false;
        lista = new ArrayList();
        for(int i=0; i<Main.osoba.size(); i++){
            if(Main.osoba.get(i) instanceof PracownikAdministracyjny){
                if(((PracownikAdministracyjny) Main.osoba.get(i)).getLiczbaNadgodzin()==liczbaNadgodzin){
                    Main.osoba.get(i).wyswietlInfo();
                    lista.add(Main.osoba.get(i));
                    czyZnaleziono=true;
                }
            }
        }
        if(!czyZnaleziono){
            System.out.println("Nie znaleziono takiej osoby!");
            return new ArrayList();
        }return lista;
    }
    public static List wyszukajPoPensja(float pensja){
        czyZnaleziono = false;
        lista = new ArrayList();
        for(int i=0; i<Main.osoba.size(); i++){
            if(Main.osoba.get(i) instanceof PracownikUczelni){
                if(((PracownikUczelni) Main.osoba.get(i)).getPensja()==pensja){
                    Main.osoba.get(i).wyswietlInfo();
                    lista.add(Main.osoba.get(i));
                    czyZnaleziono=true;
                }
            }
        }
        if(!czyZnaleziono){
            System.out.println("Nie znaleziono takiej osoby!");
            return new ArrayList();
        }return lista;
    }

    public static void premia(){
        StrategiaPremia strategia;
        List<PracownikUczelni> tempList = new ArrayList<>();
        int counter=0;
        for(Osoba i : Main.osoba){
            if(i instanceof PracownikUczelni){
                counter++;
                System.out.println(counter+". "+i.getNazwisko()+" "+ i.getImie());
                tempList.add((PracownikUczelni) i);
            }
        }

        Scanner scan = new Scanner(System.in);
        String wybor;

        while (true){
            System.out.println("Wybierz pracownika ktorego premie chcesz policzyc: ");
            wybor=scan.nextLine();
            PracownikUczelni pracownik = tempList.get(Integer.parseInt(wybor)-1);
            if(wybor.matches("[0-9]+")){
                if(Integer.parseInt(wybor)<=counter){
                    strategia = new PremiaZaStaz();
                    if(pracownik instanceof PracownikAdministracyjny){
                        System.out.println("1. liczba nadgodzin");
                        System.out.println("2. staz pracy");
                        System.out.println("Wybierz wzgledem czego chcesz liczyc premie: ");
                        String temp=scan.nextLine();
                        switch (temp){
                            case "1":
                                strategia=new PremiaZaNadgodziny();
                                break;
                            case "2":
                                strategia = new PremiaZaStaz();
                                break;
                            default:
                                System.out.println("Nieprawidlowy numer");
                                break;
                        }
                    }else if (pracownik instanceof PracownikBadawczoDydaktyczny){
                        System.out.println("1. liczba publikacji");
                        System.out.println("2. staz pracy");
                        System.out.println("Wybierz wzgledem czego chcesz liczyc premie: ");
                        String temp=scan.nextLine();
                        switch (temp){
                            case "1":
                                strategia=new PremiaZaPublikacje();
                                break;
                            case "2":
                                strategia = new PremiaZaStaz();
                                break;
                            default:
                                System.out.println("Nieprawidlowy numer");
                                break;
                        }
                    }
                    System.out.println("Premia wynosi "+strategia.liczPremie(tempList.get(Integer.parseInt(wybor)-1)));
                    return;
                }
            }
            System.out.println("Nieprawidlowy numer!");
        }

    }

    public static void usunPowtorki(){
        Main.osoba=new ArrayList<>(new HashSet<>(Main.osoba));
        System.out.println("Usunieto powtorki");
    }
}
