package com.michalsydoryk.app.boardchecker;

import java.util.LinkedList;
import java.util.List;

/**\
 * Abstract class that represent checker.
 * Is's based on List of UnitChecker's.
 * @param <T> type of board.
 * @param <Q> type of coordinates.
 */
abstract class BoardCheckerAbstract<T, Q>  implements BoardChecker<Q>{
    protected final T board;
    protected final List<UnitChecker> unitCheckers;
    protected final int combinationSize;

    BoardCheckerAbstract(T board, int combinationSize){
        this.board = board;
        this.combinationSize = combinationSize;
        this.unitCheckers = new LinkedList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardCheckerAbstract<?, ?> that = (BoardCheckerAbstract<?, ?>) o;
        return combinationSize == that.combinationSize;
    }
}
