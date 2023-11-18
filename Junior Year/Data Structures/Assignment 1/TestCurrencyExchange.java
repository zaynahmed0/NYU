public class TestCurrencyExchange {
    public static void main(String[] args) {
        Currency mars = new Mars(100.00);
        Currency neptune = new Neptune(100.00);
        Currency saturn = new Saturn(100.00);

        System.out.println("<-- Exchanges -->");

        mars.exchange(saturn, 25.00);
        System.out.println("\n");
        neptune.exchange(saturn, 10.00);
        System.out.println("\n");
        saturn.exchange(mars, 122.00);
        System.out.println("\n");
        saturn.exchange(mars, 121.00);
    }
}
