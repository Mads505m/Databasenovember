public class Fag {

    private int fagid;
    private String fagnavn;
    private int stdnr;

    public Fag () {

    }
    public Fag(int fagid, String fagnavn) {
        this.fagid=fagid;
        this.fagnavn=fagnavn;
    }
    public Fag (int fagid, String fagnavn, int stdnr) {
        this.fagid=fagid;
        this.fagnavn=fagnavn;
        this.stdnr=stdnr;
    }

    public int getFagid() {
        return fagid;
    }

    public void setFagid(int fagid) {
        this.fagid = fagid;
    }

    public String getFagnavn() {
        return fagnavn;
    }

    public void setFagnavn(String fagnavn) {
        this.fagnavn = fagnavn;
    }

    @Override
    public String toString() {
        return "Fag{" +
                "fagid=" + fagid +
                ", fagnavn='" + fagnavn + '\'' +
                '}';
    }
}