import java.math.BigInteger;

public class PolynomModel {
    //... Constants
    static final String INITIAL_VALUE = "0";

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
    public Polinom makePolynom(UserText u) throws InvalidTextException
    {
        u.verifyText();
        Polinom p = u.convertUserText();
        return p;
    }
    public Polinom multiplyBy(Polinom poli1, Polinom poli2) {
        return poli1.multiply(poli2);
    }
    public Polinom divideBy(Polinom poli1, Polinom poli2)
    {
        return poli2.divide(poli1);
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
}
