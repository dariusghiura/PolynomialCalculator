import Model.Polynomial;
import Model.PolynomialCalculatorOperations;
import org.junit.Test;
import junit.framework.TestCase;

public class JUnitTest extends TestCase {
    Polynomial p1,p2;
    PolynomialCalculatorOperations model = new PolynomialCalculatorOperations();

    public void setUp(){
        p1 = new Polynomial("2x^2-3x+1");
        p2 = new Polynomial("x-3");
        System.out.println("setUp: p1: " + p1 + ", p2: " + p2);
    }

    @Test
    public void testAdd(){
        assertEquals("2.0x^2-2.0x^1-2.0", model.addPolynomials(p1, p2).toString().replace(" ", ""));
    }

    @Test
    public void testSub(){
        assertEquals("2.0x^2-4.0x^1+4.0", model.subPolynomials(p1, p2).toString().replace(" ", ""));
    }

    @Test
    public void testMul(){
        assertEquals("2.0x^3-9.0x^2+10.0x^1-3.0", model.mulPolynomials(p1, p2).toString().replace(" ", ""));
    }

    @Test
    public void testDiv(){
        model.divPolynomials(p1,p2);
        assertTrue(model.getResult().toString().replace(" ", "").equals("2.0x^1+3.0") && model.getRemainder().toString().replace(" ","").equals("10.0"));
    }

    @Test
    public void testDeriv(){
        assertEquals("4.0x^1-3.0", model.derivPolynomials(p1).toString().replace(" ", ""));
    }

    @Test
    public void testIntegr(){
        assertEquals("0.66x^3-1.5x^2+x^1", model.integrPolynomials(p1).toString().replace(" ", ""));
    }


    public void tearDown(){
        p1 = new Polynomial("0");
        p2 = new Polynomial("0");
        System.out.println("tearDown: p1: " + p1 + ", p2: " + p2);
    }
}