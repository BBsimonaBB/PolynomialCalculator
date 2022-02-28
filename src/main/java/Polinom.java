import java.util.ArrayList;
import java.util.Collections;

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
            if(m.getCoef() >= 0)
            tot = tot + "+" + m.toString();
            else tot = tot + "" + m.toString();
        }
        return tot;
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
                if (i.getGrad() == j.getGrad())
                    i.setCoef(i.getCoef() - j.getCoef());
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
        for(Monomial i : polinom)
        {
            i.derivate();
        }
        Collections.sort(polinom);
        return this;
    }
    public Polinom integrate()
    {
        for(Monomial i : polinom)
        {
            i.integrate();
        }
        Collections.sort(polinom);
        return this;
    }
    public Polinom addSameGrades(Polinom poli)
    {
        int index = 0;
        for(Monomial i: polinom)
        {
            if (i.getGrad() == poli.polinom.get(index).getGrad()) {
                i.add(poli.polinom.get(index));
                poli.polinom.remove(index);
            }
            else index ++;
        }
    }
    public Polinom multiply(Polinom poli1)
    {
        Polinom rez = new Polinom(new ArrayList<>());
        for(Monomial i :polinom){
            for(Monomial j :poli1.polinom)
                rez.polinom.add(i.multiply(j));
        }
        Collections.sort(rez.polinom); //acum trebuie adunate elem cu grade egale
        //cod de adaugat...chem add same grades
        return rez;
    }

}
