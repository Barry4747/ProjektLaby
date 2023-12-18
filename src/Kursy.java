import java.io.Serializable;

public class Kursy implements InterfaceWyswietlanie, Serializable {
    private String nazwaKursu;
    private PracownikBadawczoDydaktyczny prowadzacy;
    private float pktECTS;

    public Kursy(String nazwaKursu, PracownikBadawczoDydaktyczny prowadzacy, float pktECTS) {
        this.nazwaKursu = nazwaKursu;
        this.prowadzacy=prowadzacy;
        this.pktECTS=pktECTS;
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

    @Override
    public void wyswietlInfo() {
        System.out.print("Nazwa kursu: " +this.nazwaKursu+
                " punkty ECTS: "+this.pktECTS);
        System.out.print(" prowadzacy: ");
        prowadzacy.wyswietlInfo();
    }

    @Override
    public String toString() {
        return "Kursy{" +
                "nazwaKursu='" + nazwaKursu + '\'' +
                ", prowadzacy=" + prowadzacy +
                ", pktECTS=" + pktECTS +
                '}';
    }
}
