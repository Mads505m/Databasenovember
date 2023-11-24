import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Studerende {

    private int stdNr;
    private String fNavn;
    private String eNavn;
    private String adresse;
    private String postNr;
    private String mobil;
    private String klasse;


    public Studerende(int stdNr, String fnavn, String enavn, String adresse, String postNr, String mobil, String klasse){
        this.stdNr = stdNr;
        this.fNavn = fnavn;
        this.eNavn = enavn;
        this.adresse = adresse;
        this.postNr = postNr;
        this.mobil = mobil;
        this.klasse = klasse;
    }


    public Studerende(){

    }

    public Studerende(int stdNr, String postNr) {
        this.stdNr=stdNr;
        this.postNr=postNr;
    }
    public Studerende(String klasse, String postNr) {
        this.klasse=klasse;
        this.postNr=postNr;

    }

    public Studerende (String klasse, int stdNr) {
        this.klasse=klasse;
        this.stdNr=stdNr;
    }

    public Studerende(String fNavn) {
        this.fNavn=fNavn;
    }

    public int getStdNr() {
        return stdNr;
    }

    public void setStdNr(int stdNr) {
        this.stdNr = stdNr;
    }

    public String getfNavn() {
        return fNavn;
    }

    public void setfNavn(String fNavn) {
        this.fNavn = fNavn;
    }

    public String geteNavn() {
        return eNavn;
    }

    public void seteNavn(String eNavn) {
        this.eNavn = eNavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPostNr() {
        return postNr;
    }

    public void setPostNr(String postNr) {
        this.postNr = postNr;
    }

    public String getMobil() {
        return mobil;
    }

    public void mobil(String mobil) {
        this.postNr = mobil;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }



    @Override
    public String toString() {
        return "Studerende{" +
                "stdNr=" + stdNr +
                ", fNavn='" + fNavn + '\'' +
                ", eNavn='" + eNavn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", postNr=" + postNr +
                ", klasse=" + klasse +
                '}';
    }
}