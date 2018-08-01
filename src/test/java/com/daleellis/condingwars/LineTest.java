package com.daleellis.condingwars;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author dale.ellis
 * @since 01/08/2018
 */

public class LineTest {

    @Test
    public void test1() {
        // Given
        int[] input = new int[]{25, 25, 50};

        // When
        String response = Line.Tickets(input);

        // Then
        assertEquals("YES", response);
    }

    @Test
    public void test2() {
        // Given
        int[] input = new int[]{25, 100};

        // When
        String response = Line.Tickets(input);

        // Then
        assertEquals("NO", response);
    }

    @Test
    public void test3() {
        // Given
        int[] input = new int[]{25, 25, 50, 50, 100};

        // When
        String response = Line.Tickets(input);

        // Then
        assertEquals("NO", response);
    }

    @Test
    public void test4() {
        // Given
        int[] input = new int[]{25, 25, 25, 25, 25, 25, 100, 50};

        // When
        String response = Line.Tickets(input);

        // Then
        assertEquals("YES", response);
    }

}
