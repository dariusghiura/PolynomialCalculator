package Model;

public class PolynomialCalculatorOperations {
    private Polynomial result;
    private Polynomial remainder = new Polynomial("0");

    public PolynomialCalculatorOperations(){
        resetResult();
    }

    public void resetResult(){
        result = new Polynomial("0");
    }

    public Polynomial getResult() {
        return result;
    }

    public Polynomial getRemainder() {
        return remainder;
    }

    public Polynomial addPolynomials(Polynomial p1, Polynomial p2){

        result = new Polynomial("0");
        result.getMonomials().addAll(p1.getMonomials()); // Adaugam toate monoamele intr-un polinom nou
        result.getMonomials().addAll(p2.getMonomials()); // si apelam metoda sortPolynomial
        result.sortPolynomial();                         // care aduna elementele cu acelasi exponent si le sorteaza
        return result;
    }

    public Polynomial subPolynomials(Polynomial p1, Polynomial p2){

        result = new Polynomial("0");
        result.getMonomials().addAll(p1.getMonomials()); // Aceeasi idee ca la adunare, doar ca adaugam
        for (Monomial m : p2.getMonomials()) {           // monoamele celui de al doilea polinom cu semn schimbat
            m.setCoef(-m.getCoef());
        }
        result.getMonomials().addAll(p2.getMonomials());
        result.sortPolynomial();
        return result;
    }

    public Polynomial mulPolynomials(Polynomial p1, Polynomial p2){

        result = new Polynomial("0");
        for (Monomial m : p1.getMonomials()) {          // Aceeasi idee
            for (Monomial n : p2.getMonomials()) {
                result.getMonomials().add(new Monomial((m.getCoef() * n.getCoef()), m.getExp() + n.getExp()));
            }
        }
        result.sortPolynomial();
        return result;
    }

    public void divPolynomials(Polynomial p1, Polynomial p2){

        remainder = p1;
        Polynomial res = new Polynomial("0");

        while (!remainder.getMonomials().isEmpty() && p2.getMonomials().get(0).getExp() <= remainder.getMonomials().get(0).getExp()){
            double shortDouble = ((double)((int)((remainder.getMonomials().get(0).getCoef() / p2.getMonomials().get(0).getCoef()) *100.0)))/100.0; // 2 cifre dupa virgula
            Polynomial t = new Polynomial(new Monomial(shortDouble ,remainder.getMonomials().get(0).getExp() - p2.getMonomials().get(0).getExp()));
            res = addPolynomials(res,t);
            remainder = subPolynomials(remainder, mulPolynomials(t,p2));
        }
        result = res;
    }

    public Polynomial derivPolynomials(Polynomial p){

        result = new Polynomial("0");
        for (Monomial m : p.getMonomials()) {
            if (m.getExp() == 0)
                continue;
            result.getMonomials().add(new Monomial(m.getCoef() * m.getExp(), m.getExp() - 1));
        } // Adaugam in polinom monomul cu noul coeficient = coef*exp si exp = exp-1
        result.sortPolynomial();
        return result;
    }

    public Polynomial integrPolynomials(Polynomial p) {
        result = new Polynomial("0");
        for (Monomial m : p.getMonomials()) {
            double shortDouble = ((double)((int)((m.getCoef() / ( m.getExp() + 1)) *100.0)))/100.0;
            result.getMonomials().add(new Monomial(shortDouble, m.getExp() + 1));
        } // Adaugam in polinom monomul cu noul coeficient = coef/(exp+1) si exp = exp+!
        result.sortPolynomial();
        return result;
    }
}
