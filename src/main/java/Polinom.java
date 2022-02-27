import java.util.ArrayList;

public class Polinom {
    ArrayList<Monomial> polinom;

    public Polinom(ArrayList<Monomial> p) {
        this.polinom = p;
    }

    public ArrayList<Monomial> getPolinom() {
        return polinom;
    }

    public void setPolinom(ArrayList<Monomial> polinom) {
        this.polinom = polinom;
    }

    @Override
    public String toString() {
        String tot = "";
        for(Monomial m : polinom) {
            if(m.getCoef() > 0)
            tot = tot + "+" + m.toString();
            else tot = tot + "" + m.toString();
        }
        return tot;
    }
}
