public interface Exchangeable {
    double earthDollar = 1.00;
    double marsMoney = 1.30;
    double saturnSilver = 0.87;
    double neptuneNuggets = 2.00;

    void exchange(Currency other, double amount);
}
