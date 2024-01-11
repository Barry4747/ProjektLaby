package main.strategiaPremia;

import main.java.PracownikBadawczoDydaktyczny;
import main.java.PracownikUczelni;

public class PremiaZaPublikacje implements StrategiaPremia {

    @Override
    public float liczPremie(PracownikUczelni pracownik) {
        return ((PracownikBadawczoDydaktyczny) pracownik).getLiczbaPublikacji()*500F;
    }
}
