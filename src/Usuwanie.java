import java.util.List;
import java.util.Scanner;

public class Usuwanie {

    //Pracownik

    public static void usunPracownikPoNazwisku(List<Osoba> list){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj nazwisko pracownika ktorego chcesz usunac: ");
        String wybor = scan.nextLine();
        for(int i=0; i<list.size(); i++){
            if(list.get(i) instanceof PracownikUczelni && list.get(i).getNazwisko().equals(wybor)){
                list.remove(i);
                System.out.println("Pracownik usuniety");
                i--;
            }
        }
    }

    public static void usunPracownikPoImieniu(List<Osoba> list){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj imie pracownika ktorego chcesz usunac: ");
        String wybor = scan.nextLine();
        for(int i=0; i<list.size(); i++){
            if(list.get(i) instanceof PracownikUczelni && list.get(i).getImie().equals(wybor)){
                list.remove(i);
                System.out.println("Pracownik usuniety");
                i--;
            }
        }
    }

    public static void usunPracownikPoStazuPracy(List<Osoba> list){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj staz pracy pracownika ktorego chcesz usunac: ");
        String wybor = scan.nextLine();
        if(wybor.matches("[0-9]+")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof PracownikUczelni && ((PracownikUczelni) list.get(i)).getStazPracy() == Integer.parseInt(wybor)) {
                    list.remove(i);
                    System.out.println("Pracownik usuniety");
                    i--;
                }
            }
        }else System.out.println("Musi byc liczba");
    }

    public static void usunPracownikPoStanowisku(List<Osoba> list){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj nazwisko pracownika ktorego chcesz usunac: ");
        String wybor = scan.nextLine();
        for(int i=0; i<list.size(); i++){
            if(list.get(i) instanceof PracownikUczelni && ((PracownikUczelni) list.get(i)).getStanowisko().equals(wybor)){
                list.remove(i);
                System.out.println("Pracownik usuniety");
                i--;
            }
        }
    }

    //Student

    public static void usunStudentaPoNazwisku(List<Osoba> list){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj nazwisko studenta ktorego chcesz usunac: ");
        String wybor = scan.nextLine();
        for(int i=0; i<list.size(); i++){
            if(list.get(i) instanceof Student && list.get(i).getNazwisko().equals(wybor)){
                list.remove(i);
                System.out.println("Student usuniety");
                i--;
            }
        }
    }

    public static void usunStudentaPoImieniu(List<Osoba> list){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj imie studenta ktorego chcesz usunac: ");
        String wybor = scan.nextLine();
        for(int i=0; i<list.size(); i++){
            if(list.get(i) instanceof Student && list.get(i).getImie().equals(wybor)){
                list.remove(i);
                System.out.println("Student usuniety");
                i--;
            }
        }
    }

    public static void usunStudentaPoNrIndeksu(List<Osoba> list){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj numer indeksu studenta ktorego chcesz usunac: ");
        String wybor = scan.nextLine();
        for(int i=0; i<list.size(); i++){
            if(list.get(i) instanceof Student && ((Student) list.get(i)).getNrIndeksu().equals(wybor)){
                list.remove(i);
                System.out.println("Student usuniety");
                i--;
            }
        }
    }

    public static void usunStudentaPoRokuStudiow(List<Osoba> list){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj rok studiow studenta ktorego chcesz usunac: ");
        String wybor = scan.nextLine();
        if(wybor.matches("[0-9]+")) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof Student && ((Student) list.get(i)).getRokStudiow() == Integer.parseInt(wybor)) {
                    list.remove(i);
                    System.out.println("Student usuniety");
                    i--;
                }
            }
        }else System.out.println("Musi byc liczba");
    }

    //Kursy

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
