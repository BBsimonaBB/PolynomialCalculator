import java.math.BigInteger;

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
    public void addBy(String operand){
        m_total = m_total.add(new BigInteger(operand));
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
        if(!s.contains("+")) return s.indexOf("-");
        else if (!s.contains("-")) return s.indexOf("+");
        else return Math.min(s.indexOf("+"), s.indexOf("-"));
     }
     public int cautIcs(String s)
     {
         if(s.indexOf("^") == s.indexOf("x") + 1) //inseamna ca avem putere
             return alegOperandul(s)-1;
         else return s.indexOf("x");
     }
    public void recongizeOp(String s)
    {
        int piece = cautIcs(s);
        while(piece != -1) {
            System.out.println(s.substring(0, piece+1));
            s = s.substring(piece+1); //asta e un monoid!!
            piece = cautIcs(s);
        }
        System.out.println(s);

    }
}
