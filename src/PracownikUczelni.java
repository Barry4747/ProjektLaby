public abstract class PracownikUczelni extends Osoba implements InterfaceWyswietlanie{
    private String stanowisko;
    private byte stazPracy;
    private float pensja;

    public PracownikUczelni(String imie, String nazwisko, String email, String PESEL, byte wiek, String plec, String stanowisko, byte stazPracy, float pensja){
        super(imie, nazwisko, email, PESEL, wiek, plec);
        this.stanowisko=stanowisko;
        this.stazPracy=stazPracy;
        this.pensja=pensja;
    }
    private static final long serialVersionUID = 6714244666619964016L;
    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public byte getStazPracy() {
        return stazPracy;
    }

    public void setStazPracy(byte stazPracy) {
        this.stazPracy = stazPracy;
    }

    public float getPensja() {
        return pensja;
    }

    public void setPensja(float pensja) {
        this.pensja = pensja;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Stanowisko: " + stanowisko + "\n" +
                "Staz pracy: " + stazPracy + "\n" +
                "Pensja: " + pensja+ "\n" ;
    }
}
