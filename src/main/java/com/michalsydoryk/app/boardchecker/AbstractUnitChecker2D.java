package com.michalsydoryk.app.boardchecker;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Coordinates2D;

/**
 * This class is a abstract class for 2 dimensional
 * coordinates.
 */
abstract class AbstractUnitChecker2D implements UnitChecker<Coordinates2D> {
    protected final Board board;
    protected final int combinationSize;

    public AbstractUnitChecker2D(Board board, int combinationSize) {
        this.board = board;
        this.combinationSize = combinationSize;
    }

    @Override
    public boolean check(Coordinates2D coordinatesToCheck) {
        int actualCombinationSize = 1;
        int position = 1;
        boolean decreasingDirection = true;
        boolean increasingDirection = true;
        while (decreasingDirection || increasingDirection){
            if (decreasingDirection) {
                if (matchingSingInDecreasingDirection(coordinatesToCheck, position)) {
                    actualCombinationSize++;
                } else {
                    decreasingDirection = false;
                }
            }
            if(actualCombinationSize == combinationSize) return true;
            if (increasingDirection) {
                if (matchingSingInIncreasingDirection(coordinatesToCheck, position)) {
                    actualCombinationSize++;
                } else {
                    increasingDirection = false;
                }
            }
            if(actualCombinationSize == combinationSize) return true;
            position++;
        }
        return false;
    }

    /**
     * This method allow to check if field assign to input
     * coordinates have the same sign as coordinates differing
     * a number of fields from sign in field of input coordinates
     * @param coordinatesToCheck coordinates to get a sign.
     * @param position number of fields in decreasing direction
     *                 from input coordinates to coordinates
     *                 to check
     * @return true if there is the same sign
     */
    abstract boolean matchingSingInDecreasingDirection(Coordinates2D coordinatesToCheck, int position);

    /**
     * This method allow to check if field assign to input
     * coordinates have the same sign as coordinates differing
     * a number of fields from sign in field of input coordinates
     * @param coordinatesToCheck coordinates to get a sign.
     * @param position number of fields in increasing direction
     *                 from input coordinates to coordinates
     *                 to check
     * @return true if there is the same sign
     */
    abstract boolean matchingSingInIncreasingDirection(Coordinates2D coordinatesToCheck, int position);
}
