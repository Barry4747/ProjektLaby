package main.java;

import java.util.List;
import java.util.Scanner;

public class Usuwanie {

    //Pracownik

    public static List usunPracownikPoNazwisku(List<Osoba> list, String nazwisko){
        for(int i=0; i<list.size(); i++){
            if(list.get(i) instanceof PracownikUczelni && list.get(i).getNazwisko().equals(nazwisko)){
                for(int j=0; j<Main.listaKursow.size(); j++){
                    if(Main.listaKursow.get(j).getProwadzacy().getNazwisko().equals(list.get(i).getNazwisko())){
                        Main.listaKursow.remove(j);
                        j--;
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
                for(int j=0; j<Main.listaKursow.size(); j++){
                    if(Main.listaKursow.get(j).getProwadzacy().getImie().equals(list.get(i).getImie())){
                        Main.listaKursow.remove(j);
                        j--;
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
                    for(int j=0; j<Main.listaKursow.size(); j++){
                        if(Main.listaKursow.get(j).getProwadzacy().getStazPracy()==((PracownikUczelni) list.get(i)).getStazPracy()){
                            Main.listaKursow.remove(j);
                            j--;
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
                for(int j=0; j<Main.listaKursow.size(); j++){
                    if(Main.listaKursow.get(j).getProwadzacy().getStanowisko().equals(((PracownikUczelni) list.get(i)).getStanowisko())){
                        Main.listaKursow.remove(j);
                        j--;
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

    public static List usunKursPoNazwie(List<Kursy> list, String nazwa){
        for(int i=0; i<list.size(); i++){
            if(list.get(i) != null && list.get(i).getNazwaKursu().equals(nazwa)){
                list.remove(i);
                System.out.println("Kurs usuniety");
                i--;
            }
        }return list;
    }

    public static List usunKursPoNazwiskuProwadzacego(List<Kursy> list, String nazwisko){
        for(int i=0; i<list.size(); i++){
            if(list.get(i) != null && list.get(i).getProwadzacy().getNazwisko().equals(nazwisko)){
                list.remove(i);
                System.out.println("Kurs usuniety");
                i--;
            }
        }return list;
    }

    public static List usunKursPoLiczbiePktECTS(List<Kursy> list, String punkty){
        if(punkty.matches("[+-]?([0-9]*[.])?[0-9]+")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) != null && list.get(i).getPktECTS() == Integer.parseInt(punkty)) {
                    list.remove(i);
                    System.out.println("Kurs usuniety");
                    i--;
                }
            }
        }else System.out.println("Musi byc liczba"); return list;
    }
}
