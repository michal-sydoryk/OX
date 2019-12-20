package com.michalsydoryk.app.boardchecker;

import com.michalsydoryk.app.board.Board;

public abstract class BoardCheckerAbstract<T, Q>  implements BoardChecker<Q>{
    protected T board;

    BoardCheckerAbstract(T board){
        this.board = board;
    }

}
