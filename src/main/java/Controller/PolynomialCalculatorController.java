package Controller;

import Model.Polynomial;
import Model.PolynomialCalculatorOperations;
import View.PolynomialCalculatorView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PolynomialCalculatorController {
    private PolynomialCalculatorView view;
    private PolynomialCalculatorOperations model;
    private String operation;

    public PolynomialCalculatorController(PolynomialCalculatorView view , PolynomialCalculatorOperations model){
        this.model = model;
        this.view = view;

        view.addOpListener(new OperationListener());
        view.addEqualsListener(new EqualsListener());
        view.addClearListener(new ClearListener());
    }

    class OperationListener implements ActionListener{ // Listener pentru butoanele care determina operatia
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            operation = b.getText(); // ii dam variabilei instanta operation valoarea textului butonului care a fost apasat
        }
    }

    class EqualsListener implements ActionListener { // Listener pentru butonul de egal
        public void actionPerformed(ActionEvent e) {
            Polynomial p1;
            Polynomial p2;
            try {
                p1 = new Polynomial(view.getPol1());
                p2 = new Polynomial(view.getPol2());
                switch (operation){ // In functie de valoarea variabilei operation apelam metoda potrivita operatiei
                    case "+" :
                        model.addPolynomials(p1, p2);
                        break;
                    case "-" :
                        model.subPolynomials(p1, p2);
                        break;
                    case "*" :
                        model.mulPolynomials(p1, p2);
                        break;
                    case "/" :
                        model.divPolynomials(p1, p2);
                        break;
                    case "'" :
                        model.derivPolynomials(p1);
                        break;
                    case "∫" :
                        model.integrPolynomials(p1);
                        break;
                }
                view.setRes(model.getResult().toString(), model.getRemainder().toString()); // La final afisam rezultatul
                model.reset();
            } catch (NumberFormatException nfex) {  // Daca nu s-au introdus numere (cu exceptia caracterelor 'x' si '^') afisam o eroare
                view.showError("Incorrect input");
            }catch (ArithmeticException aex){
                view.showError("Cannot divide by 0");
            }
        }
    }

    class ClearListener implements ActionListener{ // Listener pentru butonul care reseteaza intrarile
        public void actionPerformed(ActionEvent e) {
            view.resetEntry();
        }
    }
}