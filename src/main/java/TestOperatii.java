import junit.framework.TestCase;

import java.util.ArrayList;

public class TestOperatii extends TestCase{

    private static PolynomModel pm = new PolynomModel();
    public static void setUpBeforeClass() throws Exception {
        pm = new PolynomModel();
    }

    public TestOperatii() {
    }

    public void testAdunare1() throws Exception {
        UserText u1 = new UserText("x^2+2*x^2-x+3");
        UserText u2 = new UserText("-x^2+4");
        String r = "+2.0*x^2-1.0*x+7.0";
        Polinom p1 = u1.convertUserText();
        Polinom p2 = u2.convertUserText();
        assertEquals(r, pm.addBy(p1,p2).toString());
    }
    public void testScadere1() throws Exception{
        UserText u1 = new UserText("x^2+2*x^2-x+3");
        UserText u2 = new UserText("-x^2+4");
        String r = "+4.0*x^2-1.0*x-1.0";
        Polinom p1 = u1.convertUserText();
        Polinom p2 = u2.convertUserText();
        assertEquals(r, pm.substractBy(p1,p2).toString());
    }
    public void testDerivare1() throws Exception{
        UserText u1 = new UserText("x^2+2*x^2-x+3");;
        String r = "+6.0*x-1.0";
        Polinom p1 = u1.convertUserText();
        assertEquals(r, pm.derivateBy(p1).toString());
    }
    public void testIntegrare1() throws Exception{
        UserText u1 = new UserText("x^2+2*x^2-x+3");;
        String r = "+1.0*x^3-0.5*x^2+3.0*x";
        Polinom p1 = u1.convertUserText();
        assertEquals(r, pm.integrateBy(p1).toString());
    }
    public void testInmultire1() throws  Exception{
        UserText u1 = new UserText("x+1");
        UserText u2 = new UserText("x-1");
        String r = "+1.0*x^2-1.0";
        Polinom p1 = u1.convertUserText();
        Polinom p2 = u2.convertUserText();
        assertEquals(r, pm.multiplyBy(p1,p2).toString());
    }
    public void testImpartire1() throws  Exception{
        UserText u1 = new UserText("2*x^3-5*x^2-4*x+3");
        UserText u2 = new UserText("x-0.5");
        String r = "+2.0*x^2-4.0*x-6.0,    r = 0.0";
        Polinom p1 = u1.convertUserText();
        Polinom p2 = u2.convertUserText();
        assertEquals(r, pm.divideBy(p1,p2).toString() + ",    r = " + p1.toString());
    }
    public void testAdunare2() throws Exception {
        UserText u1 = new UserText("4*x^5-3*x^4+x^2-8*x+1");
        UserText u2 = new UserText("3*x^4-x^3+x^2+2*x-1");
        String r = "+4.0*x^5-1.0*x^3+2.0*x^2-6.0*x";
        Polinom p1 = u1.convertUserText();
        Polinom p2 = u2.convertUserText();
        assertEquals(r, pm.addBy(p1,p2).toString());
    }
    public void testScadere2() throws Exception{
        UserText u1 = new UserText("4*x^5-3*x^4+x^2-8*x+1");
        UserText u2 = new UserText("3*x^4-x^3+x^2+2*x-1");
        String r = "+4.0*x^5-6.0*x^4+1.0*x^3-10.0*x+2.0";
        Polinom p1 = u1.convertUserText();
        Polinom p2 = u2.convertUserText();
        assertEquals(r, pm.substractBy(p1,p2).toString());
    }
    public void testInmultire2() throws Exception{
        UserText u1 = new UserText("3*x^2-x+1");
        UserText u2 = new UserText("x-2");
        String r = "+3.0*x^3-7.0*x^2+3.0*x-2.0";
        Polinom p1 = u1.convertUserText();
        Polinom p2 = u2.convertUserText();
        assertEquals(r, pm.multiplyBy(p1,p2).toString());
    }
    public void testIntegrare2() throws Exception{
        UserText u1 = new UserText("x^3+4*x^2+5");
        String r = "+0.25*x^4+1.3333334*x^3+5.0*x";
        Polinom p1 = u1.convertUserText();
        assertEquals(r, pm.integrateBy(p1).toString());
    }
    public void testDerivare2() throws  Exception{
        UserText u1 = new UserText("x^3-2*x^2+6*x-5");
        String r = "+3.0*x^2-4.0*x+6.0";
        Polinom p1 = u1.convertUserText();
        assertEquals(r, pm.derivateBy(p1).toString());
    }
    public void testImpartire2() throws  Exception{
        UserText u1 = new UserText("x^3-2*x^2+6*x-5");
        UserText u2 = new UserText("x^2-1");
        String r = "+1.0*x-2.0,    r = +7.0*x-7.0";
        Polinom p1 = u1.convertUserText();
        Polinom p2 = u2.convertUserText();
        assertEquals(r, pm.divideBy(p1,p2).toString() + ",    r = " + p1.toString());
    }
    public void testAdunare3() throws Exception {
        UserText u1 = new UserText("x+3-3*x^2");
        UserText u2 = new UserText("-x^2+4*x^4");
        String r = "+4.0*x^4-4.0*x^2+1.0*x+3.0";
        Polinom p1 = u1.convertUserText();
        Polinom p2 = u2.convertUserText();
        assertEquals(r, pm.addBy(p1,p2).toString());
    }
    public void testScadere3() throws Exception {
        UserText u1 = new UserText("x+3-3*x^2");
        UserText u2 = new UserText("x+3-3*x^2");
        String r = "0.0";
        Polinom p1 = u1.convertUserText();
        Polinom p2 = u2.convertUserText();
        assertEquals(r, pm.substractBy(p1,p2).toString());
    }
    public void testInmultire3() throws Exception{
        UserText u1 = new UserText("-1");
        UserText u2 = new UserText("-x-1-x^3-x");
        String r = "+1.0*x^3+2.0*x+1.0";
        Polinom p1 = u1.convertUserText();
        Polinom p2 = u2.convertUserText();
        assertEquals(r, pm.multiplyBy(p1,p2).toString());
    }
    public void testImpartire3() throws  Exception {
        UserText u1 = new UserText("x-1");
        UserText u2 = new UserText("x^2");
        String r = "0.0,    r = +1.0*x-1.0";
        Polinom p1 = u1.convertUserText();
        Polinom p2 = u2.convertUserText();
        assertEquals(r, pm.divideBy(p1, p2).toString() + ",    r = " + p1.toString());
    }
    public void testDerivare3() throws  Exception{
        UserText u1 = new UserText("1232436");
        String r = "0.0";
        Polinom p1 = u1.convertUserText();
        assertEquals(r, pm.derivateBy(p1).toString());
    }
    public void testIntegrare3() throws Exception{
        UserText u1 = new UserText("0");
        String r = "0.0";
        Polinom p1 = u1.convertUserText();
        assertEquals(r, pm.integrateBy(p1).toString());
    }
}
