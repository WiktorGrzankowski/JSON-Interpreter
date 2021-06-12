package zad2.Instrukcje.InstrukcjeLiczbowe;

import zad2.Robson;

public class Zmienna extends InstrukcjaLiczbowa {
    private final String nazwa;

    public Zmienna(String nazwa) {
        super("Zmienna");
        this.nazwa = nazwa;
    }

    public double wykonaj() {
        return Robson.getZmienne().get(nazwa);
    }

    public String toJavaString(String filename, int ileWciec) {
        return nazwa;
    }
}
