package com.daleellis.condingwars.kata5;

/**
 * @author dale.ellis
 * @since 26/06/2019
 */
public class Scramblies {

    public static boolean scramble(String scrambled, String testString) {
        for (char charToFind : testString.toCharArray()) {
            if (!scrambled.contains("" + charToFind)) {
                return false;
            }
            scrambled = scrambled.replaceFirst("" + charToFind, "");
        }

        return true;
    }
}
