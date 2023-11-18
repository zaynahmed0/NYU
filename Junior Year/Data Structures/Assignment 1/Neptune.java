public class Neptune extends Currency {
    public Neptune(double totalFunds) {
        super("NeptuneNuggets", totalFunds);
    }

    @Override
    public double toEarthDollars(double amount) {
        return roundToTwoDecimalPlaces(amount / neptuneNuggets);
    }

    @Override
    public double fromEarthDollars(double EarthDollars) {
        return roundToTwoDecimalPlaces(EarthDollars * neptuneNuggets);
    }

    @Override
    public double getExchangeFee(double amount) {
        return 5.0;
    }
}
