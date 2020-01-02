package com.michalsydoryk.app.boardchecker;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Coordinates2D;

class HorizontalChecker extends AbstractUnitChecker2D{

    public HorizontalChecker(Board board, int combinationSize) {
        super(board, combinationSize);
    }

    @Override
    boolean matchingSingInDecreasingDirection(Coordinates2D coordinatesToCheck, int position) {
        if (board.getSignFromField(new Coordinates2D(coordinatesToCheck.getX() - position, coordinatesToCheck.getY())) == board.getSignFromField(coordinatesToCheck)) return true;
        return false;
    }

    @Override
    boolean matchingSingInIncreasingDirection(Coordinates2D coordinatesToCheck, int position) {
        if (board.getSignFromField(new Coordinates2D(coordinatesToCheck.getX() + position, coordinatesToCheck.getY())) == board.getSignFromField(coordinatesToCheck)) return true;
        return false;
    }
}
