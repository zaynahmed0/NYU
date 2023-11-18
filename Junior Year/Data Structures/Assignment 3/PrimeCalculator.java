public class PrimeCalculator {

    public void primesTo(int n) {
        // Test if n>2 and ends if not
        if (n < 2) {
            System.out.println("Error: Input must be a number greater than or equal to 2.\n");
            return;
        }

        // Initialize queues
        ArrayQueue<Integer> numbers = new ArrayQueue<>();
        ArrayQueue<Integer> primes = new ArrayQueue<>();

        // Fill numbers queue with all numbers till n
        for (int i = 2; i <= n; i++) {
            numbers.enqueue(i);
        }

        // Loop through all numbers till n
        while (!numbers.isEmpty()) {
            // Remove the smallest from numbers queue and at it to prime queue
            int p = numbers.dequeue();
            primes.enqueue(p);

            // Remove from queue if divisible by last prime number
            int size = numbers.size();
            for (int i = 0; i < size; i++) {
                int num = numbers.dequeue();
                // If not divisible add it back to the queue
                if (num % p != 0) {
                    numbers.enqueue(num);
                }
            }
        }

        // Print primes queue
        System.out.print("Printing primes up to " + n + ":\n");
        while (!primes.isEmpty()) {
            int currentPrime = primes.dequeue();
            System.out.print(currentPrime);

            // Comma or no comma
            if (!primes.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.print(".\n\n");
    }

    public static void main(String[] args) {
        new PrimeCalculator().primesTo(20);
        new PrimeCalculator().primesTo(2);
        new PrimeCalculator().primesTo(0);
    }
}
