package com.michalsydoryk.app.boardchecker;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Coordinates2D;

/**
 * This class represents a winning combination checker\
 * for 2 dimensional board and 2 dimensional coordinates.
 */
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

    /**
     * Additional function that check if there
     * is board with not empty fields.
     * @return true if board is full.
     */
    private boolean checkForFullBoard(){
        return board.isFull();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
