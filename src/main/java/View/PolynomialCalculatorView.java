package View;

import Model.PolynomialCalculatorOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PolynomialCalculatorView extends JFrame {
    private JTextField tfPol1 = new JTextField();
    private JTextField tfPol2 = new JTextField();
    private JButton[] buttonsOp = new JButton[6];
    private JButton buttonEquals = new JButton("=");
    private JButton buttonClear = new JButton("CE");
    private JTextField tfRes = new JTextField();
    private JTextField tfRes1 = new JTextField();

    private PolynomialCalculatorOperations model;

    public PolynomialCalculatorView(PolynomialCalculatorOperations model) {

        this.model = model;
        this.model.reset();

        tfRes.setText(this.model.getResult().toString());
        tfRes1.setText(this.model.getRemainder().toString());

        JPanel contentPanel = new JPanel();
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.rowHeights = new int[]{90, 150, 69};
        gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, 1.0};
        gbl_contentPanel.columnWeights = new double[]{1.0};
        contentPanel.setLayout(gbl_contentPanel);

        this.setContentPane(contentPanel);

        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 5, 0);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 0;
        contentPanel.add(panel, gbc_panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
        gbl_panel.rowHeights = new int[] {30, 30, 30, 30};
        gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
        panel.setLayout(gbl_panel);

        JLabel label = new JLabel("Polynomial 1: ");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.fill = GridBagConstraints.HORIZONTAL;
        gbc_label.gridwidth = 6;
        gbc_label.gridheight = 2;
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 0;
        gbc_label.gridy = 0;
        panel.add(label, gbc_label);

        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridwidth = 13;
        gbc_textField.gridheight = 2;
        gbc_textField.insets = new Insets(0, 0, 5, 5);
        gbc_textField.gridx = 6;
        gbc_textField.gridy = 0;
        panel.add(tfPol1, gbc_textField);

        GridBagConstraints gbc_buttonClear = new GridBagConstraints();
        gbc_buttonClear.insets = new Insets(0, 0, 5, 5);
        gbc_buttonClear.fill = GridBagConstraints.BOTH;
        gbc_buttonClear.gridheight = 4;
        gbc_buttonClear.gridwidth = 5;
        gbc_buttonClear.gridx = 21;
        gbc_buttonClear.gridy = 0;
        panel.add(buttonClear, gbc_buttonClear);

        JLabel label2 = new JLabel("Polynomial 2: ");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_label2 = new GridBagConstraints();
        gbc_label2.fill = GridBagConstraints.HORIZONTAL;
        gbc_label2.gridwidth = 6;
        gbc_label2.gridheight = 2;
        gbc_label2.insets = new Insets(0, 0, 5, 5);
        gbc_label2.gridx = 0;
        gbc_label2.gridy = 2;
        panel.add(label2, gbc_label2);

        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridwidth = 13;
        gbc_textField_1.gridheight = 2;
        gbc_textField_1.insets = new Insets(0, 0, 0, 5);
        gbc_textField_1.gridx = 6;
        gbc_textField_1.gridy = 2;
        panel.add(tfPol2, gbc_textField_1);

        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.insets = new Insets(0, 0, 5, 0);
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridx = 0;
        gbc_panel_1.gridy = 1;
        contentPanel.add(panel_1, gbc_panel_1);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
        gbl_panel_1.rowHeights = new int[] {30, 30, 30, 30};
        gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
        panel_1.setLayout(gbl_panel_1);

        buttonsOp[0] = new JButton("+");
        GridBagConstraints gbc_buttonAdd = new GridBagConstraints();
        gbc_buttonAdd.gridheight = 2;
        gbc_buttonAdd.fill = GridBagConstraints.BOTH;
        gbc_buttonAdd.insets = new Insets(0, 0, 5, 5);
        gbc_buttonAdd.gridwidth = 5;
        gbc_buttonAdd.gridx = 1;
        gbc_buttonAdd.gridy = 0;
        panel_1.add(buttonsOp[0], gbc_buttonAdd);

        buttonsOp[1] = new JButton("-");
        GridBagConstraints gdc_buttonSub = new GridBagConstraints();
        gdc_buttonSub.fill = GridBagConstraints.BOTH;
        gdc_buttonSub.gridheight = 2;
        gdc_buttonSub.gridwidth = 6;
        gdc_buttonSub.insets = new Insets(0, 0, 5, 5);
        gdc_buttonSub.gridx = 7;
        gdc_buttonSub.gridy = 0;
        panel_1.add(buttonsOp[1], gdc_buttonSub);

        buttonsOp[2] = new JButton("*");
        GridBagConstraints gdc_buttonMul = new GridBagConstraints();
        gdc_buttonMul.fill = GridBagConstraints.BOTH;
        gdc_buttonMul.gridheight = 2;
        gdc_buttonMul.gridwidth = 5;
        gdc_buttonMul.insets = new Insets(0, 0, 5, 5);
        gdc_buttonMul.gridx = 14;
        gdc_buttonMul.gridy = 0;
        panel_1.add(buttonsOp[2], gdc_buttonMul);

        GridBagConstraints gdc_buttonEquals = new GridBagConstraints();
        gdc_buttonEquals.insets = new Insets(0, 0, 5, 5);
        gdc_buttonEquals.fill = GridBagConstraints.BOTH;
        gdc_buttonEquals.gridheight = 4;
        gdc_buttonEquals.gridwidth = 5;
        gdc_buttonEquals.gridx = 21;
        gdc_buttonEquals.gridy = 0;
        panel_1.add(buttonEquals, gdc_buttonEquals);

        buttonsOp[3] = new JButton("'");
        GridBagConstraints gdc_buttonDeriv = new GridBagConstraints();
        gdc_buttonDeriv.fill = GridBagConstraints.BOTH;
        gdc_buttonDeriv.gridwidth = 5;
        gdc_buttonDeriv.gridheight = 2;
        gdc_buttonDeriv.insets = new Insets(0, 0, 5, 5);
        gdc_buttonDeriv.gridx = 1;
        gdc_buttonDeriv.gridy = 2;
        panel_1.add(buttonsOp[3], gdc_buttonDeriv);

        buttonsOp[4] = new JButton("∫");
        GridBagConstraints gdc_buttonIntegr = new GridBagConstraints();
        gdc_buttonIntegr.fill = GridBagConstraints.BOTH;
        gdc_buttonIntegr.gridwidth = 6;
        gdc_buttonIntegr.gridheight = 2;
        gdc_buttonIntegr.insets = new Insets(0, 0, 5, 5);
        gdc_buttonIntegr.gridx = 7;
        gdc_buttonIntegr.gridy = 2;
        panel_1.add(buttonsOp[4], gdc_buttonIntegr);

        buttonsOp[5] = new JButton("/");
        GridBagConstraints gdc_buttonDiv = new GridBagConstraints();
        gdc_buttonDiv.fill = GridBagConstraints.BOTH;
        gdc_buttonDiv.gridheight = 2;
        gdc_buttonDiv.gridwidth = 5;
        gdc_buttonDiv.insets = new Insets(0, 0, 5, 5);
        gdc_buttonDiv.gridx = 14;
        gdc_buttonDiv.gridy = 2;
        panel_1.add(buttonsOp[5], gdc_buttonDiv);

        JPanel panel_2 = new JPanel();
        GridBagConstraints gbc_panel_2 = new GridBagConstraints();
        gbc_panel_2.insets = new Insets(0, 0, 5, 0);
        gbc_panel_2.fill = GridBagConstraints.BOTH;
        gbc_panel_2.gridx = 0;
        gbc_panel_2.gridy = 2;
        contentPanel.add(panel_2, gbc_panel_2);
        GridBagLayout gbl_panel_2 = new GridBagLayout();
        gbl_panel_2.columnWidths = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
        gbl_panel_2.rowHeights = new int[] {20};
        gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panel_2.rowWeights = new double[]{1.0};
        panel_2.setLayout(gbl_panel_2);

        tfRes.setEditable(false);
        GridBagConstraints gdc_res1 = new GridBagConstraints();
        gdc_res1.gridwidth = 10;
        gdc_res1.insets = new Insets(0, 0, 0, 5);
        gdc_res1.fill = GridBagConstraints.HORIZONTAL;
        gdc_res1.gridx = 2;
        gdc_res1.gridy = 0;
        panel_2.add(tfRes, gdc_res1);

        tfRes1.setEditable(false);
        GridBagConstraints gdc_res2 = new GridBagConstraints();
        gdc_res2.gridwidth = 10;
        gdc_res2.insets = new Insets(0, 0, 0, 5);
        gdc_res2.fill = GridBagConstraints.HORIZONTAL;
        gdc_res2.gridx = 14;
        gdc_res2.gridy = 0;
        panel_2.add(tfRes1, gdc_res2);

        this.setTitle("Polynomial Calculator");
        this.setBounds(400,200, 800, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void resetEntry(){
        tfPol1.setText("");
        tfPol2.setText("");
    }

    public String getPol1(){
        return tfPol1.getText();
    }

    public String getPol2(){
        return tfPol2.getText();
    }

    public void setRes(String res, String res1){
        this.tfRes.setText(res);
        this.tfRes1.setText(res1);
    }

    public void addOpListener(ActionListener opAl){
        for (JButton b: buttonsOp) {
            b.addActionListener(opAl);
        }
    }

    public void addEqualsListener(ActionListener eqAl){
        buttonEquals.addActionListener(eqAl);
    }

    public void addClearListener(ActionListener ceAl){
        buttonClear.addActionListener(ceAl);
    }

    public void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
}
