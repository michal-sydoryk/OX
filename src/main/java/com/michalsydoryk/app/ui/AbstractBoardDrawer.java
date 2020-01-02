package com.michalsydoryk.app.ui;


abstract class AbstractBoardDrawer<T, Q>  implements BoardDrawer<Q>{
    protected T board;

    AbstractBoardDrawer(T board){
        this.board = board;
    }
}
