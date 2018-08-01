package com.daleellis.condingwars;

/**
 * The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge line.
 * Each of them has a single 100, 50 or 25 dollars bill. An "Avengers" ticket costs 25 dollars.
 * <p>
 * Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.
 * <p>
 * Can Vasya sell a ticket to each person and give the change if he initially has no money and sells the tickets strictly in the order people follow in the line?
 * <p>
 * Return YES, if Vasya can sell a ticket to each person and give the change with the bills he has at hand at that moment. Otherwise return NO.
 *
 * @author dale.ellis
 * @since 01/08/2018
 */
public class Line {

    public static String Tickets(int[] peopleInLine) {
        Clerk clerk = new Clerk();

        for (int notePaid : peopleInLine) {
            if (!clerk.buyTicket(notePaid)) {
                return "NO";
            }
        }

        return "YES";
    }

    private static class Clerk {
        private int note25Count;
        private int note50Count;
        private int note100Count;

        boolean buyTicket(int amount) {
            if (amount == 25) {
                note25Count++;
                return true;
            }

            return buyTicketRequiringChange(amount);
        }

        private boolean buyTicketRequiringChange(int amount) {
            int changeRequired = amount - 25;

            if (isNoMoreChangeRequired(changeRequired)) {
                if (amount == 50) {
                    note50Count++;
                }
                if (amount == 100) {
                    note100Count++;
                }
                return true;
            }
            ;
            return false;
        }

        private boolean isNoMoreChangeRequired(int changeRequired) {
            int amountRequiredAfterApprovingNote = getAmountRequiredAfterApprovingNote(changeRequired);

            if (amountRequiredAfterApprovingNote == 0) {
                return true;
            }
            if (amountRequiredAfterApprovingNote == changeRequired) {
                return false;
            }

            return isNoMoreChangeRequired(amountRequiredAfterApprovingNote);
        }

        private int getAmountRequiredAfterApprovingNote(int changeRequired) {
            int amountRequiredAfterApprovingNote = changeRequired;

            if (is100NoteRequiredAvailable(changeRequired)) {
                amountRequiredAfterApprovingNote = changeRequired - 100;
                note100Count--;
            } else if (is50NoteRequiredAvailable(changeRequired)) {
                amountRequiredAfterApprovingNote = changeRequired - 50;
                note50Count--;
            } else if (is25NoteRequiredAvailable(changeRequired)) {
                amountRequiredAfterApprovingNote = changeRequired - 25;
                note25Count--;
            }

            return amountRequiredAfterApprovingNote;
        }

        private boolean is100NoteRequiredAvailable(int changeRequired) {
            return changeRequired >= 100 && note100Count > 0;
        }

        private boolean is50NoteRequiredAvailable(int changeRequired) {
            return changeRequired >= 50 && note50Count > 0;
        }

        private boolean is25NoteRequiredAvailable(int changeRequired) {
            return changeRequired >= 25 && note25Count > 0;
        }
    }
}
