package com.daleellis.condingwars.kata5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author dale.ellis
 * @since 08/08/2018
 */
class WeightSortTest {

    @Test
    public void simple() {
        assertEquals("2000 103 123 4444 99", WeightSort.orderWeight("103 123 4444 99 2000"));
    }

    @Test
    public void sortByWeightRequired() {
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }
}