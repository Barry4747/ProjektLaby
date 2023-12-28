import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<Osoba> osoba = new ArrayList<>();
    public static List<Kursy> listaKursow = new ArrayList<>();
    public static void main(String[] args) {
        osoba = Serializacja.wczytajListeOsob();
        listaKursow = Serializacja.wczytajListeKursow();

        PracownikBadawczoDydaktyczny.stanowiskoPracy.addAll(Arrays.asList("Asystent", "Adiunkt", "Profesor Nadzwyczajny", "Profesor Zwyczajny", "Wykładowca"));
        PracownikAdministracyjny.stanowiskoPracy.addAll(Arrays.asList("Referent", "Specjalista", "Starszy Specjalista"));


        Menu.startMenu();

        Serializacja.zapiszListeOsob(osoba);
        Serializacja.zapiszListeKursow(listaKursow);
    }


}