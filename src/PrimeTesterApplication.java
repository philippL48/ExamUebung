import org.apache.commons.math3.primes.*;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.math3.primes.Primes.*;


public class PrimeTesterApplication {
    public static List<Integer> getCommonPrimeFactors(int a, int b) {
        List<Integer> aPrimeList = primeFactors(a);
        List<Integer> bPrimeList = primeFactors(b);
        List<Integer> bothPrimeList = new ArrayList<Integer>();
        for (int i = 0; i < aPrimeList.size(); i++) {
            if ( bPrimeList.contains(aPrimeList.get(i) ) ) {
                bothPrimeList.add(aPrimeList.get(i));
            }
        }
        return bothPrimeList;
    }

    public static void main(String args[]) {
        System.out.println(getCommonPrimeFactors(454542, 1482932));
        List<Integer> aPrimeList = primeFactors(15);
        List<Integer> bPrimeList = primeFactors(25);
        System.out.println(bPrimeList.contains(aPrimeList.get(0)));
        System.out.println(bPrimeList);
        System.out.println(bPrimeList.size());
        System.out.println(aPrimeList.size());
        List<Integer> bothPrimeList = null;
        bothPrimeList.add(3);
    }
}
