package zad2.Instrukcje.InstrukcjeLiczbowe.WyrazeniaArytmetyczne;

import zad2.Instrukcje.Instrukcja;
import zad2.Instrukcje.InstrukcjeLiczbowe.InstrukcjaLiczbowa;

public abstract class WyrazenieArytmetyczne extends InstrukcjaLiczbowa {
    private final Instrukcja argument1;
    private final Instrukcja argument2;
    public WyrazenieArytmetyczne(String typ, Instrukcja argument1, Instrukcja argument2) {
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
