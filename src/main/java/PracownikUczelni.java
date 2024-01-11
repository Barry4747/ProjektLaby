package main.java;

import java.util.Objects;

public abstract class PracownikUczelni extends Osoba implements InterfaceWyswietlanie {
    private String stanowisko;
    private byte stazPracy;
    private float pensja;
    private float premia;

    public PracownikUczelni(String imie, String nazwisko, String email, String PESEL, byte wiek, String plec, String stanowisko, byte stazPracy, float pensja, float premia){
        super(imie, nazwisko, email, PESEL, wiek, plec);
        this.stanowisko=stanowisko;
        this.stazPracy=stazPracy;
        this.pensja=pensja;
    }
    private static final long serialVersionUID = 6714244666619964016L;

    public static int hash(String pesel) {
        return 0;
    }

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

    public float getPremia() {
        return premia;
    }

    public void setPremia(float premia) {
        this.premia = premia;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Stanowisko: " + stanowisko + "\n" +
                "Staz pracy: " + stazPracy + "\n" +
                "Pensja: " + pensja+ "\n" ;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
//        if (equals(object)) return false;
        PracownikUczelni that = (PracownikUczelni) object;
        return Objects.equals(getPESEL(), that.getPESEL());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getPESEL());
    }
}
