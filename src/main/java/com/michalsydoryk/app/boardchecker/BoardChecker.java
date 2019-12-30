package com.michalsydoryk.app.boardchecker;

public interface BoardChecker<T> {
    CheckResult check(T coordinates);
}
