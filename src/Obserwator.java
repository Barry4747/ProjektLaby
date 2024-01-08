import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Obserwator implements Serializable {
    private String mail;
    private List<String> powiadomienia;
    private static final long serialVersionUID = -8389287214708063607L;

    public Obserwator(String mail){
        this.mail=mail;
        this.powiadomienia=new ArrayList<>();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<String> getPowiadomienia() {
        return powiadomienia;
    }

    public void setPowiadomienia(List<String> powiadomienia) {
        this.powiadomienia = powiadomienia;
    }

    public void powiadom(String temp){
        this.powiadomienia.add("Do: "+this.mail+" | "+ temp);
        System.out.println("Do: "+this.mail+" | "+ temp);
    }
}
