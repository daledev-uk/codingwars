package com.daleellis.condingwars.kata5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author dale.ellis
 * @since 17/08/2018
 */
class SolutionTest {

    @Test
    public void testZeros() throws Exception {
        assertEquals(0, Solution.zeros(0));
        assertEquals(1, Solution.zeros(6));
        assertEquals(2, Solution.zeros(14));
    }

    @Test
    public void largeTest() throws Exception {
        assertEquals(50, Solution.zeros(205));
    }

    @Test
    public void largestIntegerTest() throws Exception {
        assertEquals(62499, Solution.zeros(250000));
    }

}