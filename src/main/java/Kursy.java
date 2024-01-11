package main.java;

import main.obserwator.NowyKursant;

import java.io.Serializable;

public class Kursy implements InterfaceWyswietlanie, Serializable {
    private String nazwaKursu;
    private PracownikBadawczoDydaktyczny prowadzacy;
    private float pktECTS;
    private NowyKursant kursant;

    public Kursy(String nazwaKursu, PracownikBadawczoDydaktyczny prowadzacy, float pktECTS, NowyKursant kursant) {
        this.nazwaKursu = nazwaKursu;
        this.prowadzacy=prowadzacy;
        this.pktECTS=pktECTS;
        this.kursant=kursant;
    }
    private static final long serialVersionUID = 2624508219198108986L;

    public String getNazwaKursu() {
        return nazwaKursu;
    }

    public void setNazwaKursu(String nazwaKursu) {
        this.nazwaKursu = nazwaKursu;
    }

    public PracownikBadawczoDydaktyczny getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(PracownikBadawczoDydaktyczny prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public float getPktECTS() {
        return pktECTS;
    }

    public void setPktECTS(float pktECTS) {
        this.pktECTS = pktECTS;
    }

    public NowyKursant getKursant() {
        return kursant;
    }

    public void setKursant(NowyKursant kursant) {
        this.kursant = kursant;
    }

    @Override
    public void wyswietlInfo() {
        System.out.println("-------------------------------------");
        System.out.println("Nazwa kursu: " +this.nazwaKursu+"\n" +
                "Punkty ECTS: "+this.pktECTS);
        System.out.println("Prowadzacy: ");
        prowadzacy.wyswietlInfo();
        System.out.println("-------------------------------------");
    }

    @Override
    public String toString() {
        return "KURS" + "\n" +
                "Nazwa kursu: " + nazwaKursu + "\n" +
                "Prowadzacy: " + prowadzacy +"\n" +
                "Punkty ECTS: " + pktECTS+"\n";
    }
}
