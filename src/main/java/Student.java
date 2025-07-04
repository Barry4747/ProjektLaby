package main.java;

import main.obserwator.NowyKursant;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Student extends Osoba implements InterfaceWyswietlanie, Serializable {
    private String nrIndeksu;
    private int rokStudiow;
    private List<Kursy> listaKursow;
    private boolean erasmus;
    private boolean Istopnia;
    private boolean IIstopnia;
    private boolean stStacjonarne;
    private boolean stNiestacjonarne;
    public Student(String imie, String nazwisko, String email, String PESEL, byte wiek, String plec, String nrIndeksu, int rokStudiow, List<Kursy> listaKursow, boolean erasmus,
                   boolean Istopnia, boolean IIstopnia, boolean stStacjonarne, boolean stNiestacjonarne){
        super(imie, nazwisko, email, PESEL, wiek, plec);
        this.nrIndeksu=nrIndeksu;
        this.rokStudiow=rokStudiow;
        this.listaKursow=listaKursow;
        this.erasmus=erasmus;
        this.Istopnia=Istopnia;
        this.IIstopnia=IIstopnia;
        this.stStacjonarne=stStacjonarne;
        this.stNiestacjonarne=stNiestacjonarne;
    }
    private static final long serialVersionUID = -2751420503953502693L;
    public String getNrIndeksu() {
        return nrIndeksu;
    }

    public void setNrIndeksu(String nrIndeksu) {
        this.nrIndeksu = nrIndeksu;
    }

    public int getRokStudiow() {
        return rokStudiow;
    }

    public void setRokStudiow(int rokStudiow) {
        this.rokStudiow = rokStudiow;
    }

    public List<Kursy> getListaKursow() {
        return listaKursow;
    }

    public void setListaKursow(List<Kursy> listaKursow) {
        this.listaKursow = listaKursow;
    }

    public boolean isErasmus() {
        return erasmus;
    }

    public void setErasmus(boolean erasmus) {
        this.erasmus = erasmus;
    }

    public boolean isIstopnia() {
        return Istopnia;
    }

    public void setIstopnia(boolean istopnia) {
        Istopnia = istopnia;
    }

    public boolean isIIstopnia() {
        return IIstopnia;
    }

    public void setIIstopnia(boolean IIstopnia) {
        this.IIstopnia = IIstopnia;
    }

    public boolean isStStacjonarne() {
        return stStacjonarne;
    }

    public void setStStacjonarne(boolean stStacjonarne) {
        this.stStacjonarne = stStacjonarne;
    }

    public boolean isStNiestacjonarne() {
        return stNiestacjonarne;
    }

    public void setStNiestacjonarne(boolean stNiestacjonarne) {
        this.stNiestacjonarne = stNiestacjonarne;
    }
    public void dodajKurs(String nazwaKursu, PracownikBadawczoDydaktyczny prowadzacy, float pktECTS){
        listaKursow.add(new Kursy(nazwaKursu, prowadzacy, pktECTS, new NowyKursant()));
    }
    public void usunKurs(String kurs){
        for(int i=0; i<listaKursow.size(); i++)
            if (listaKursow.get(i).getNazwaKursu().equals(kurs)) {
                listaKursow.remove(i);
                break;
            }
    }


    @Override
    public String toString() {
        return super.toString()+
                "main.java.Student\n" +
                "Numer indeksu: " + nrIndeksu + "\n" +
                "Rok studiow: " + rokStudiow +"\n" +
                "ListaKursow: " + "\n"+listaKursow +"\n" +
                "Erasmus: " + erasmus +"\n" +
                "I stopnia: " + Istopnia +"\n" +
                "II stopnia: " + IIstopnia +"\n" +
                "Studia stacjonarne: " + stStacjonarne +"\n" +
                "Studia niestacjonarne: " + stNiestacjonarne +"\n";
    }

    @Override
    public void wyswietlInfo() {
        System.out.println("-------------------------------------");
        System.out.println("STUDENT");
        System.out.println(this.toString());
        System.out.println("-------------------------------------");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
//        if (equals(object)) return false;
        Student student = (Student) object;
        return Objects.equals(nrIndeksu, student.nrIndeksu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nrIndeksu);
    }
}
