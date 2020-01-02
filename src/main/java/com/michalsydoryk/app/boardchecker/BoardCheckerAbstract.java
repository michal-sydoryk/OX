package com.michalsydoryk.app.boardchecker;

import java.util.LinkedList;
import java.util.List;

abstract class BoardCheckerAbstract<T, Q>  implements BoardChecker<Q>{
    protected final T board;
    protected final List<UnitChecker> unitCheckers;
    protected final int combinationSize;

    BoardCheckerAbstract(T board, int combinationSize){
        this.board = board;
        this.combinationSize = combinationSize;
        this.unitCheckers = new LinkedList();
    }

}
