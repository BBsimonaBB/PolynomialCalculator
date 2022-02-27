public class Monomial implements Comparable<Monomial> {
    private int grad;
    private float coef;

    public Monomial(int grad, float coef) {
        this.grad = grad;
        this.coef = coef;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public float getCoef() {
        return coef;
    }

    public void setCoef(float coef) {
        this.coef = coef;
    }
    @Override
    public String toString() {
        if(grad == 0) return coef + "";
        else if(grad == 1) return  coef + "*x";
        else return coef + "*x^" + grad;
    }

    @Override
    public int compareTo(Monomial o) {
        if(this.coef > o.coef)
            return 1;
        if(this.coef == o.coef)
            return 0;
        else return -1;
    }
}
