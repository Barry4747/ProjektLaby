import java.io.Serializable;

public abstract class Osoba implements InterfaceWyswietlanie, Serializable {
    private String imie;
    private String nazwisko;
    private String PESEL;
    private byte wiek;
    private String plec;
    public Osoba(String imie, String nazwisko, String PESEL, byte wiek, String plec){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.PESEL=PESEL;
        this.wiek=wiek;
        this.plec=plec;
    }
    private static final long serialVersionUID = -502456261960054840L;
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public byte getWiek() {
        return wiek;
    }

    public void setWiek(byte wiek) {
        this.wiek = wiek;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    @Override
    public String toString() {
        return "Imie: " + imie + "\n" +
                "Nazwisko: " + nazwisko + "\n" +
                "PESEL: " + PESEL + "\n" +
                "Wiek: " + wiek +"\n" +
                "Plec: " + plec + "\n";
    }
}
