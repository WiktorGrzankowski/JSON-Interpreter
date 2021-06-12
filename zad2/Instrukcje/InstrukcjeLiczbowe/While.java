package zad2.Instrukcje.InstrukcjeLiczbowe;

import zad2.Wyjatki.BladWykonania;
import zad2.Instrukcje.Instrukcja;

public class While extends InstrukcjaLiczbowa {
    private final Instrukcja warunek;
    private final Blok blok;

    public While(Instrukcja warunek, Blok blok) {
        super("While");
        this.warunek = warunek;
        this.blok = blok;
    }

    public double wykonaj() throws BladWykonania {
        while (warunek.wykonaj() != 0)
            blok.wykonaj();

        return 0;
    }

    public String toJavaString(String filename, int ileWciec) throws BladWykonania {
        String kod = new String();
        int potrzebneWciecia = ileWciec;
        while (potrzebneWciecia > 0) {
            kod += "    ";
            potrzebneWciecia--;
        }
        potrzebneWciecia = ileWciec;
        kod += "while (" + warunek.toJavaString(filename, 0) + ") {\n" +
                blok.toJavaString(filename, 1);

        while (potrzebneWciecia > 0) {
            kod += "    ";
            potrzebneWciecia--;
        }
        kod += "}\n";

        return kod;
    }

}
