import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializacja {

    public static List<Osoba> wczytajListeKlientow() {
        try (ObjectInputStream odczyt = new ObjectInputStream(new FileInputStream("ListaOsob.ser"))) {
            return (ArrayList<Osoba>)odczyt.readObject();

        } catch (EOFException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void zapiszListeKlientow (List<Osoba> listaOsob) {
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
}
