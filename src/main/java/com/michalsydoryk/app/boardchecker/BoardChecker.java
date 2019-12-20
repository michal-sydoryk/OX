package com.michalsydoryk.app.boardchecker;

public interface BoardChecker<T> {
    boolean check(T coordinates);
}
