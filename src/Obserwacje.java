public interface Obserwacje {
    void dodajObserwatora(Obserwator obserwator);
    void usunObserwatora(Obserwator obserwator);
    void powiadomObserwadorow(String temp);
}
