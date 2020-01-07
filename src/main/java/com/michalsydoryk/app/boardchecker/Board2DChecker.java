package com.michalsydoryk.app.boardchecker;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Coordinates2D;
import com.michalsydoryk.app.boardchecker.RightUpDiagonalChecker;

public class Board2DChecker extends BoardCheckerAbstract<Board, Coordinates2D> {

    public Board2DChecker(Board board, int combinationSize) {
        super(board, combinationSize);
        unitCheckers.add(new VerticalChecker(board, combinationSize));
        unitCheckers.add(new HorizontalChecker(board, combinationSize));
        unitCheckers.add(new RightDownDiagonalChecker(board, combinationSize));
        unitCheckers.add(new RightUpDiagonalChecker(board, combinationSize));
    }

    @Override
    public CheckResult check(Coordinates2D coordinates2D) {
        for (UnitChecker unitChecker : unitCheckers) {
            if (unitChecker.check(coordinates2D)) return CheckResult.WIN;
        }
        if (checkForFullBoard())
            return CheckResult.DRAW;
        return CheckResult.NOTHING;
    }

    private boolean checkForFullBoard(){
        return board.isFull();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
