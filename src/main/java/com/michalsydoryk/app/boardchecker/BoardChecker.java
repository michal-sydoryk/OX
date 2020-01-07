package com.michalsydoryk.app.boardchecker;

/**
 * Interface that represents a board checker which
 * finds (or not finds) a winning combination in every
 * direction. It includes a list or set of UnitCheker's.
 * @param <T> Type of coordinates.
 */
public interface BoardChecker<T> {
    /**
     * This method runs all UnitCheckers and additional
     * methods needed to get a result.
     * @param coordinates coordinates just added to board.
     * @return CheckResult which is WIN, DRAW or NOTHING.
     */
    CheckResult check(T coordinates);
}
