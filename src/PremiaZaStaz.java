public class PremiaZaStaz implements StrategiaPremia{
    @Override
    public float liczPremie(PracownikUczelni pracownik) {
        if(pracownik.getStazPracy()<=0){
            return 0;
        }else {
            int val = pracownik.getStazPracy()&0xFF;
            return 10000 - 1000*(1/ (float)val);
        }
    }
}
