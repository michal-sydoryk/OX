package com.michalsydoryk.app.boardchecker;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.coordinates.Coordinates2D;

import java.math.BigDecimal;

public class Board2DChecker extends BoardCheckerAbstract<Board, Coordinates2D> {

    public Board2DChecker(Board board) {
        super(board);
        unitCheckers.add(new VerticalChecker());
        unitCheckers.add(new HorizontalChecker());
        unitCheckers.add(new RightDownDiagonalChecker());
        unitCheckers.add(new RightUpDiagonalChecker());
    }

    @Override
    public CheckResult check(Coordinates2D coordinates2D) {
        for (UnitChecker unitChecker : unitCheckers) {
            if (unitChecker.check(board, coordinates2D)) return CheckResult.WIN;
        }
        if (board.isFull())
            return CheckResult.DRAW;
        return CheckResult.NOTHING;
    }

}
