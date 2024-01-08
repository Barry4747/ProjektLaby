public class PremiaZaNadgodziny implements StrategiaPremia{

    @Override
    public float liczPremie(PracownikUczelni pracownik) {
        return ((PracownikAdministracyjny) pracownik).getLiczbaNadgodzin()*100F;
    }
}
