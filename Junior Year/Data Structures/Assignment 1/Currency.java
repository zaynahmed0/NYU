public abstract class Currency implements Exchangeable {
    protected String currencyName;
    protected double totalFunds;

    public abstract double toEarthDollars(double amount);

    public abstract double fromEarthDollars(double EarthDollars);

    public abstract double getExchangeFee(double amount);


    public Currency(String currencyName, double totalFunds) {
        this.currencyName = currencyName;
        this.totalFunds = totalFunds;
    }

    public double getTotalFunds() {
        return totalFunds;
    }

    public void setTotalFunds(double totalFunds) {
        this.totalFunds = roundToTwoDecimalPlaces(totalFunds);
    }

    protected double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }


    @Override
    public void exchange(Currency other, double amount) {
        double fee = roundToTwoDecimalPlaces(this.getExchangeFee(amount));
        double totalAmountWithFee = roundToTwoDecimalPlaces(amount + fee);

        if (totalAmountWithFee > totalFunds) {
            System.out.printf("Uh oh - %s only has an available balance of %.2f, which is less than %.2f!\n", this.currencyName, this.totalFunds, totalAmountWithFee);
            return;
        }

        double inEarthDollars = roundToTwoDecimalPlaces(this.toEarthDollars(amount));
        double inTargetCurrency = roundToTwoDecimalPlaces(other.fromEarthDollars(inEarthDollars));

        this.totalFunds = roundToTwoDecimalPlaces(this.totalFunds - totalAmountWithFee);
        other.setTotalFunds(roundToTwoDecimalPlaces(other.getTotalFunds() + inTargetCurrency));

        System.out.printf("Converting from %s to %s and initiating transfer…\n", this.currencyName, other.currencyName);
        System.out.printf("%.2f %s = %.2f EarthDollars = %.2f %s\n", amount, this.currencyName, inEarthDollars, inTargetCurrency, other.currencyName);
        System.out.printf("%s exchange fee is %.2f %s\n", this.currencyName, fee, this.currencyName);
        System.out.printf("%s has a total of %.2f %s\n", this.currencyName, this.totalFunds, this.currencyName);
        System.out.printf("%s has a total of %.2f %s\n", other.currencyName, other.getTotalFunds(), other.currencyName);
    }
}
