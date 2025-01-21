package CurrencyConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CurrencyConverterView extends JFrame {
    JLabel amountLabel = new JLabel("Amount:");
    JTextField inputMoney = new JTextField(10);
    JComboBox<String> currencyComboBox = new JComboBox<>();
    JComboBox<String> currencyComboBox2 = new JComboBox<>();
    JButton convButton = new JButton("convert");
    JTextField result = new JTextField(10);

    CurrencyConverterView() {
        initializeComponents();
    }

    private void initializeComponents() {
        this.setTitle("Currency Converter MVC | 21 CST H3Art");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 70);
        this.setResizable(false);
        JPanel convPanel = new JPanel(new FlowLayout());

        initializeComboBox(currencyComboBox, new String[]{"RMB", "USD", "CAD", "EUR"});
        initializeComboBox(currencyComboBox2, new String[]{"USD", "CAD", "EUR", "RMB"});

        result.setEditable(false);

        convPanel.add(amountLabel);
        convPanel.add(inputMoney);
        convPanel.add(currencyComboBox);
        convPanel.add(convButton);
        convPanel.add(currencyComboBox2);
        convPanel.add(result);

        this.add(convPanel);
    }

    private void initializeComboBox(JComboBox<String> comboBox, String[] items) {
        for (String item : items) {
            comboBox.addItem(item);
        }
    }

    public double getInputMoney() {
        return Double.parseDouble(inputMoney.getText());
    }

    public int convertType() {
        String s1, s2;
        s1 = currencyComboBox.getSelectedItem().toString();
        s2 = currencyComboBox2.getSelectedItem().toString();

        if (s1.equals("RMB")) {
            switch (s2) {
                case "RMB":
                    return CurrencyConverterConstants.RMB_TO_RMB;
                case "USD":
                    return CurrencyConverterConstants.RMB_TO_USD;
                case "CAD":
                    return CurrencyConverterConstants.RMB_TO_CAD;
                case "EUR":
                    return CurrencyConverterConstants.RMB_TO_EUR;
            }
        }

        if (s1.equals("CAD")) {
            switch (s2) {
                case "CAD":
                    return CurrencyConverterConstants.CAD_TO_CAD;
                case "RMB":
                    return CurrencyConverterConstants.CAD_TO_RMB;
                case "USD":
                    return CurrencyConverterConstants.CAD_TO_USD;
                case "EUR":
                    return CurrencyConverterConstants.CAD_TO_EUR;
            }
        }

        if (s1.equals("USD")) {
            switch (s2) {
                case "USD":
                    return CurrencyConverterConstants.USD_TO_USD;
                case "RMB":
                    return CurrencyConverterConstants.USD_TO_RMB;
                case "CAD":
                    return CurrencyConverterConstants.USD_TO_CAD;
                case "EUR":
                    return CurrencyConverterConstants.USD_TO_EUR;
            }
        }

        if (s1.equals("EUR")) {
            switch (s2) {
                case "EUR":
                    return CurrencyConverterConstants.EUR_TO_EUR;
                case "RMB":
                    return CurrencyConverterConstants.EUR_TO_RMB;
                case "USD":
                    return CurrencyConverterConstants.EUR_TO_USD;
                case "CAD":
                    return CurrencyConverterConstants.EUR_TO_CAD;
            }
        }

        return 0;
    }

    public void setResult(double result) {
        this.result.setText(String.format("%g", result));
    }

    public void invalidRes() {
        result.setText("Not a valid number");
    }

    void addConvertListener(ActionListener listenForConvButton) {
        convButton.addActionListener(listenForConvButton);
    }
}