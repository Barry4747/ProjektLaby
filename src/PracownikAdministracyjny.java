import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PracownikAdministracyjny extends PracownikUczelni implements InterfaceWyswietlanie, Serializable {
    private int liczbaNadgodzin;
    public static List<String> stanowiskoPracy = new ArrayList<>();

    public PracownikAdministracyjny(String imie, String nazwisko, String email, String PESEL, byte wiek, String plec, String stanowisko, byte stazPracy, float pensja,
                                    int liczbaNadgodzin){
        super(imie, nazwisko, email, PESEL, wiek, plec, stanowisko, stazPracy, pensja);
        this.liczbaNadgodzin=liczbaNadgodzin;
    }
    private static final long serialVersionUID = -8215413912087069104L;

    public int getLiczbaNadgodzin() {
        return liczbaNadgodzin;
    }

    public void setLiczbaNadgodzin(int liczbaNadgodzin) {
        this.liczbaNadgodzin = liczbaNadgodzin;
    }

    public List<String> getStanowiskoPracy() {
        return stanowiskoPracy;
    }

    public void setStanowiskoPracy(List<String> stanowiskoPracy) {
        this.stanowiskoPracy = stanowiskoPracy;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Liczba nadgodzin: " + liczbaNadgodzin;
    }

    @Override
    public void wyswietlInfo() {
        System.out.println("-------------------------------------");
        System.out.println("PRACOWNIK ADMINISTRACYJNY"+"\n" +
                "Imie: " + this.getImie() + "\n" +
                "Nazwisko: " + this.getNazwisko() + "\n" +
                "Email: " + this.getEmail() + "\n" +
                "Wiek: " + this.getWiek() + "\n" +
                "Ples: " + this.getPlec() + "\n" +
                "Stanowisko: " + this.getStanowisko() + "\n" +
                "Pensja: " + this.getPensja() + "\n" +
                "Liczba nadgodzin: " + this.getLiczbaNadgodzin() + "\n" +
                "Staz pracy: " + this.getStazPracy());
        System.out.println("-------------------------------------");
    }
}
