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
        if(this.grad > o.grad)
            return -1;
        if(this.grad == o.grad)
            return 0;
        else return 1;
    }
    public Monomial derivate() {
        coef = coef * grad;
        if (grad != 0)
            grad--;
        return this;
    }
    public Monomial integrate()
    {
        grad++;
        coef = coef/grad;
        return this;
    }
    public Monomial multiply(Monomial m)
    {
        Monomial rez = new Monomial(0,0);
        rez.coef = coef * m.coef;
        rez.grad = grad + m.grad;
        return rez;
    }
    public Monomial add(Monomial m)
    {
        if (grad == m.grad)
            coef = coef + m.coef;
        return this;
    }

    public float recogDivSign(String s)
    {
        if(s.contains("/")) //avem cv fractie
        {
            int poz = s.indexOf("/");
            return (float)Integer.parseInt(s.substring(0,poz))/Integer.parseInt(s.substring(poz+1));
        }
        else {
            if (s.contains("+")) return Float.parseFloat(s.substring(1));
            else if (s.contains("-")) return (float) (-1) * Float.parseFloat(s.substring(1));
            else return Float.parseFloat(s);
        }
    }

    public Monomial recognizeMonoid(String s)
    {
        if(!s.contains("x")) {
            grad = 0;
            coef = Float.parseFloat(s); // s=-1 => coef = -1 (exemplu...ia singur minusul)
        }
        else{
            if(!s.contains("^")) {
                grad = 1;
            }
            else{
                int poz = s.indexOf("^");
                grad = Integer.parseInt(s.substring(poz+1));
            }
            if(!s.contains("*"))
                if(s.charAt(0) == '-')
                    coef = -1;
                else coef = 1;
            else {
                int poz = s.indexOf("*");
                coef = Float.parseFloat(s.substring(0,poz));
            }
        }
        return this;
    }
}
