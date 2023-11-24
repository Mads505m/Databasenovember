public class StudFag {
    private int stdNr, fagNr, kar;

    public StudFag(int stdNr, int fagNr, int kar){
        this.stdNr = stdNr;
        this.fagNr = fagNr;
        this.kar = kar;
    }

    public StudFag(){

    }

    public int getFagNr() {
        return fagNr;
    }

    public int getStdNr() {
        return stdNr;
    }

    public void setStdNr(int stdNr) {
        this.stdNr = stdNr;
    }

    public int getKar() {
        return kar;
    }

    public void setKar(int kar) {
        this.kar = kar;
    }

    public void setFagNr(int fagNr) {
        this.fagNr = fagNr;
    }

    @Override
    public String toString() {
        return "StudFag{" +
                "stdNr=" + stdNr +
                ", fagNr=" + fagNr +
                ", kar=" + kar +
                '}';
    }
}