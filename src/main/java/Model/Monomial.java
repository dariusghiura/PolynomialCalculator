package Model;

import java.text.DecimalFormat;

public class Monomial implements Comparable{
    private double coef;
    private int exp;

    public Monomial(String mon){
        String[] a = mon.split("x\\^");
        if (a.length == 2) { // avem coef * x^exp
            if (a[0].equals("")) // avem doar x^exp -> coef = 1
                coef = 1;
            else
                if(a[0].equals("-")) // -x^exp
                    coef = -1;
                else
                    this.coef = Integer.parseInt(a[0]);
            this.exp = Integer.parseInt(a[1]);
        }
        else if (mon.contains("x")){ // exp = 1
            if (mon.equals("x")) // avem doar x
                this.coef = 1;
            else if (mon.equals("-x")) // -x
                this.coef = -1;
            else
                this.coef = Integer.parseInt(mon.split("x")[0]); // coef*x
            this.exp = 1;
        }
        else { // exp = 0
            this.coef = Integer.parseInt(mon);
            this.exp = 0;
        }
    }

    public Monomial (double coef , int exp){
        this.coef = coef;
        this.exp = exp;
    }

    public double getCoef() {
        return coef;
    }

    public int getExp() {
        return exp;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public String toString() {
        String s ="";
        if (exp == 0){ // Daca exp = 0 tiparim doar coeficientul
            s += coef;
        }
        else{
            if (coef == 1)
                s += " x^" + exp;
            else if (coef == -1)
                s += "- x^" + exp;
            else
                s += coef + " x^" + exp;
        }
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if (exp == ((Monomial)obj).exp && coef == ((Monomial)obj).coef)
            return true;
        return false;
    }

    public int compareTo(Object o) {
        Monomial m = (Monomial) o;
        return Integer.compare(m.exp, exp);
    }
}
