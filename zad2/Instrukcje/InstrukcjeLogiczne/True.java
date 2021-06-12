package zad2.Instrukcje.InstrukcjeLogiczne;

public class True extends InstrukcjaLogiczna {
    public True() {
        super("True");
    }

    public double wykonaj() {
        return 1;
    }

    public String toJavaString(String filename, int ileWciec) {
        return "True";
    }
}
