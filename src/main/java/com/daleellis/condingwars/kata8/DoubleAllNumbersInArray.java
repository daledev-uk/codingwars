package com.daleellis.condingwars.kata8;

import java.util.Arrays;

/**
 * @author dale.ellis
 * @since 01/08/2018
 */
public class DoubleAllNumbersInArray {

    public static int[] map(int[] input) {
        return Arrays.stream(input).map(number -> number * 2).toArray();
    }
}
