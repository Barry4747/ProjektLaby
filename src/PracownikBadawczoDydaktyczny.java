import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PracownikBadawczoDydaktyczny extends PracownikUczelni implements InterfaceWyswietlanie, Serializable {
    private int liczbaPublikacji;
    public static List<String> stanowiskoPracy = new ArrayList<>();

    public PracownikBadawczoDydaktyczny(String imie, String nazwisko, String PESEL, byte wiek, String plec, String stanowisko, byte stazPracy, float pensja,
                                        int liczbaPublikacji){
        super(imie, nazwisko, PESEL, wiek, plec, stanowisko, stazPracy, pensja);
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
                ", liczbaPublikacji=" + liczbaPublikacji;

    }

    @Override
    public void wyswietlInfo() {
        System.out.println("imie='" + this.getImie() + '\'' +
                ", nazwisko='" + this.getNazwisko() + '\'' +
                ", wiek=" + this.getWiek() +
                ", plec='" + this.getPlec() + '\''+
                ", stanowisko='" + this.getStanowisko() + '\'' +
                ", stazPracy=" + this.getStazPracy() +
                ", pensja=" + this.getPensja() +
                ", liczbaPublikacji="+liczbaPublikacji);
    }
}
