package com.michalsydoryk.app.boardchecker;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Coordinates2D;

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
    
    abstract boolean matchingSingInDecreasingDirection(Coordinates2D coordinatesToCheck, int position);
    abstract boolean matchingSingInIncreasingDirection(Coordinates2D coordinatesToCheck, int position);


}
