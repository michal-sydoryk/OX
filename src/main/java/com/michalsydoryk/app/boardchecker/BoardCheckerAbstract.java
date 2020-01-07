package com.michalsydoryk.app.boardchecker;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(combinationSize);
    }
}
