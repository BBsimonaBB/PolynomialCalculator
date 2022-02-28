import java.math.BigInteger;
import java.util.ArrayList;

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
     * @param operand Number (as string) to multiply total by.
     * @return
     */
    public Polinom multiplyBy(Polinom poli1, Polinom poli2) {
        return poli1.multiply(poli2);
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
    public int alegOperand(String s)
    {
        if(s.indexOf("+",1) == -1) return s.indexOf("-",1);
        else if (s.indexOf("-",1) == -1) return s.indexOf("+",1);
        else
            return Math.min(s.indexOf("+",1), s.indexOf("-",1));
}
    public int cautIcs(String s)
     {
         if(s.indexOf("^") == s.indexOf("x") + 1) //daca am putere
             return alegOperand(s)-1;
         else return s.indexOf("x");
     }
    public Polinom makePolynom(String s)
    {
        if(!s.equals("")) {
            int piece = cautIcs(s);
            ArrayList<Monomial> pMonomials = new ArrayList<>();
            while (piece > -1) {
                Monomial m = new Monomial(0,0);
                m.recognizeMonoid(s.substring(0, piece + 1));
                pMonomials.add(m);
                s = s.substring(piece + 1); //asta e un monoid!!
                piece = cautIcs(s);
            }
            if(!s.equals("")) {
                Monomial m = new Monomial(0, 0);
                pMonomials.add(m.recognizeMonoid(s));
            }
            return new Polinom(pMonomials);
        }
        else return null;
    }
}
