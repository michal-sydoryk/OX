package com.michalsydoryk.app.boardchecker;

interface UnitChecker<T> {
    boolean check(T coordinatesToCheck);
}
