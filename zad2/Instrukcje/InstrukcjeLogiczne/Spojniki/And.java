package zad2.Instrukcje.InstrukcjeLogiczne.Spojniki;

import zad2.Instrukcje.Instrukcja;
import zad2.Wyjatki.BladWykonania;

public class And extends Spojnik {
    public And(Instrukcja argument1, Instrukcja argument2) {
        super("And", argument1, argument2);
    }

    public double wykonaj() throws BladWykonania {
        if (this.getArgument1().wykonaj() != 0 && this.getArgument2().wykonaj() != 0)
            return 1;
        else
            return 0;
    }

    public String toJavaString(String filename, int ileWciec) throws BladWykonania {
        return getArgument1().toJavaString(filename, ileWciec) + " && "
                + getArgument2().toJavaString(filename, ileWciec);
    }
}
