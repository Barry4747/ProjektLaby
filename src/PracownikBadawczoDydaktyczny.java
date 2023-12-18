import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PracownikBadawczoDydaktyczny extends PracownikUczelni implements InterfaceWyswietlanie, Serializable {
    private int liczbaPublikacji;
    public static List<String> stanowiskoPracy = new ArrayList<>();

    public PracownikBadawczoDydaktyczny(String imie, String nazwisko, String email, String PESEL, byte wiek, String plec, String stanowisko, byte stazPracy, float pensja,
                                        int liczbaPublikacji){
        super(imie, nazwisko, email, PESEL, wiek, plec, stanowisko, stazPracy, pensja);
        this.liczbaPublikacji=liczbaPublikacji;
    }
    private static final long serialVersionUID = -502456261960054840L;

    public int getLiczbaPublikacji() {
        return liczbaPublikacji;
    }

    public void setLiczbaPublikacji(int liczbaPublikacji) {
        this.liczbaPublikacji = liczbaPublikacji;
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
                "Liczba publikacji: " + liczbaPublikacji;

    }

    @Override
    public void wyswietlInfo() {
        System.out.println("-------------------------------------");
        System.out.println("PRACOWNIK BADAWCZO DYDAKTYCZNY"+"\n" +
                "Imie: " + this.getImie() + "\n" +
                "Nazwisko: " + this.getNazwisko() + "\n" +
                "Email: " + this.getEmail() + "\n" +
                "Wiek: " + this.getWiek() + "\n" +
                "Plec: " + this.getPlec() + "\n" +
                "Stanowisko: " + this.getStanowisko() + "\n" +
                "Staz pracy: " + this.getStazPracy() + "\n" +
                "Pensja: " + this.getPensja() + "\n" +
                "Liczba publikacji: "+liczbaPublikacji);
        System.out.println("-------------------------------------");
    }
}
