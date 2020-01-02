package com.michalsydoryk.app.boardchecker;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Coordinates2D;

class VerticalChecker extends AbstractUnitChecker2D {

    public VerticalChecker(Board board, int combinationSize) {
        super(board, combinationSize);
    }

    @Override
    boolean matchingSingInDecreasingDirection(Coordinates2D coordinatesToCheck, int position) {
        if (board.getSignFromField(new Coordinates2D(coordinatesToCheck.getX(), coordinatesToCheck.getY() - position)) == board.getSignFromField(coordinatesToCheck)) return true;
        return false;
    }

    @Override
    boolean matchingSingInIncreasingDirection(Coordinates2D coordinatesToCheck, int position) {
        if (board.getSignFromField(new Coordinates2D(coordinatesToCheck.getX(), coordinatesToCheck.getY() + position)) == board.getSignFromField(coordinatesToCheck)) return true;
        return false;
    }
}
