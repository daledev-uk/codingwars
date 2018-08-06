package com.daleellis.condingwars.kata3;

import java.util.*;

/**
 * https://www.codewars.com/kata/screen-locking-patterns/train/java
 *
 * @author dale.ellis
 * @since 05/08/2018
 */
public class ScreenLock {
    private static final String ALL_POINTS = "ABCDEFGHI";
    private static final Map<String, List<Blocking>> BLOCKERS = new HashMap<>();

    public ScreenLock() {
        BLOCKERS.put("A", Arrays.asList(new Blocking("C", "B"), new Blocking("G", "D"), new Blocking("I", "E")));
        BLOCKERS.put("B", Arrays.asList(new Blocking("H", "E")));
        BLOCKERS.put("C", Arrays.asList(new Blocking("A", "B"), new Blocking("G", "E"), new Blocking("I", "F")));
        BLOCKERS.put("D", Arrays.asList(new Blocking("F", "E")));
        BLOCKERS.put("F", Arrays.asList(new Blocking("D", "E")));
        BLOCKERS.put("G", Arrays.asList(new Blocking("C", "E"), new Blocking("A", "D"), new Blocking("I", "H")));
        BLOCKERS.put("H", Arrays.asList(new Blocking("B", "E")));
        BLOCKERS.put("I", Arrays.asList(new Blocking("G", "H"), new Blocking("A", "E"), new Blocking("C", "F")));
    }

    private class Blocking {
        private String target;
        private String blockedBy;

        private Blocking(String target, String blockedBy) {
            this.target = target;
            this.blockedBy = blockedBy;
        }

        private boolean isMoveAllowed(String endPoint, String remainingPoints) {
            return !isRuleForTheGivenTarget(endPoint) || isBlockingStepAlreadyUsed(remainingPoints);
        }

        private boolean isRuleForTheGivenTarget(String endPoint) {
            return target.equals(endPoint);
        }

        private boolean isBlockingStepAlreadyUsed(String remainingPoints) {
            return !remainingPoints.contains(blockedBy);
        }
    }

    public int calculateCombinations(char startPositionChar, int patternLength) {
        if (patternLength == 1) {
            return 1;
        }

        String startPosition = String.valueOf(startPositionChar);
        String remainingPoints = ALL_POINTS.replace(String.valueOf(startPosition), "");

        Set<String> possibleMoves = new HashSet<>();
        calculateMoves(startPosition, remainingPoints, possibleMoves, patternLength);

        return getMovesForPath(possibleMoves, patternLength);
    }

    private int getMovesForPath(Set<String> possibleMoves, int patternLength) {
        Set<String> pathsOfLength = new HashSet<>();
        for (String possibleMove : possibleMoves) {
            if (possibleMove.length() >= patternLength) {
                String movesForGivenLength = possibleMove.substring(0, patternLength);
                pathsOfLength.add(movesForGivenLength);
            }
        }
        return pathsOfLength.size();
    }

    private void calculateMoves(String path, String remainingPoints, Set<String> possibleMoves, int patternLength) {
        String startPoint = path.substring(path.length() - 1);

        for (int index = 0; index < remainingPoints.length(); index++) {
            String endPoint = String.valueOf(remainingPoints.charAt(index));
            checkPathEnded(path, startPoint, endPoint, remainingPoints, possibleMoves, patternLength);
        }
    }

    private void checkPathEnded(String path, String startPoint, String endPoint, String remainingPoints, Set<String> possibleMoves, int patternLength) {
        String remainingPointsAfterMove = remainingPoints.replace(endPoint, "");
        if (isMoveBetweenPointsAllowed(startPoint, endPoint, path, remainingPointsAfterMove, patternLength)) {
            String newPath = path + endPoint;
            if (newPath.length() == patternLength) {
                possibleMoves.add(newPath);
            } else {
                calculateMoves(newPath, remainingPointsAfterMove, possibleMoves, patternLength);
            }
        }
    }

    private boolean isMoveBetweenPointsAllowed(String startPoint, String endPoint, String path, String remainingPoints, int patternLength) {
        List<Blocking> blockers = BLOCKERS.getOrDefault(startPoint, Collections.emptyList());
        for (Blocking blocker : blockers) {
            if (!blocker.isMoveAllowed(endPoint, remainingPoints)) {
                return false;
            }
        }

        return !remainingPoints.isEmpty() || path.length() > patternLength;
    }
}
