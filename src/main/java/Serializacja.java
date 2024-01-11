package main.java;

import main.obserwator.Obserwator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializacja {

    public static List<Osoba> wczytajListeOsob() {
        try (ObjectInputStream odczyt = new ObjectInputStream(new FileInputStream("ListaOsob.ser"))) {
            return (ArrayList<Osoba>)odczyt.readObject();

        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void zapiszListeOsob (List<Osoba> listaOsob) {
        try (ObjectOutputStream zapis = new ObjectOutputStream(new FileOutputStream("ListaOsob.ser"))) {
            zapis.writeObject(listaOsob);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Kursy> wczytajListeKursow() {
        try (ObjectInputStream odczyt = new ObjectInputStream(new FileInputStream("ListaKursow.ser"))) {
            return (ArrayList<Kursy>)odczyt.readObject();

        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void zapiszListeKursow (List<Kursy> listaKursow) {
            try (ObjectOutputStream zapis = new ObjectOutputStream(new FileOutputStream("ListaKursow.ser"))) {
                zapis.writeObject(listaKursow);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static List<Obserwator> wczytajListeObs(Kursy kurs) {
            try (ObjectInputStream odczyt = new ObjectInputStream(new FileInputStream("ListaObs" + kurs.getNazwaKursu().replaceAll("\\s", "") + ".ser"))) {
                return (ArrayList<Obserwator>) odczyt.readObject();

            } catch (EOFException ignored) {
            } catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        return new ArrayList<>();
    }

    public static void zapiszListeObs (List<Obserwator> lista, Kursy kurs) {
        try (ObjectOutputStream zapis = new ObjectOutputStream(new FileOutputStream("ListaObs"+ kurs.getNazwaKursu().replaceAll("\\s", "") +".ser"))) {
            zapis.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
