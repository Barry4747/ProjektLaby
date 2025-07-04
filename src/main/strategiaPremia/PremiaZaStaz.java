package main.strategiaPremia;

import main.java.PracownikUczelni;

public class PremiaZaStaz implements StrategiaPremia{
    @Override
    public float liczPremie(PracownikUczelni pracownik) {
        if(pracownik.getStazPracy()<=0){
            return 0;
        }else {
            int val = pracownik.getStazPracy()&0xFF;
            pracownik.setPremia(((float)val)*30);
            return ((float)val)*30;
        }
    }
}
