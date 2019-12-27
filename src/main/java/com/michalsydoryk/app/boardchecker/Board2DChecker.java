package com.michalsydoryk.app.boardchecker;

import com.michalsydoryk.app.board.Board2D;
import com.michalsydoryk.app.coordinates.Coordinates2D;

import java.util.LinkedList;

public class Board2DChecker extends BoardCheckerAbstract<Board2D, Coordinates2D> {

    Board2DChecker(Board2D board2D) {
        super(board2D);
        unitCheckers = new LinkedList<>();
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
