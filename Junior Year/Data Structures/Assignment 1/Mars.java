public class Mars extends Currency {
    public Mars(double totalFunds) {
        super("MarsMoney", totalFunds);
    }

    @Override
    public double toEarthDollars(double amount) {
        return roundToTwoDecimalPlaces(amount / marsMoney);
    }

    @Override
    public double fromEarthDollars(double EarthDollars) {
        return roundToTwoDecimalPlaces(EarthDollars * marsMoney);
    }

    @Override
    public double getExchangeFee(double amount) {
        return roundToTwoDecimalPlaces(0.10 * amount);
    }
}
