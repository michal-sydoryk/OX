package com.michalsydoryk.app.board;

import com.michalsydoryk.app.board.exception.FieldIsNotEmptyException;
import com.michalsydoryk.app.board.exception.OutOfBoardBorderException;

import com.michalsydoryk.app.sign.Sign;

import java.util.Queue;

public interface Board<T> {
    void addField(T coordinates, Sign sign) throws OutOfBoardBorderException, FieldIsNotEmptyException;
    Sign getSignFromField(T coordinates);
    Queue<T> getAllField();

}
