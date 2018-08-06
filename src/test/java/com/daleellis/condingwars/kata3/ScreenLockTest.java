package com.daleellis.condingwars.kata3;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * https://www.codewars.com/kata/screen-locking-patterns/train/java
 *
 * @author dale.ellis
 * @since 05/08/2018
 */
class ScreenLockTest {
    private ScreenLock screenLock;

    @BeforeEach
    void setUp() {
        screenLock = new ScreenLock();
    }

    @Test
    void givenStartingAt_A_Taking10MovesThenThereAre0PossibleMoves() {
        assertEquals(0, screenLock.calculateCombinations('A', 10));
    }

    @Test
    void givenStartingAt_A_Taking0MovesThenThereAre0PossibleMoves() {
        assertEquals(0, screenLock.calculateCombinations('A', 0));
    }

    @Test
    void givenStartingAt_E_Taking14MovesThenThereAre14PossibleMoves() {
        assertEquals(0, screenLock.calculateCombinations('E', 14));
    }

    @Test
    void givenStartingAt_B_Taking1MovesThenThereAre1PossibleMoves() {
        assertEquals(1, screenLock.calculateCombinations('B', 1));
    }

    @Test
    void givenStartingAt_C_Taking2MovesThenThereAre5PossibleMoves() {
        assertEquals(5, screenLock.calculateCombinations('C', 2));
    }

    @Test
    void givenStartingAt_E_Taking2MovesThenThereAre8PossibleMoves() {
        assertEquals(8, screenLock.calculateCombinations('E', 2));
    }

    @Test
    void givenStartingAt_E_Taking4MovesThenThereAre256PossibleMoves() {
        assertEquals(256, screenLock.calculateCombinations('E', 4));
    }

    @Test
    public void basics (){
        assertEquals(0, screenLock.calculateCombinations('A',10));
        assertEquals(0, screenLock.calculateCombinations('A',0));
        assertEquals(0, screenLock.calculateCombinations('E',14));
        assertEquals(1, screenLock.calculateCombinations('B',1));
        assertEquals(5, screenLock.calculateCombinations('C',2));
        assertEquals(8, screenLock.calculateCombinations('E',2));
        assertEquals(256, screenLock.calculateCombinations('E',4));

        assertEquals(15564, screenLock.calculateCombinations('E',4));
    }
}