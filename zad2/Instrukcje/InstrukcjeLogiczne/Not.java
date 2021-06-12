package zad2.Instrukcje.InstrukcjeLogiczne;

import zad2.Instrukcje.Instrukcja;
import zad2.Wyjatki.BladWykonania;

public class Not extends InstrukcjaLogiczna {
    private final Instrukcja argument;

    public Not(Instrukcja argument) {
        super("Not");
        this.argument = argument;
    }

    public double wykonaj() throws BladWykonania {
        if (argument.wykonaj() == 0)
            return 1;
        else
            return 0;
    }

    public String toJavaString(String filename, int ileWciec) throws BladWykonania {
        return "!(" + argument.toJavaString(filename, ileWciec) + ")";
    }

}
