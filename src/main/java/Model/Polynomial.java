package Model;

import java.util.*;
import java.util.regex.*;

public class Polynomial {
    private ArrayList<Monomial> monomials = new ArrayList<Monomial>();

    public Polynomial(String input){
        Pattern pattern = Pattern.compile("(-?[^-+]+)");  // Cautam un eventual - si apoi mai multe caractere care nu sunt -,+ si care vor fi coefx^exp
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            Monomial m = new Monomial(matcher.group().replace(" ","")); // Stergem spatiile
            monomials.add(m);
        }
    }

    public Polynomial(Monomial m) {
        monomials.add(m);
    }

    public ArrayList<Monomial> getMonomials() {
        return monomials;
    }

    public void sortPolynomial (){

        Collections.sort(monomials); // Sortam monoamele in ordine descrescatoare a exponentului
        Monomial n = new Monomial(0,-1);

        // Daca gasim doua monoame cu acelasi exponent adunam coeficientii intr unul din ele si il stergem pe celalalt

        for (Iterator it = monomials.iterator() ; it.hasNext();) {
            Monomial m = (Monomial) it.next();
            if (m.getExp() == n.getExp()){
                n.setCoef(n.getCoef() + m.getCoef());
                it.remove();
            }
            else
                n = m;
        }
        monomials.removeIf(m -> m.getCoef()== 0); // Daca exista un monom cu coef = 0 il stergem din lista
    }

    public String toString() {
        String s = "";
        if (monomials.isEmpty()) // Daca lista de monoame e goala -> polinomul = 0
            return "0";
        else {
            boolean first = true;
            Iterator i = monomials.iterator();
            while (i.hasNext()) {
                Monomial m = (Monomial) i.next();
                if (m.getCoef() > 0 && !first) // Punem + inaintea monomului doar daca coeficientul e > 0 si monomul nu e primul din polinom
                    s += " + ";
                first = false;
                s += m.toString();
            }
            return s;
        }
    }
}
