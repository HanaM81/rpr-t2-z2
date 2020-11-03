package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocetna, krajnja;
    private boolean pripadaPocetna;
    private boolean pripadaKrajnja;


    Interval(double a, double b, boolean x, boolean y) throws IllegalArgumentException {
        if (b < a) throw new IllegalArgumentException("Krajnja tacka manja od pocetne");
        pocetna = a;
        krajnja = b;
        pripadaPocetna = x;
        pripadaKrajnja = y;
    }

    Interval() {
        pocetna = 0;
        krajnja = 0;
        pripadaPocetna = false;
        pripadaKrajnja = false;
    }

    public static Interval intersect(Interval i1, Interval i2) {
        Interval pom= new Interval();
        if(i1.pocetna<i2.pocetna) pom.pocetna=i2.pocetna;
        else pom.pocetna=i1.pocetna;
        if(i1.krajnja< i2.krajnja) pom.krajnja=i1.krajnja;
        else pom.krajnja= i2.krajnja;
        return pom;
    }

    public boolean isNull() {
        if (pocetna == 0 && krajnja == 0 && pripadaPocetna == false && pripadaKrajnja == false) return true;
        return false;
    }

    public boolean isIn(double a) {
        if (pripadaKrajnja == true) {
            if (pocetna < a && krajnja >= a) return true;
        } else if (pripadaKrajnja == false) {
            if (pocetna < a && krajnja > a) return true;
        }
        return false;
    }

    public Interval intersect(Interval i2) {
        Interval pom= new Interval();
        if(this.pocetna<i2.pocetna) pom.pocetna=i2.pocetna;
        else pom.pocetna=this.pocetna;
        if(this.krajnja< i2.krajnja) pom.krajnja=this.krajnja;
        else pom.krajnja= i2.krajnja;
        return pom;
    }

    public boolean equals(Interval i) {
        if(this.pocetna==i.pocetna && this.krajnja==i.krajnja && this.pripadaPocetna ==i.pripadaPocetna && this.pripadaKrajnja==i.pripadaKrajnja) return true;
        return false;
    }
}

