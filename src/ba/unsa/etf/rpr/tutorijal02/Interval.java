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
        return false;
    }

    public boolean isNull() {
        return false;
    }

    public Interval intersect(Interval interval) {
        return null;
    }
}
