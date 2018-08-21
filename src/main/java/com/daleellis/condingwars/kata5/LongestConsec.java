package com.daleellis.condingwars.kata5;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 * https://www.codewars.com/kata/consecutive-strings/train/java
 * <p>
 * You are given an array "input" of strings and an integer "k".
 * Your task is to return the first longest string consisting of k consecutive strings taken in the array.
 * <p>
 * #Example: longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2) --> "abigailtheta"
 * <p>
 * n being the length of the string array, if n = 0 or k > n or k <= 0 return "".
 *
 * @author dale.ellis
 * @since 08/08/2018
 */
public class LongestConsec {
    public static String longestConsec(String[] input, int targetNumberOfStrings) {
        LinkedHashMap<String, Integer> wordsInOrderWithLength = new LinkedHashMap<>();
        for (String word : input) {
            wordsInOrderWithLength.computeIfAbsent(word, String::length);
        }

        String longestWord = getFirstLongestWord(wordsInOrderWithLength);
        int index = getIndexWordFirstAppears(longestWord, input);

        if (index == -1) {
            return "";
        }


        String forwardResult = getWordsForwardResult(input, index, targetNumberOfStrings);
        String backwardsResult = getWordsBackwordResult(input, index, targetNumberOfStrings);

        if (forwardResult.length() > backwardsResult.length()) {
            return forwardResult;
        } else {
            return backwardsResult;
        }
    }

    private static String getFirstLongestWord(LinkedHashMap<String, Integer> wordsInOrderWithLength) {
        AtomicReference<String> longestWord = new AtomicReference<>("");

        wordsInOrderWithLength.forEach((word, length) -> {
            if (word.length() > longestWord.get().length()) {
                longestWord.set(word);
            }
        });

        return longestWord.get();
    }

    private static int getIndexWordFirstAppears(String word, String[] inputs) {
        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            if (input.equals(word)) {
                return i;
            }
        }
        return -1;
    }

    private static String getWordsForwardResult(String[] input, int index, int targetNumberOfStrings) {
        int endIndex = index + targetNumberOfStrings;
        if (endIndex > input.length) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        while (index < endIndex) {
            result.append(input[index++]);
        }

        return result.toString();
    }

    private static String getWordsBackwordResult(String[] input, int index, int targetNumberOfStrings) {
        int startIndex = (index - targetNumberOfStrings) + 1;
        if (startIndex < 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        while (startIndex <= index) {
            result.append(input[startIndex++]);
        }

        return result.toString();
    }

}
