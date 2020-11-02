package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    private double pocetnaTacka, krajnjaTacka;
    boolean pripadnostIntervaluPocetneTacke, pripadnostIntervaluKrajnjeTacke;

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pripadnostIntervaluPocetneTacke, boolean pripadnostIntervaluKrajnjeTacke) throws IllegalArgumentException {
        if(pocetnaTacka > krajnjaTacka) throw new IllegalArgumentException();
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pripadnostIntervaluPocetneTacke = pripadnostIntervaluPocetneTacke;
        this.pripadnostIntervaluKrajnjeTacke = pripadnostIntervaluKrajnjeTacke;
    }

    public Interval() {
        pocetnaTacka = 0.0;
        krajnjaTacka = 0.0;
        pripadnostIntervaluPocetneTacke = false;
        pripadnostIntervaluKrajnjeTacke = false;
    }

    public static Interval intersect(Interval i, Interval i2) {
        return null;
    }

    public boolean isIn(double tacka) {
        // Provjera rubnih slucajeva
        if(Double.compare(tacka, pocetnaTacka) == 0 && (!pripadnostIntervaluPocetneTacke)) return false;
        if(Double.compare(tacka, krajnjaTacka) == 0 && (!pripadnostIntervaluKrajnjeTacke)) return false;
        // Ako je tacka unutar intervala
        return (tacka >= pocetnaTacka && tacka <= krajnjaTacka);
    }

    public boolean isNull() {
        return Double.compare(pocetnaTacka, krajnjaTacka) == 0;
    }

    public Interval intersect(Interval interval) {
        return null;
    }
}
