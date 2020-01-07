package com.michalsydoryk.app.boardchecker;

/**
 * This interface represents single checker that allows
 * to check if there is a winning combination in single
 * direction for example horizontal, vertical etc.
 * @param <T> type of coordinates to check
 */
interface UnitChecker<T> {
    /**
     * This method allows to check if there is a single
     * direction wining combination in board.
     * @param coordinatesToCheck coordinate just added to
     *                           the board.
     * @return true if there is a winning combination.
     */
    boolean check(T coordinatesToCheck);
}
