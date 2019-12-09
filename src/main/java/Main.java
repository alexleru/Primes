import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ArrayList<BigInteger> primes = new ArrayList<>();
        BigInteger[] bigIntegers = new BigInteger[]{new BigInteger("2"), new BigInteger("3"), new BigInteger("5"), new BigInteger("7")};
        primes.addAll(Arrays.asList(bigIntegers));
        print(primes);
        Long start = new Date().getTime();
        System.out.println((double) start / 1000);
        for (int i = 0; i < 20000; i++) {
            primes = SearchPrime.searchPrime(primes);
        }
        Long end = new Date().getTime();
        System.out.println((double) end / 1000);
        double ml = (double) (end - start) / 1_000;
        System.out.println(ml);
        print(primes);
        System.out.println(ml);
    }

    private static void print(ArrayList<BigInteger> primes) {
        System.out.println("print");
        var i = 1;
        for (BigInteger bigInt : primes) {
            System.out.println(i++ + " - " + bigInt.toString() + ", ");
        }
        System.out.println("");
    }


}
