package CurrencyConverter;

public class CurrencyConverter {
    public static void main(String[] args) {
        CurrencyConverterView theView = new CurrencyConverterView();
        CurrencyConverterModel theModel = new CurrencyConverterModel();

        new CurrencyConverterController(theView, theModel);

        theView.setLocationRelativeTo(null);
        theView.setVisible(true);
    }
}