package zad2.Instrukcje.InstrukcjeLogiczne;

import zad2.Wyjatki.BladWykonania;
import zad2.Instrukcje.Instrukcja;
import zad2.Instrukcje.InstrukcjeLiczbowe.Blok;

public class If extends InstrukcjaLogiczna {
    private final Instrukcja warunek;
    private final Blok blok_prawda;
    private final Blok blok_falsz;

    public If(Instrukcja warunek, Blok blok_prawda, Blok blok_falsz) {
        super("If");
        this.warunek = warunek;
        this.blok_prawda = blok_prawda;
        this.blok_falsz = blok_falsz;
    }

    public If(Instrukcja warunek, Blok blok_prawda) {
        super("If");
        this.warunek = warunek;
        this.blok_prawda = blok_prawda;
        blok_falsz = null;
    }

    public double wykonaj() throws BladWykonania {
        if (warunek.wykonaj() != 0)
            return blok_prawda.wykonaj();
        else if (blok_falsz != null)
            return blok_falsz.wykonaj();
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
        kod += "if (" + warunek.toJavaString(filename, 0) + ") {\n" +
                blok_prawda.toJavaString(filename, ileWciec + 1) + "\n}";
        if (blok_falsz != null) {
            if (!blok_falsz.getInstrukcje().isEmpty()) {
                kod += " else {" + blok_falsz.toJavaString(filename, 0) + "\n}\n";
            }
        }


        return kod;
    }
}
