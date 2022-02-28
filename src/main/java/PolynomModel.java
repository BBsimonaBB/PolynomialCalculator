import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class PolynomModel {
    //... Constants
    static final String INITIAL_VALUE = "1";

    //... Member variable defining state of calculator.
    private BigInteger m_total; // The total current value state.

    //============================================================== constructor
    /** Constructor */
    PolynomModel() {
        reset();
    }

    //==================================================================== reset
    /** Reset to initial value. */
    public void reset() {
        m_total = new BigInteger(INITIAL_VALUE);
    }

    //=============================================================== multiplyBy
    /** Multiply current total by a number.
     *@param operand Number (as string) to multiply total by.
     */
    public void multiplyBy(String operand) {
        m_total = m_total.multiply(new BigInteger(operand));
    }
    public Polinom addBy(Polinom poli1, Polinom poli2){
        return poli1.addition(poli2);
    }
    public Polinom substractBy(Polinom poli1, Polinom poli2){
        return poli1.substract(poli2);
    }
    public Polinom derivateBy(Polinom poli1)
    {
        return poli1.derivate();
    }
    public Polinom integrateBy(Polinom poli1)
    {
        return poli1.integrate();
    }
//================================================================= setValue
    /** Set the total value.
     *@param value New value that should be used for the calculator total.
     *
     */
    public void setValue(String value) {
        m_total = new BigInteger(value);
    }

//================================================================= getValue
    /** Return current calculator total. */
    public String getValue() {
        return m_total.toString();
    }
    public int alegOperandul(String s)
    {
        if(s.indexOf("+",1) == -1) return s.indexOf("-",1);
        else if (s.indexOf("-",1) == -1) return s.indexOf("+",1);
        else
            return Math.min(s.indexOf("+",1), s.indexOf("-",1));
}
    public int cautIcs(String s)
     {
         if(s.indexOf("^") == s.indexOf("x") + 1)
             return alegOperandul(s)-1;
         else return s.indexOf("x");
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
         Monomial m = new Monomial(0,0);
         if(!s.contains("x")) {
             m.setGrad(0);
             m.setCoef(recogDivSign(s));
         }
         else{
             if(!s.contains("^")) {
                 m.setGrad(1);
             }
             else{
                 int poz = s.indexOf("^");
                 m.setGrad(Integer.parseInt(s.substring(poz+1)));
             }
             if(!s.contains("*"))
                 if(s.charAt(0) == '-')
                     m.setCoef((float)-1);
                 else m.setCoef((float)1);
             else {
                 int poz = s.indexOf("*");
                 m.setCoef(recogDivSign(s.substring(0,poz)));
             }
         }
         return m;
     }
    public Polinom makePolynom(String s)
    {
        if(!s.equals("")) {
            s.trim();
            int piece = cautIcs(s);
            ArrayList<Monomial> pMonomials = new ArrayList<>(10);
            while (piece > -1) {
                pMonomials.add(recognizeMonoid(s.substring(0, piece + 1)));
                s = s.substring(piece + 1); //asta e un monoid!!
                piece = cautIcs(s);
            }
            if(!s.equals(""))
                 pMonomials.add(recognizeMonoid(s));

            Polinom p = new Polinom(pMonomials);
            return p;
        }
        else return null;

    }
}
