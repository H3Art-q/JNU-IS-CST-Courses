package CurrencyConverter;

public class CurrencyConverterModel {

    private double res;

    // RMB to CAD
    public void RMB2CAD(double rmb) {
        res = rmb * 0.19303721;
    }

    // RMB to USD
    public void RMB2USD(double rmb) {
        res = rmb * 0.13749396;
    }

    // RMB to EUR
    public void RMB2EUR(double rmb) {
        res = rmb * 0.13067734;
    }

    // CAD to RMB
    public void CAD2RMB(double cad) {
        res = cad * 5.1803484;
    }

    // CAD to USD
    public void CAD2USD(double cad) {
        res = cad * 0.7123114;
    }

    // CAD to EUR
    public void CAD2EUR(double cad) {
        res = cad * 0.67698155;
    }

    // USD to RMB
    public void USD2RMB(double usd) {
        res = usd * 7.2730468;
    }

    // USD to CAD
    public void USD2CAD(double usd) {
        res = usd * 1.4038804;
    }

    // USD to EUR
    public void USD2EUR(double usd) {
        res = usd * 0.95046056;
    }

    // EUR to RMB
    public void EUR2RMB(double eur) {
        res = eur * 7.652436;
    }

    // EUR to CAD
    public void EUR2CAD(double eur) {
        res = eur * 1.4771451;
    }

    // EUR to USD
    public void EUR2USD(double eur) {
        res = eur * 1.0521215;
    }

    // No convert
    public void noConversion(double amt) {
        res = amt;
    }

    // getter
    public double getRes() {
        return res;
    }
}
