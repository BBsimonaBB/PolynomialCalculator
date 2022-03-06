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


    public float getCoef() {
        return coef;
    }

    public void setCoef(float coef) {
        this.coef = coef;
    }
    @Override
    public String toString() {
        if(coef == 0) return "";
        else {
            if(grad == 0) return coef + "";
            else if (grad == 1) return coef + "*x";
            else return coef + "*x^" + grad;
        }
    }

    @Override
    public int compareTo(Monomial o) {
        return Integer.compare(o.grad, this.grad);
    }
    public void derivate() {
        coef = coef * grad;
        if (grad != 0)
            grad--;
    }
    public void integrate()
    {
        grad++;
        coef = coef/grad;
    }
    public Monomial multiply(Monomial m)
    {
        Monomial rez = new Monomial(0,0);
        rez.coef = coef * m.coef;
        rez.grad = grad + m.grad;
        return rez;
    }
    public void add(Monomial m)
    {
        if (grad == m.grad)
            coef = coef + m.coef;
    }
    public void substract(Monomial m)
    {
        if (grad == m.grad)
            coef = (coef - m.coef);
    }
    public Monomial divide(Monomial m)
    {
        if(grad < m.grad)
            return this;
        else
            return new Monomial(grad-m.grad, coef/m.coef);
    }

    public float recogDivSign(String s)
    {
        if(s.contains("/")) //avem cv fractie
        {
            int poz = s.indexOf("/");
            return (float)Integer.parseInt(s.substring(0,poz))/Integer.parseInt(s.substring(poz+1));
        }
        else if(s.contains("*"))
        {
            int poz = s.indexOf("*");
            return (float)Integer.parseInt(s.substring(0,poz)) * Integer.parseInt(s.substring(poz+1));
        }
        else return Float.parseFloat(s);
    }
    public int setGrad(String s)
    {
        if(!s.contains("^")) {
            if (s.contains("x"))
                return 1;
            else return 0;
        }
        else if(!s.contains("x"))
            return 0;
        else {
            int poz = s.indexOf("^");
            return Integer.parseInt(s.substring(poz+1));
        }
    }
    public float setCoeficient(String s)
    {
        if(!s.contains("x"))
            return (recogDivSign(s));
        if(!s.contains("*")){
        if (s.charAt(0) == '-')
            return -1;
        else return 1;
         }
        else{
        int poz = s.indexOf("*");
        return recogDivSign(s.substring(0, poz));
    }
    }
    public Monomial recognizeMonoid(String s)
    {
        grad = setGrad(s);
        coef = setCoeficient(s);
        return this;
    }
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj instanceof Monomial) {
            Monomial e = (Monomial) obj;
            return (this.grad == e.grad) &&
                    (this.coef == e.coef) ;
        }
        return false;
    }
}
