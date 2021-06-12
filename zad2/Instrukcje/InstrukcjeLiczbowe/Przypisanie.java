package zad2.Instrukcje.InstrukcjeLiczbowe;

import zad2.Instrukcje.Instrukcja;
import zad2.Robson;
import zad2.Wyjatki.BladWykonania;

public class Przypisanie extends InstrukcjaLiczbowa {

    private final String nazwa;
    private final Instrukcja wartosc;

    public Przypisanie(String nazwa, Instrukcja wartosc) {
        super("Przypisanie");
        this.nazwa = nazwa;
        this.wartosc = wartosc;
    }

    public double wykonaj() throws BladWykonania {
        double wartoscLiczbowa = wartosc.wykonaj();
        Robson.getZmienne().put(nazwa, wartoscLiczbowa);
        return wartoscLiczbowa;
    }

    public String toJavaString(String filename, int ileWciec) throws BladWykonania {
        String kod = new String();
        int potrzebneWciecia = ileWciec;
        while (potrzebneWciecia > 0) {
            kod += "    ";
            potrzebneWciecia--;
        }

        if (Robson.getKodString().contains("double " + nazwa)) {
            kod += nazwa + " = " + wartosc.toJavaString(filename, 0) + ";\n";
        } else {
            kod += "double " + nazwa + " = " + wartosc.wykonaj() + ";\n";
        }

        return kod;
    }
}
