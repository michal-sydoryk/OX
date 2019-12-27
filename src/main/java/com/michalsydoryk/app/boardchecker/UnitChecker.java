package com.michalsydoryk.app.boardchecker;

interface UnitChecker<T,Q> {
    boolean check(T board, Q coordinatesToCheck);
}
