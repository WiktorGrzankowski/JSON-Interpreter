package zad2.Instrukcje.InstrukcjeLogiczne;

public class False extends InstrukcjaLogiczna {
    public False() {
        super("False");
    }

    public double wykonaj() {
        return 0;
    }

    public String toJavaString(String filename, int ileWciec) {
        return "False";
    }
}
