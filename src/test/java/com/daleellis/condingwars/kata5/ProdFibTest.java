package com.daleellis.condingwars.kata5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author dale.ellis
 * @since 02/08/2018
 */
public class ProdFibTest {

    @Test
    public void test1() {
        long[] r = new long[]{55, 89, 1};
        assertArrayEquals(r, ProdFib.productFib(4895));
    }

    @Test
    public void test2() {
        long[] r = new long[]{89, 144, 0};
        assertArrayEquals(r, ProdFib.productFib(5895));
    }

    @Test
    public void test3() {
        long[] r = new long[]{1, 1, 1};
        assertArrayEquals(r, ProdFib.productFib(1));
    }

}