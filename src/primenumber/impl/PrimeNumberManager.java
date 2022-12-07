package primenumber.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import primenumber.IPrimeChecker;
import primenumber.IPrimeNumberManager;

public class PrimeNumberManager implements IPrimeNumberManager {

    private IPrimeChecker primeChecker;

    public PrimeNumberManager() {
    }

    public PrimeNumberManager(IPrimeChecker primeChecker) {
        this.primeChecker = primeChecker;
    }

    @Override
    public Stream<Boolean> arePrimes(int[] inputInts) {
        return Arrays.stream(inputInts).mapToObj(element -> primeChecker.isPrime(element));
    }

    @Override
    public Stream<Integer> primesOnly(Stream<Integer> inputInts) {
        return inputInts.filter(primeChecker::isPrime);
    }

    @Override
    public Integer maxPrime(Stream<Integer> inputInts) {
        return inputInts.filter(primeChecker::isPrime).max(Integer::compareTo)
            .orElseThrow(() -> new NoSuchElementException("No max prime element into the stream"));
    }

    public class EratosthenesPrimeChecker implements IPrimeChecker {
        @Override
        public boolean isPrime(int number) {
            //Инициализирую список длинной number:
            //Номер ячейки - число
            //Значение - показатель простоты
            var numbers = new ArrayList<Boolean>(number + 1);
            //Заполняю все ячейки true (пока простые)
            for (int i = 0; i <= number; i++) {
                numbers.add(true);
            }
            //Начинаю проверку с первого натурального числа - 2
            for (int i = 2; i < number; i++) {
                //беру следующее простое число, начиная с 2
                if (numbers.get(i)) {
                    //Прохожу по всем числам, которые кратны выбранному простому, кратное число x = n * i
                    //i - текущее простое число
                    //n - натуральное число начиная с 2 и до конца списка
                    //т.к. это условие означает наличие дополнительного делителя, такое x простым числом являться не будет
                    for (int k = 2; i * k < numbers.size(); k++) {
                        numbers.set(i * k, false);
                    }
                }
            }
            return numbers.get(number);
        }
    }

    public class SimpleJavaPrimeChecker implements IPrimeChecker {
        @Override
        public boolean isPrime(int number) {
            BigInteger bigInteger = BigInteger.valueOf(number);
            return bigInteger.isProbablePrime((int) Math.log(number));
        }
    }
}
