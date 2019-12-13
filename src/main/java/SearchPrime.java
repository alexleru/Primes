import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SearchPrime {
    public static ArrayList<BigInteger> searchPrime(ArrayList<BigInteger> oldArrayFromPrime) {
        var check = true;
        List<BigInteger> newArrayFromPrime = new ArrayList<>();
        BigInteger checkInt = maxBigPrime(oldArrayFromPrime);
        while (check) {
            checkInt = checkInt.add(BigInteger.TWO);
            boolean isPrime = isPrime(checkInt, oldArrayFromPrime);
            if (isPrime) {
                oldArrayFromPrime.add(checkInt);
                newArrayFromPrime.add(checkInt);
                check = false;
            }
        }
        return oldArrayFromPrime;
    }

    private static boolean isPrime(BigInteger checkInt, ArrayList<BigInteger> oldArrayFromPrime) {
        var result = true;
        var halfBigInteger = checkInt.divide(BigInteger.TWO);
        for (BigInteger bigInteger : oldArrayFromPrime) {
            if (bigInteger.compareTo(halfBigInteger) > 0) break;
            if (checkInt.mod(bigInteger).equals(BigInteger.ZERO)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static BigInteger maxBigPrime(ArrayList<BigInteger> oldArrayFromPrime) {
        var max = oldArrayFromPrime.get(0);

        for (int i = 1; i < oldArrayFromPrime.size(); i++) {
            if (oldArrayFromPrime.get(i).compareTo(max) > 0) {
                max = oldArrayFromPrime.get(i);
            }
        }
        return max;
    }
}