package zad2;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import zad2.Instrukcje.Instrukcja;
import zad2.Instrukcje.InstrukcjaAdapter;
import zad2.Instrukcje.InstrukcjeLiczbowe.*;
import zad2.Instrukcje.InstrukcjeLogiczne.InstrukcjaLogiczna;
import zad2.Wyjatki.BladWykonania;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Robson {
    private final static HashMap<String, Double> zmienne = new HashMap<>();
    private Blok kod;
    private static String kodString;

    public Robson() {
    }

    public static void main(String[] args) throws IOException, BladWykonania {
        String filenameFromJSON = args[0];
        String filenameToJSON = args[1];
        String filenameToJava = args[2];

        Robson program = new Robson();

        program.fromJSON(filenameFromJSON);
        program.toJSON(filenameToJSON);
        program.toJava(filenameToJava);
        System.out.println(program.wykonaj());
    }

    public void toJSON(String filename) throws IOException {
        Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(filename);
        gson.toJson(kod, writer);
        writer.close();
    }

    public void fromJSON(String filename) throws IOException, BladWykonania {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Instrukcja.class, new InstrukcjaAdapter());
        gsonBuilder.registerTypeAdapter(InstrukcjaLogiczna.class, new InstrukcjaAdapter());
        gsonBuilder.registerTypeAdapter(InstrukcjaLiczbowa.class, new InstrukcjaAdapter());

        Gson gson = gsonBuilder.create();

        JsonReader reader = new JsonReader(new FileReader(filename));
        kod = gson.fromJson(reader, Instrukcja.class);
        kod.wykonaj(); // Tworzenie programu.
    }

    public double wykonaj() throws BladWykonania {
        return kod.wykonaj();
    }

    public void toJava(String filename) throws IOException, BladWykonania {
        FileWriter writer = new FileWriter(filename);
        writer.write(toJavaString(filename));
        writer.close();
    }

    public String toJavaString(String filename) throws BladWykonania {
        kodString = "public class toJavaClass {\n" + "  " +
                        "public static double program() {\n";

        for (String klucz: zmienne.keySet()) {
            kodString += "double " + klucz + " = 0;\n";
        }

        kodString += kod.toJavaString(filename, 2);



        kodString += "  }\n public static void main(String[] args) {\n      System.out.println(program());\n}\n" +
                        "}";
        return kodString;
    }

    public static String getKodString() {
        return kodString;
    }

    public static HashMap<String, Double> getZmienne() {
        return zmienne;
    }
}
