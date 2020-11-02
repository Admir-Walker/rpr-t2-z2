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
        return i.intersect(i2);
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
        Interval intersect = new Interval();
        intersect.pocetnaTacka = Math.max(this.pocetnaTacka, interval.pocetnaTacka);
        intersect.krajnjaTacka = Math.min(this.krajnjaTacka, interval.krajnjaTacka);
        intersect.pripadnostIntervaluPocetneTacke = Double.compare(intersect.pocetnaTacka, this.pocetnaTacka) == 0 ? this.pripadnostIntervaluPocetneTacke : interval.pripadnostIntervaluPocetneTacke;
        intersect.pripadnostIntervaluKrajnjeTacke = Double.compare(intersect.krajnjaTacka, this.krajnjaTacka) == 0 ? this.pripadnostIntervaluKrajnjeTacke : interval.pripadnostIntervaluKrajnjeTacke;
        return intersect;
    }

    @Override
    public boolean equals(Object obj) {
        Interval interval = (Interval) obj;
        boolean jednakostPocetnihTacki = Double.compare(this.pocetnaTacka, interval.pocetnaTacka) == 0;
        boolean jednakostKrajnjihTacki = Double.compare(this.krajnjaTacka, interval.krajnjaTacka) == 0;
        boolean jednakostPripadnostiIntervalaPocetnihTacki = this.pripadnostIntervaluPocetneTacke == interval.pripadnostIntervaluPocetneTacke;
        boolean jednakostPripadnostiIntervalaKrajnjihTacki = this.pripadnostIntervaluKrajnjeTacke == interval.pripadnostIntervaluKrajnjeTacke;
        // Rubni slucaj
        if(jednakostPocetnihTacki && !jednakostPripadnostiIntervalaPocetnihTacki) return false;
        if(jednakostKrajnjihTacki && !jednakostPripadnostiIntervalaKrajnjihTacki) return false;
        return (jednakostPocetnihTacki && jednakostKrajnjihTacki);
    }

    private int convertBooleanToInt(Boolean b){
        return b ? 1 : 0;
    }
    @Override
    public String toString() {
        if(this.isNull()) return new String("()");
        // Primjeri ispisa [2.2,2.5), [2.2,2.5), [2.2,2.6]
        char[] zagrade = {'(','[',')',']'}; // 0, 1, 2, 3
        char lijevaZagradaIspisa = zagrade[convertBooleanToInt(pripadnostIntervaluPocetneTacke)];
        char desnaZagradaIspisa = zagrade[convertBooleanToInt(pripadnostIntervaluKrajnjeTacke) + 2];
        return new String(""+lijevaZagradaIspisa+pocetnaTacka+","+krajnjaTacka+desnaZagradaIspisa);
    }
}
