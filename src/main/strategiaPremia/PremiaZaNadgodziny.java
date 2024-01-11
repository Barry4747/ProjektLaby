package main.strategiaPremia;

import main.java.PracownikAdministracyjny;
import main.java.PracownikUczelni;

public class PremiaZaNadgodziny implements StrategiaPremia {

    @Override
    public float liczPremie(PracownikUczelni pracownik) {
        return ((PracownikAdministracyjny) pracownik).getLiczbaNadgodzin()*100F;
    }
}
