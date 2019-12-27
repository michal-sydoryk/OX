package com.michalsydoryk.app.boardchecker;

import com.michalsydoryk.app.board.Board2D;
import com.michalsydoryk.app.coordinates.Coordinates2D;

class HorizontalChecker implements UnitChecker<Board2D, Coordinates2D>{

    @Override
    public boolean check(Board2D board, Coordinates2D coordinatesToCheck) {
        int x = coordinatesToCheck.getX();
        int y = coordinatesToCheck.getY();
        int combinationSize = board.getCombinationSize();
        int actualCombinationSize = 1;
        int position = 1;
        boolean leftDirection = true;
        boolean rightDirection = true;
        while (leftDirection || rightDirection){
            if (leftDirection) {
                if (board.getSignFromField(new Coordinates2D(x - position, y)) == board.getSignFromField(coordinatesToCheck)) {
                    actualCombinationSize++;
                } else {
                    leftDirection = false;
                }
            }
            if(actualCombinationSize == combinationSize) return true;
            if (rightDirection) {
                if (board.getSignFromField(new Coordinates2D(x  + position, y)) == board.getSignFromField(coordinatesToCheck)) {
                    actualCombinationSize++;
                } else {
                    rightDirection = false;
                }
            }
            if(actualCombinationSize == combinationSize) return true;
            position++;
        }
        return false;
    }
}
