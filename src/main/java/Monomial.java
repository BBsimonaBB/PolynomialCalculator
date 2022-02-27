public class Monomial {
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
        return "Monomial{" +
                "grad=" + grad +
                ", coef=" + coef +
                '}';
    }
}
