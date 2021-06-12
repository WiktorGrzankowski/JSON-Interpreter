package zad2.Instrukcje;

import zad2.Wyjatki.BladWykonania;

import java.io.IOException;

public abstract class Instrukcja {
    private final String typ;

    public Instrukcja(String typ) {
        this.typ = typ;
    }

    public String getTyp() {
        return typ;
    }

    //    public abstract void toJava(String filename) throws IOException, BladWykonania;
    public abstract String toJavaString(String filename, int ileWciec) throws BladWykonania;
    public abstract double wykonaj() throws BladWykonania;
}
