import java.util.ArrayList;

public class Polinom {
    ArrayList<Monomial> polinom;

    public Polinom(ArrayList<Monomial> p) {
        this.polinom = p;
    }

    @Override
    public String toString() {
        return "Polinom{" +
                "polinom=" + polinom +
                '}';
    }
}
