package Model;
import java.util.Collections;

public class PolynomialCalculatorOperations {
    private Polynomial result;
    private Polynomial remainder;

    public PolynomialCalculatorOperations(){
        reset();
    }

    public void reset(){
        result = new Polynomial();
        remainder = new Polynomial();
    }

    public Polynomial getResult() {
        return result;
    }

    public Polynomial getRemainder() {
        return remainder;
    }

    public Polynomial addPolynomials(Polynomial p1, Polynomial p2){

        reset();
        result.getMonomials().addAll(p1.getMonomials()); // Adaugam toate monoamele intr-un polinom nou
        result.getMonomials().addAll(p2.getMonomials()); // si apelam metoda sortPolynomial
        result.sortPolynomial();                         // care aduna elementele cu acelasi exponent si le sorteaza
        return result;
    }

    public Polynomial subPolynomials(Polynomial p1, Polynomial p2){

        reset();
        result.getMonomials().addAll(p1.getMonomials()); // Aceeasi idee ca la adunare, doar ca adaugam
        for (Monomial m : p2.getMonomials()) {           // monoamele celui de al doilea polinom cu semn schimbat
            m.setCoef(-m.getCoef());
        }
        result.getMonomials().addAll(p2.getMonomials());
        result.sortPolynomial();
        return result;
    }

    public Polynomial mulPolynomials(Polynomial p1, Polynomial p2){

        reset();
        if (p1.getMonomials().isEmpty() || p2.getMonomials().isEmpty())
            return result;
        for (Monomial m : p1.getMonomials()) {          // Aceeasi idee
            for (Monomial n : p2.getMonomials()) {
                result.getMonomials().add(new Monomial(m.getCoef() * n.getCoef(), m.getExp() + n.getExp()));
            }
        }
        result.sortPolynomial();
        return result;
    }

    public void divPolynomials(Polynomial p1, Polynomial p2){

        if (p2.toString().equals("0.0"))
            throw new ArithmeticException();

        Collections.sort(p1.getMonomials());
        Collections.sort(p2.getMonomials());

        Polynomial rest = p1;
        Polynomial res = new Polynomial();

        while (!rest.getMonomials().isEmpty() && p2.getMonomials().get(0).getExp() <= rest.getMonomials().get(0).getExp()){
            Polynomial t = new Polynomial(new Monomial(rest.getMonomials().get(0).getCoef() / p2.getMonomials().get(0).getCoef() ,rest.getMonomials().get(0).getExp() - p2.getMonomials().get(0).getExp()));
            res = addPolynomials(res,t);
            rest = subPolynomials(rest, mulPolynomials(t,p2));
        }
        result = res;
        remainder = rest;
    }

    public Polynomial derivPolynomials(Polynomial p){

        reset();
        for (Monomial m : p.getMonomials()) {
            if (m.getExp() == 0)
                continue;
            result.getMonomials().add(new Monomial(m.getCoef() * m.getExp(), m.getExp() - 1));
        } // Adaugam in polinom monomul cu noul coeficient = coef*exp si exp = exp-1
        return result;
    }

    public Polynomial integrPolynomials(Polynomial p) {

        reset();
        for (Monomial m : p.getMonomials()) {
            result.getMonomials().add(new Monomial(m.getCoef() / ( m.getExp() + 1), m.getExp() + 1));
        } // Adaugam in polinom monomul cu noul coeficient = coef/(exp+1) si exp = exp+1
        return result;
    }
}
