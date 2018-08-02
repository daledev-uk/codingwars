package com.daleellis.condingwars.kata5;

import java.util.ArrayList;
import java.util.List;

/**
 * The Fibonacci numbers are the numbers in the following integer sequence (Fn):
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ...
 *
 * @author dale.ellis
 * @since 02/08/2018
 */
public class ProdFib { // must be public for codewars
    private static List<Long> fibonacciSequence = new ArrayList<>();


    public static long[] productFib(long target) {
        initialiseFibonacciSequence();

        long calculatedNumber;
        long oneFromLastNumber;
        long lastNumber;

        do {
            oneFromLastNumber = getOneFromLastNumber();
            lastNumber = getLastNumber();
            fibonacciSequence.add(oneFromLastNumber + lastNumber);

            calculatedNumber = oneFromLastNumber * lastNumber;
        } while (calculatedNumber < target);

        return getResponse(target, calculatedNumber, oneFromLastNumber, lastNumber);
    }

    private static void initialiseFibonacciSequence() {
        fibonacciSequence.add(0L);
        fibonacciSequence.add(1L);
    }

    private static Long getOneFromLastNumber() {
        return fibonacciSequence.get(fibonacciSequence.size() - 2);
    }

    private static Long getLastNumber() {
        return fibonacciSequence.get(fibonacciSequence.size() - 1);
    }

    private static long[] getResponse(long target, long calculatedNumber, long oneFromLastNumber, long lastNumber) {
        if (calculatedNumber == target) {
            return new long[]{oneFromLastNumber, lastNumber, 1};
        } else {
            return new long[]{oneFromLastNumber, lastNumber, 0};
        }
    }

}
