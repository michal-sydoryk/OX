package com.michalsydoryk.app.boardchecker;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Coordinates2D;

class RightDownDiagonalChecker implements UnitChecker<Board, Coordinates2D>{

    @Override
    public boolean check(Board board, Coordinates2D coordinatesToCheck) {
        int x = coordinatesToCheck.getX();
        int y = coordinatesToCheck.getY();
        int combinationSize = board.getCombinationSize();
        int actualCombinationSize = 1;
        int position = 1;
        boolean upDirection = true;
        boolean downDirection = true;
        while (upDirection || downDirection){
            if (upDirection) {
                if (board.getSignFromField(new Coordinates2D(x - position, y - position)) == board.getSignFromField(coordinatesToCheck)) {
                    actualCombinationSize++;
                } else {
                    upDirection = false;
                }
            }
            if(actualCombinationSize == combinationSize) return true;
            if (downDirection) {
                if (board.getSignFromField(new Coordinates2D(x  + position, y + position)) == board.getSignFromField(coordinatesToCheck)) {
                    actualCombinationSize++;
                } else {
                    downDirection = false;
                }
            }
            if(actualCombinationSize == combinationSize) return true;
            position++;
        }
        return false;
    }
}
