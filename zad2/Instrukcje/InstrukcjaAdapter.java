package zad2.Instrukcje;


import com.google.gson.*;
import zad2.Instrukcje.InstrukcjeLiczbowe.*;
import zad2.Instrukcje.InstrukcjeLiczbowe.WyrazeniaArytmetyczne.Dzielenie;
import zad2.Instrukcje.InstrukcjeLiczbowe.WyrazeniaArytmetyczne.Minus;
import zad2.Instrukcje.InstrukcjeLiczbowe.WyrazeniaArytmetyczne.Plus;
import zad2.Instrukcje.InstrukcjeLiczbowe.WyrazeniaArytmetyczne.Razy;
import zad2.Instrukcje.InstrukcjeLogiczne.*;
import zad2.Instrukcje.InstrukcjeLogiczne.Spojniki.And;
import zad2.Instrukcje.InstrukcjeLogiczne.Spojniki.Or;
import zad2.Instrukcje.InstrukcjeLogiczne.WyrazeniaPorownujace.*;

import java.lang.reflect.Type;

public class InstrukcjaAdapter implements JsonDeserializer<Instrukcja> {


    @Override
    public Instrukcja deserialize(JsonElement json, Type type,
                                  JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String typ = jsonObject.get("typ").getAsString();
        switch (typ) {
            case "Blok":
                return jsonDeserializationContext.deserialize(json, Blok.class);
            case "If":
                return jsonDeserializationContext.deserialize(json, If.class);
            case "While":
                return jsonDeserializationContext.deserialize(json, While.class);
            case "Przypisanie":
                return jsonDeserializationContext.deserialize(json, Przypisanie.class);
            case "Plus":
                return jsonDeserializationContext.deserialize(json, Plus.class);
            case "Minus":
                return jsonDeserializationContext.deserialize(json, Minus.class);
            case "Razy":
                return jsonDeserializationContext.deserialize(json, Razy.class);
            case "Dzielenie":
                return jsonDeserializationContext.deserialize(json, Dzielenie.class);
            case "<=":
                return jsonDeserializationContext.deserialize(json, MniejszeRowne.class);
            case "<":
                return jsonDeserializationContext.deserialize(json, Mniejsze.class);
            case ">=":
                return jsonDeserializationContext.deserialize(json, WiekszeRowne.class);
            case ">":
                return jsonDeserializationContext.deserialize(json, Wieksze.class);
            case "==":
                return jsonDeserializationContext.deserialize(json, Rowne.class);
            case "Liczba":
                return jsonDeserializationContext.deserialize(json, Liczba.class);
            case "And":
                return jsonDeserializationContext.deserialize(json, And.class);
            case "Or":
                return jsonDeserializationContext.deserialize(json, Or.class);
            case "Not":
                return jsonDeserializationContext.deserialize(json, Not.class);
            case "InstrukcjaLogiczna":
                return jsonDeserializationContext.deserialize(json, InstrukcjaLogiczna.class);
            case "True":
                return jsonDeserializationContext.deserialize(json, True.class);
            case "False":
                return jsonDeserializationContext.deserialize(json, False.class);
            case "Zmienna":
                return jsonDeserializationContext.deserialize(json, Zmienna.class);
            default:
                throw new JsonParseException("Błąd instrukcji");
        }
    }
}
