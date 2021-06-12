package zad2.Instrukcje.InstrukcjeLiczbowe.WyrazeniaArytmetyczne;

import zad2.Wyjatki.BladWykonania;
import zad2.Instrukcje.Instrukcja;
import zad2.Instrukcje.InstrukcjeLogiczne.InstrukcjaLogiczna;

public class Minus extends WyrazenieArytmetyczne {
    public Minus(Instrukcja argument1, Instrukcja argument2) {
        super("Minus", argument1, argument2);
    }

    public double wykonaj() throws BladWykonania {
        if (getArgument1() instanceof InstrukcjaLogiczna || getArgument2() instanceof InstrukcjaLogiczna)
            throw new BladWykonania();

        return this.getArgument1().wykonaj() - this.getArgument2().wykonaj();
    }

    public String toJavaString(String filename, int ileWciec) throws BladWykonania {
        String kod = new String();
        int potrzebneWciecia = ileWciec;
        while (potrzebneWciecia > 0) {
            kod += "    ";
            potrzebneWciecia--;
        }
        kod += getArgument1().toJavaString(filename, ileWciec) + " - ("
                + getArgument2().toJavaString(filename, ileWciec) + ")";
        return kod;
    }
}
