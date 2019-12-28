package com.michalsydoryk.app.boardchecker;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.coordinates.Coordinates2D;

public class Board2DChecker extends BoardCheckerAbstract<Board, Coordinates2D> {

    Board2DChecker(Board board) {
        super(board);
        unitCheckers.add(new VerticalChecker());
        unitCheckers.add(new HorizontalChecker());
        unitCheckers.add(new RightDownDiagonalChecker());
        unitCheckers.add(new RightUpDiagonalChecker());
    }

    @Override
    public boolean check(Coordinates2D coordinates2D) {
        for(UnitChecker unitChecker: unitCheckers){
            if(unitChecker.check(board, coordinates2D)) return true;
        }
        return false;
    }
}
