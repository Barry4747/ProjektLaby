import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PracownikAdministracyjny extends PracownikUczelni implements InterfaceWyswietlanie, Serializable {
    private int liczbaNadgodzin;
    public static List<String> stanowiskoPracy = new ArrayList<>();

    public PracownikAdministracyjny(String imie, String nazwisko, String PESEL, byte wiek, String plec, String stanowisko, byte stazPracy, float pensja,
                                    int liczbaNadgodzin){
        super(imie, nazwisko, PESEL, wiek, plec, stanowisko, stazPracy, pensja);
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
                ", liczbaNadgodzin=" + liczbaNadgodzin;
    }

    @Override
    public void wyswietlInfo() {
        System.out.println("imie='" + this.getImie() + '\'' +
                ", nazwisko='" + this.getNazwisko() + '\'' +
                ", wiek=" + this.getWiek() +
                ", plec='" + this.getPlec() + '\''+
                ", stanowisko='" + this.getStanowisko() + '\'' +
                ", pensja=" + this.getPensja() + '\'' +
                ", liczba nadgodzin=" + this.getLiczbaNadgodzin() +'\'' +
                ", stazPracy=" + this.getStazPracy());
    }
}
