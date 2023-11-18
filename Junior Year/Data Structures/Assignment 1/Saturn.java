public class Saturn extends Currency {
    public Saturn(double totalFunds) {
        super("SaturnSilver", totalFunds);
    }

    @Override
    public double toEarthDollars(double amount) {
        return roundToTwoDecimalPlaces(amount / saturnSilver);
    }

    @Override
    public double fromEarthDollars(double EarthDollars) {
        return roundToTwoDecimalPlaces(EarthDollars * saturnSilver);
    }

    @Override
    public double getExchangeFee(double amount) {
        return 0.0;
    }
}
