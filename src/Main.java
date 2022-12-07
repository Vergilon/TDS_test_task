import java.util.Arrays;
import mobilechecker.IMobileNumberChecker;
import mobilechecker.impl.RussianMobileNumberChecker;
import primenumber.impl.PrimeNumberManager;

public class Main {
    public static void main(String[] args) {
        IMobileNumberChecker russianMobileNumberChecker = new RussianMobileNumberChecker();
        System.out.println("Result of +79112345434 " + russianMobileNumberChecker.checkNumber("+79112345434") );
        System.out.println("Result of +89112345434 " + russianMobileNumberChecker.checkNumber("+89112345434"));
        System.out.println("Result of 79112345434 " + russianMobileNumberChecker.checkNumber("79112345434"));
        System.out.println("Result of +79454d65433 " + russianMobileNumberChecker.checkNumber("+79454d65433"));
        System.out.println("Result of +7-(945)4365433 " + russianMobileNumberChecker.checkNumber("+7-(945)4365433"));
        System.out.println("Result of +7 (945)-4365       433 " + russianMobileNumberChecker.checkNumber("+7 (945)-4365       433"));
        System.out.println("------------------------------------------");

        var primeNumberManager = new PrimeNumberManager();
        var eratosthenesPrimeChecker = primeNumberManager.new EratosthenesPrimeChecker();
        var simpleJavaPrimeChecker = primeNumberManager.new SimpleJavaPrimeChecker();
        var eratosNumberManager = new PrimeNumberManager(eratosthenesPrimeChecker);
        var ints = new int[] {1, 3, 23, 113, 123, 245};
        System.out.println("Are Primes");
        var arePrimes = eratosNumberManager.arePrimes(ints);
        arePrimes.forEach(s -> System.out.print(s + " "));
        var primes = new Integer[] {1, 3, 23, 113, 123, 245};
        System.out.println();
        System.out.println("Max prime");
        var maxPrime = eratosNumberManager.maxPrime(Arrays.stream(primes));
        System.out.println(maxPrime);
        System.out.println("Primes only");
        var primesOnly = eratosNumberManager.primesOnly(Arrays.stream(primes));
        primesOnly.forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("113 isPrime by eratos: " + eratosthenesPrimeChecker.isPrime(113));
        System.out.println("3556 isPrime by eratos: " + eratosthenesPrimeChecker.isPrime(3556));
        System.out.println("113 isPrime by simpleJava: " + simpleJavaPrimeChecker.isPrime(113));
        System.out.println("3556 isPrime by simpleJava: " + simpleJavaPrimeChecker.isPrime(3556));
    }
}