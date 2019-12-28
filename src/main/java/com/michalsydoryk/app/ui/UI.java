package com.michalsydoryk.app.ui;

public interface UI<T> {
    int takeInput();
    void print(T toPrint);
    void printBoard();
}
