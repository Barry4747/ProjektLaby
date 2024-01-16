package main.java;

import java.util.List;
import java.util.Scanner;

public class Usuwanie {

    //Pracownik

    public static List usunPracownikPoNazwisku(List<Osoba> list, String nazwisko){
        for(int i=0; i<list.size(); i++){
            if(list.get(i) instanceof PracownikUczelni && list.get(i).getNazwisko().equals(nazwisko)){
                int tempInt=Main.listaKursow.size();
                int counter=0;
                for(int j=0; j<tempInt; j++){
                    if(Main.listaKursow.get(j).getProwadzacy().getNazwisko().equals(list.get(i))){
                        Main.listaKursow.remove(j-counter);
                        counter++;
                    }
                }
                list.remove(i);
                System.out.println("Pracownik usuniety");
                i--;
            }
        }return Menu.wyswietlPracownikUczelni();
    }

    public static List usunPracownikPoImieniu(List<Osoba> list, String imie){
        for(int i=0; i<list.size(); i++){
            if(list.get(i) instanceof PracownikUczelni && list.get(i).getImie().equals(imie)){
                int tempInt=Main.listaKursow.size();
                int counter=0;
                for(int j=0; j<tempInt; j++){
                    if(Main.listaKursow.get(j).getProwadzacy().getNazwisko().equals(list.get(i))){
                        Main.listaKursow.remove(j-counter);
                        counter++;
                    }
                }
                list.remove(i);
                System.out.println("Pracownik usuniety");
                i--;
            }
        }return Menu.wyswietlPracownikUczelni();
    }

    public static List usunPracownikPoStazuPracy(List<Osoba> list, String staz){
        if(staz.matches("[0-9]+")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof PracownikUczelni && ((PracownikUczelni) list.get(i)).getStazPracy() == Integer.parseInt(staz)) {
                    int tempInt=Main.listaKursow.size();
                    int counter=0;
                    for(int j=0; j<tempInt; j++){
                        if(Main.listaKursow.get(j).getProwadzacy().getNazwisko().equals(list.get(i))){
                            Main.listaKursow.remove(j-counter);
                            counter++;
                        }
                    }
                    list.remove(i);
                    System.out.println("Pracownik usuniety");
                    i--;
                }
            }
        }else System.out.println("Musi byc liczba"); return Menu.wyswietlPracownikUczelni();
    }

    public static List usunPracownikPoStanowisku(List<Osoba> list, String stanowisko){
        for(int i=0; i<list.size(); i++){
            if(list.get(i) instanceof PracownikUczelni && ((PracownikUczelni) list.get(i)).getStanowisko().equals(stanowisko)){
                int tempInt=Main.listaKursow.size();
                int counter=0;
                for(int j=0; j<tempInt; j++){
                    if(Main.listaKursow.get(j).getProwadzacy().getStanowisko().equals(list.get(i))){
                        Main.listaKursow.remove(j-counter);
                        counter++;
                    }
                }
                list.remove(i);
                System.out.println("Pracownik usuniety");
                i--;
            }
        }return Menu.wyswietlPracownikUczelni();
    }

    //main.java.Student

    public static List usunStudentaPoNazwisku(List<Osoba> list, String nazwisko){
        for(int i=0; i<list.size(); i++){
            if(list.get(i) instanceof Student && list.get(i).getNazwisko().equals(nazwisko)){
                list.remove(i);
                System.out.println("main.java.Student usuniety");
                i--;
            }
        }return Menu.wyswietlStudentow();
    }

    public static List usunStudentaPoImieniu(List<Osoba> list, String imie){
        for(int i=0; i<list.size(); i++){
            if(list.get(i) instanceof Student && list.get(i).getImie().equals(imie)){
                list.remove(i);
                System.out.println("main.java.Student usuniety");
                i--;
            }
        }return Menu.wyswietlStudentow();
    }

    public static List usunStudentaPoNrIndeksu(List<Osoba> list, String nr){
        for(int i=0; i<list.size(); i++){
            if(list.get(i) instanceof Student && ((Student) list.get(i)).getNrIndeksu().equals(nr)){
                list.remove(i);
                System.out.println("main.java.Student usuniety");
                i--;
            }
        }return Menu.wyswietlStudentow();
    }

    public static List usunStudentaPoRokuStudiow(List<Osoba> list, String rok){
        if(rok.matches("[0-9]+")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof Student && ((Student) list.get(i)).getRokStudiow() == Integer.parseInt(rok)) {
                    list.remove(i);
                    System.out.println("main.java.Student usuniety");
                    i--;
                }
            }
        }else System.out.println("Musi byc liczba"); return Menu.wyswietlStudentow();
    }

    //main.java.Kursy

    public static void usunKursPoNazwie(List<Kursy> list){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj nazwe kursu ktory chcesz usunac: ");
        String wybor = scan.nextLine();
        for(int i=0; i<list.size(); i++){
            if(list.get(i) != null && list.get(i).getNazwaKursu().equals(wybor)){
                list.remove(i);
                System.out.println("Kurs usuniety");
                i--;
            }
        }
    }

    public static void usunKursPoNazwiskuProwadzacego(List<Kursy> list){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj nazwisko prowadzacego kursu ktory chcesz usunac: ");
        String wybor = scan.nextLine();
        for(int i=0; i<list.size(); i++){
            if(list.get(i) != null && list.get(i).getProwadzacy().getNazwisko().equals(wybor)){
                list.remove(i);
                System.out.println("Kurs usuniety");
                i--;
            }
        }
    }

    public static void usunKursPoLiczbiePktECTS(List<Kursy> list){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj liczbe punktow ECTS kursu ktory chcesz usunac: ");
        String wybor = scan.nextLine();
        if(wybor.matches("[0-9]+")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null && list.get(i).getPktECTS() == Integer.parseInt(wybor)) {
                    list.remove(i);
                    System.out.println("Kurs usuniety");
                    i--;
                }
            }
        }else System.out.println("Musi byc liczba");
    }
}
