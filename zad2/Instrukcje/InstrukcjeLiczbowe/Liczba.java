package zad2.Instrukcje.InstrukcjeLiczbowe;

public class Liczba extends InstrukcjaLiczbowa {
    private final double wartosc;

    public Liczba(double wartosc) {
        super("Liczba");
        this.wartosc = wartosc;
    }

    public double wykonaj() {
        return wartosc;
    }

    public String toJavaString(String filename, int ileWciec) {
        return Double.toString(wartosc);
    }
}
