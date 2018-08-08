package com.daleellis.condingwars.kata5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * My friend John and I are members of the "Fat to Fit Club (FFC)".
 * John is worried because each month a list with the weights of members is published and each month he is the last on the list which means he is the heaviest.
 * <p>
 * I am the one who establishes the list so I told him: "Don't worry any more, I will modify the order of the list".
 * It was decided to attribute a "weight" to numbers. The weight of a number will be from now on the sum of its digits.
 * <p>
 * For example 99 will have "weight" 18, 100 will have "weight" 1 so in the list 100 will come before 99.
 * Given a string with the weights of FFC members in normal order can you give this string ordered by "weights" of these numbers?
 *
 * @author dale.ellis
 * @since 08/08/2018
 */
public class WeightSort {
    private static final int CHAR_NUMBER_OFFSET = 48;

    public static String orderWeight(String input) {
        if (input.isEmpty()) {
            return "";
        }

        List<Long> inputWeights = Arrays.stream(input.split(" ")).map(Long::parseLong).collect(Collectors.toList());
        inputWeights.sort(WeightSort::compareWeight);
        return inputWeights.stream().map(Object::toString).collect(Collectors.joining(" "));
    }

    private static int compareWeight(Long w1, Long w2) {
        int weightAsNumber1 = sumOfNumber(w1);
        int weightAsNumber2 = sumOfNumber(w2);

        if (weightAsNumber1 == weightAsNumber2) {
            return w1.toString().compareTo(w2.toString());
        } else {
            return Long.compare(weightAsNumber1, weightAsNumber2);
        }
    }

    private static int sumOfNumber(Long input) {
        int output = 0;
        String numberString = String.valueOf(input);
        for (int i = 0; i < numberString.length(); i++) {
            output += numberString.charAt(i) - CHAR_NUMBER_OFFSET;
        }
        return output;
    }
}
