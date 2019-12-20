package com.michalsydoryk.app.boarddrawer;

import com.michalsydoryk.app.boardchecker.BoardCheckerAbstract;

public abstract class BoardDrawerAbstract<T, Q>  implements BoardDrawer<Q>{
    protected T board;

    BoardDrawerAbstract(T board){
        this.board = board;
    }
}
