package com.michalsydoryk.app.boardchecker;

import java.util.LinkedList;
import java.util.List;

abstract class BoardCheckerAbstract<T, Q>  implements BoardChecker<Q>{
    protected final T board;
    protected final List<UnitChecker> unitCheckers;

    BoardCheckerAbstract(T board){
        this.board = board;
        this.unitCheckers = new LinkedList();
    }

}
