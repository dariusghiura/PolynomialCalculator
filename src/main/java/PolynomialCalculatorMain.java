import Controller.PolynomialCalculatorController;
import Model.PolynomialCalculatorOperations;
import View.PolynomialCalculatorView;

public class PolynomialCalculatorMain {
    public static void main(String[] args) {
        PolynomialCalculatorOperations model = new PolynomialCalculatorOperations();
        PolynomialCalculatorView view = new PolynomialCalculatorView(model);
        new PolynomialCalculatorController(view, model);

        view.setVisible(true);
    }
}
