package zad2.Instrukcje.InstrukcjeLiczbowe;

import zad2.Instrukcje.InstrukcjeLiczbowe.WyrazeniaArytmetyczne.WyrazenieArytmetyczne;
import zad2.Wyjatki.BladWykonania;
import zad2.Instrukcje.Instrukcja;

import java.util.ArrayList;

public class Blok extends InstrukcjaLiczbowa {
    private final ArrayList<Instrukcja> instrukcje;

    public Blok(ArrayList<Instrukcja> instrukcje) {
        super("Blok");
        this.instrukcje = instrukcje;
    }

    public double wykonaj() throws BladWykonania {
        double wynik = 0;
        for (Instrukcja instrukcja: instrukcje)
            wynik = instrukcja.wykonaj();

        return wynik;
    }

    public String toJavaString(String filename, int ileWciec) throws BladWykonania {
        String calyBlok = "";


        for (int i = 0; i < instrukcje.size() - 1; i++)
            calyBlok += instrukcje.get(i).toJavaString(filename, ileWciec);


        Instrukcja ostatniaInstrukcja = instrukcje.get(instrukcje.size() - 1);

        if (ostatniaInstrukcja instanceof Zmienna || ostatniaInstrukcja instanceof Liczba ||
                (ostatniaInstrukcja instanceof WyrazenieArytmetyczne && instrukcje.size() == 1)) {
            calyBlok += "       return " +
                    ostatniaInstrukcja.toJavaString(filename, 0)  +  ";\n";
        }
        else
            calyBlok += ostatniaInstrukcja.toJavaString(filename, ileWciec);


        return calyBlok;
    }

    public ArrayList<Instrukcja> getInstrukcje() {
        return instrukcje;
    }
}
