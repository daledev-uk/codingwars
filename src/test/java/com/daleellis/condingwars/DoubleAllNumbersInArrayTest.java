package com.daleellis.condingwars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dale.ellis
 * @since 01/08/2018
 */
class DoubleAllNumbersInArrayTest {

    @Test
    public void sampleTests() {
        assertArrayEquals(new int[]{2, 4, 6}, DoubleAllNumbersInArray.map(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{8, 2, 2, 2, 8}, DoubleAllNumbersInArray.map(new int[]{4, 1, 1, 1, 4}));
        assertArrayEquals(new int[]{2, 2, 2, 2, 2, 2}, DoubleAllNumbersInArray.map(new int[]{1, 1, 1, 1, 1, 1}));
    }
}