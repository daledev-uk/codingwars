package com.daleellis.condingwars.kata5;

import java.math.BigInteger;

/**
 * Write a program that will calculate the number of trailing zeros in a factorial of a given number.
 * <p>
 * N! = 1 * 2 * 3 * ... * N
 * <p>
 * Be careful 1000! has 2568 digits...
 * <p>
 * For more info, see: http://mathworld.wolfram.com/Factorial.html
 *
 * @author dale.ellis
 * @see https://www.codewars.com/kata/number-of-trailing-zeros-of-n
 * @since 17/08/2018
 */
public class Solution {

    public static int zeros(int n) {
        if (n <= 0) {
            return 0;
        }

        ZeroFromFactorialExtractor fastExtractor = new ExtractViaMultiplesOf5Pattern();
        int fastResult = fastExtractor.extract(n);

        return fastResult;
    }

    private interface ZeroFromFactorialExtractor {
        int extract(int numbers);
    }

    /**
     * Every 5 number a zero is added
     */
    private static class ExtractViaMultiplesOf5Pattern implements ZeroFromFactorialExtractor {

        @Override
        public int extract(int input) {
            int multiplier = 5;
            int total = 0;

            while (multiplier < input) {
                total += input / multiplier;
                multiplier *= 5;
            }

            return total;
        }
    }

    /**
     * Inital code, this method was too slow to pass the code wars test, regardless of how I calculated number and exrtacted zeros
     */
    private static class ExtractViaFullCalculation implements ZeroFromFactorialExtractor {

        private EndZeroExtractor endZeroExtractor;

        private ExtractViaFullCalculation(EndZeroExtractor endZeroExtractor) {
            this.endZeroExtractor = endZeroExtractor;
        }

        @Override
        public int extract(int numbers) {
            BigInteger factorial = calculateFactorial(numbers);
            return endZeroExtractor.extract(factorial);
        }

        private static BigInteger calculateFactorial(int n) {
            BigInteger total = BigInteger.ONE;
            for (int i = 1; i <= n; i++) {
                total = total.multiply(BigInteger.valueOf(i));
            }
            return total;
        }

        private interface EndZeroExtractor {
            int extract(BigInteger factorial);
        }

        private static class ExtractZerosViaStringInspection implements EndZeroExtractor {

            @Override
            public int extract(BigInteger factorial) {
                String factorialAsString = factorial.toString();
                int total = 0;
                int endIndex = factorialAsString.length() - 1;
                int lastNumberValue = Character.getNumericValue(factorialAsString.charAt(endIndex));
                while (lastNumberValue == 0) {
                    total++;
                    endIndex--;
                    lastNumberValue = Character.getNumericValue(factorialAsString.charAt(endIndex));
                }

                return total;
            }
        }


        private static class ExtractZerosViaDivision implements EndZeroExtractor {

            @Override
            public int extract(BigInteger factorial) {
                int zeros = 0;
                while (factorial.remainder(BigInteger.TEN).equals(BigInteger.ZERO)) {
                    factorial = factorial.divide(BigInteger.TEN);
                    zeros++;
                }
                return zeros;
            }
        }
    }
}
