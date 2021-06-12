package zad2.Instrukcje.InstrukcjeLogiczne.WyrazeniaPorownujace;

import zad2.Instrukcje.Instrukcja;
import zad2.Wyjatki.BladWykonania;

public class Wieksze extends WyrazeniePorownujace {

    public Wieksze(Instrukcja argument1, Instrukcja argument2) {
        super(argument1, argument2, ">");
    }

    public double wykonaj() throws BladWykonania {
        if (this.getArgument1().wykonaj() > this.getArgument2().wykonaj())
            return 1;
        else
            return 0;
    }

    public String toJavaString(String filename, int ileWciec) throws BladWykonania {
        String kod = new String();
        int potrzebneWciecia = ileWciec;
        while (potrzebneWciecia > 0) {
            kod += "    ";
            potrzebneWciecia--;
        }
        kod += getArgument1().toJavaString(filename, ileWciec)
                + " > " + getArgument2().toJavaString(filename, ileWciec);
        return kod;
    }
}
