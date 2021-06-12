package zad2.Instrukcje.InstrukcjeLogiczne.Spojniki;

import zad2.Instrukcje.Instrukcja;
import zad2.Instrukcje.InstrukcjeLogiczne.InstrukcjaLogiczna;

public abstract class Spojnik extends InstrukcjaLogiczna {
    private Instrukcja argument1;
    private Instrukcja argument2;

    public Spojnik(String typ, Instrukcja argument1, Instrukcja argument2) {
        super(typ);
        this.argument1 = argument1;
        this.argument2 = argument2;
    }

    public Instrukcja getArgument1() {
        return argument1;
    }

    public Instrukcja getArgument2() {
        return argument2;
    }
}
