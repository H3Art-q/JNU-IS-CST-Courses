package CurrencyConverter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterController {

    private final CurrencyConverterView theView;
    private final CurrencyConverterModel theModel;

    public CurrencyConverterController(CurrencyConverterView view, CurrencyConverterModel model) {
        theView = view;
        theModel = model;
        theView.addConvertListener(new ConvertListener());
    }

    class ConvertListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double inputMoney;
            int convertFlag;

            try {
                inputMoney = theView.getInputMoney();
                convertFlag = theView.convertType();

                switch (convertFlag) {
                    case CurrencyConverterConstants.RMB_TO_RMB:
                    case CurrencyConverterConstants.EUR_TO_EUR:
                    case CurrencyConverterConstants.USD_TO_USD:
                    case CurrencyConverterConstants.CAD_TO_CAD:
                        theModel.noConversion(inputMoney);
                        theView.setResult(theModel.getRes());
                        break;
                    case CurrencyConverterConstants.RMB_TO_USD:
                        theModel.RMB2USD(inputMoney);
                        theView.setResult(theModel.getRes());
                        break;
                    case CurrencyConverterConstants.RMB_TO_CAD:
                        theModel.RMB2CAD(inputMoney);
                        theView.setResult(theModel.getRes());
                        break;
                    case CurrencyConverterConstants.RMB_TO_EUR:
                        theModel.RMB2EUR(inputMoney);
                        theView.setResult(theModel.getRes());
                        break;
                    case CurrencyConverterConstants.CAD_TO_RMB:
                        theModel.CAD2RMB(inputMoney);
                        theView.setResult(theModel.getRes());
                        break;
                    case CurrencyConverterConstants.CAD_TO_USD:
                        theModel.CAD2USD(inputMoney);
                        theView.setResult(theModel.getRes());
                        break;
                    case CurrencyConverterConstants.CAD_TO_EUR:
                        theModel.CAD2EUR(inputMoney);
                        theView.setResult(theModel.getRes());
                        break;
                    case CurrencyConverterConstants.USD_TO_RMB:
                        theModel.USD2RMB(inputMoney);
                        theView.setResult(theModel.getRes());
                        break;
                    case CurrencyConverterConstants.USD_TO_CAD:
                        theModel.USD2CAD(inputMoney);
                        theView.setResult(theModel.getRes());
                        break;
                    case CurrencyConverterConstants.USD_TO_EUR:
                        theModel.USD2EUR(inputMoney);
                        theView.setResult(theModel.getRes());
                        break;
                    case CurrencyConverterConstants.EUR_TO_RMB:
                        theModel.EUR2RMB(inputMoney);
                        theView.setResult(theModel.getRes());
                        break;
                    case CurrencyConverterConstants.EUR_TO_USD:
                        theModel.EUR2USD(inputMoney);
                        theView.setResult(theModel.getRes());
                        break;
                    case CurrencyConverterConstants.EUR_TO_CAD:
                        theModel.EUR2CAD(inputMoney);
                        theView.setResult(theModel.getRes());
                        break;
                }
            } catch (Exception exception) {
                theView.invalidRes();
            }
        }
    }
}