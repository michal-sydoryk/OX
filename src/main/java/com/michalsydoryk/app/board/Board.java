package com.michalsydoryk.app.board;

import com.michalsydoryk.app.sign.Sign;

import java.util.Set;

/**
 * Basic board for OX game.
 * @param <T> type of coordinates (key value for fields).
 */
public interface Board<T> {
    int MAX_SIZE = Integer.MAX_VALUE;
    int MIN_SIZE = 3;
    int MIN_INDEX = 0;

    /**
     * This method allows to add coordinate with sign to board.
     * @param coordinates coordinates to add to board.
     * @param sign value for coordinates.
     * @return true if field is not empty and in board size.
     */
    boolean addField(T coordinates, Sign sign);

    /**
     * This method allows to get sign from input coordinates.
     * @param coordinates coordinates to get a sign.
     * @return Sign for input coordinates.
     */
    Sign getSignFromField(T coordinates);

    /**
     * This method allows to get a Set of coordinates which
     * was added to board earlier.
     * @return Set of coordinates.
     */
    Set<T> getAllCoordinates();

    /**
     * This method allows to get size of board.
     * @return int number of size
     */
    int getSize();

    /**
     * This method allows to check if board is full or not.
     * @return true if board is full
     */
    boolean isFull();

    /**
     * Removes all coordinates added to board.
     */
    void clean();
}
