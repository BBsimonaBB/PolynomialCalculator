import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

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
            tot = tot + "+" + m;
            else tot = tot + "" + m;
        }
        return tot;
    }
    Polinom arrange()
    {
        this.addSameGrades();
        Collections.sort(this.polinom);
        return this;
    }
    public Polinom addition(Polinom poli)
    {
        for(Monomial i : polinom) {
            for (Monomial j : poli.polinom) {
                i.add(j);
            }
        }
        for(Monomial j : poli.polinom){
            boolean gasit = false;
            for(Monomial i :polinom) {
                if (i.getGrad() == j.getGrad()) {
                    gasit = true;
                    break;
                }
            }
            if (!gasit)
                polinom.add(j);
        }
        Collections.sort(polinom);
    return this;
    }
    public  Polinom substract(Polinom poli)
    {
        for(Monomial i : polinom) {
            for (Monomial j : poli.polinom) {
                i.substract(j);
            }
        }
        for(Monomial j : poli.polinom){
            boolean gasit = false;
            for(Monomial i :polinom) {
                if (i.getGrad() == j.getGrad()) {
                    gasit = true;
                    break;
                }
            }
            if (!gasit) {
                j.setCoef((-1) * j.getCoef());
                polinom.add(j);
            }
        }
        Collections.sort(polinom);
        return this;
    }
    public Polinom derivate()
    {
        Collections.sort(polinom);
        for(Monomial i : polinom)
        {
            i.derivate();
        }
        Collections.sort(polinom);
        return this;
    }
    public Polinom integrate()
    {
        Collections.sort(polinom);
        for(Monomial i : polinom)
        {
            i.integrate();
        }
        Collections.sort(polinom);
        return this;
    }
    public Polinom addSameGrades()
    {
        Collections.sort(polinom);
        for(int i=0;i<polinom.size() - 2;i++) {
                    if (polinom.get(i).getGrad() == polinom.get(i+1).getGrad()) {
                        polinom.get(i).setCoef(polinom.get(i).getCoef() + polinom.get(i+1).getCoef());
                        polinom.remove(i+1);
                    }
                }
        return this;
    }
    public Polinom multiply(Polinom poli1)
    {
        Polinom rez = new Polinom(new ArrayList<>());
        for(Monomial i :polinom){
            for(Monomial j :poli1.polinom)
                rez.polinom.add(i.multiply(j));
        }
        return rez.addSameGrades();
    }
    public Polinom divide(Polinom poli1)
    {
        Collections.sort(poli1.polinom);
        Collections.sort(this.polinom);
        Polinom rez = new Polinom(new ArrayList<>());
        while(poli1.polinom.get(0).getGrad() >= polinom.get(0).getGrad() && poli1.polinom.get(0).getCoef() != 0)
        {
            rez.polinom.add(poli1.polinom.get(0).divide(polinom.get(0)));
            Polinom deScazut = new Polinom(new ArrayList<>());
            deScazut.polinom.add(poli1.polinom.get(0).divide(polinom.get(0)));
            poli1 = poli1.substract(this.multiply(deScazut));
            deScazut.polinom.remove(0);
            if(poli1.polinom.get(0).getCoef() == 0)
                poli1.polinom.remove(0);
            }
        rez.addSameGrades();
        return rez;
    }
}
