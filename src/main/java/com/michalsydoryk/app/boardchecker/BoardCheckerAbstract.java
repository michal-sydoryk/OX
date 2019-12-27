package com.michalsydoryk.app.boardchecker;

import com.michalsydoryk.app.board.Board;

import java.util.List;

public abstract class BoardCheckerAbstract<T, Q>  implements BoardChecker<Q>{
    protected T board;
    protected List<UnitChecker> unitCheckers;

    BoardCheckerAbstract(T board){
        this.board = board;
    }

}
