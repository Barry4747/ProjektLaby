package main.obserwator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NowyKursant implements Obserwacje, Serializable{
    private static final long serialVersionUID = 3089118544076887554L;
    List<Obserwator> listaObserwatorow = new ArrayList<>();
    @Override
    public void dodajObserwatora(Obserwator obserwator) {
        listaObserwatorow.add(obserwator);
    }

    @Override
    public void usunObserwatora(Obserwator obserwator) {
        listaObserwatorow.remove(obserwator);
    }

    @Override
    public void powiadomObserwadorow(String temp) {
        for(Obserwator i : listaObserwatorow){
            i.powiadom(temp);
        }
    }

    public List<Obserwator> getListaObserwatorow() {
        return listaObserwatorow;
    }

    public void setListaObserwatorow(List<Obserwator> listaObserwatorow) {
        this.listaObserwatorow = listaObserwatorow;
    }
}
