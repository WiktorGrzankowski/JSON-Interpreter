package zad2.Instrukcje.InstrukcjeLiczbowe.WyrazeniaArytmetyczne;

import zad2.Wyjatki.BladWykonania;
import zad2.Instrukcje.Instrukcja;
import zad2.Instrukcje.InstrukcjeLogiczne.InstrukcjaLogiczna;

public class Dzielenie extends WyrazenieArytmetyczne {
    public Dzielenie(Instrukcja argument1, Instrukcja argument2) {
        super("Dzielenie", argument1, argument2);
    }

    public double wykonaj() throws BladWykonania {
        if (getArgument1() instanceof InstrukcjaLogiczna || getArgument2() instanceof InstrukcjaLogiczna)
            throw new BladWykonania();

        double wartosc2 = getArgument2().wykonaj();
        if (wartosc2 == 0)
            throw new BladWykonania();

        return getArgument1().wykonaj() / wartosc2;
    }

    public void toJava(String filename) {

    }
    public String toJavaString(String filename, int ileWciec) throws BladWykonania {
        String kod = new String();
        int potrzebneWciecia = ileWciec;
        while (potrzebneWciecia > 0) {
            kod += "    ";
            potrzebneWciecia--;
        }
        kod += getArgument1().toJavaString(filename, ileWciec) + " / "
                + getArgument2().toJavaString(filename, ileWciec) + "\n";
        return kod;
    }
}
