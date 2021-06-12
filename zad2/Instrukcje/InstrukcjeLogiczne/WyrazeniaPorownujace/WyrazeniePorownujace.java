package zad2.Instrukcje.InstrukcjeLogiczne.WyrazeniaPorownujace;

import zad2.Instrukcje.Instrukcja;
import zad2.Instrukcje.InstrukcjeLogiczne.InstrukcjaLogiczna;

public abstract class WyrazeniePorownujace extends InstrukcjaLogiczna {
    private final Instrukcja argument1;
    private final Instrukcja argument2;

    public WyrazeniePorownujace(Instrukcja argument1, Instrukcja argument2, String typ) {
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
