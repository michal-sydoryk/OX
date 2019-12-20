package com.michalsydoryk.app.board;

import com.michalsydoryk.app.board.exception.FieldIsEmptyException;
import com.michalsydoryk.app.board.exception.FieldIsNotEmptyException;
import com.michalsydoryk.app.board.exception.OutOfBoardBorderException;

import com.michalsydoryk.app.sign.Sign;

import java.util.Set;

public interface Board<T> {
    void addField(T coordinates, Sign sign) throws OutOfBoardBorderException, FieldIsNotEmptyException;
    Sign getSignFromField(T coordinates) throws FieldIsNotEmptyException, OutOfBoardBorderException, FieldIsEmptyException;
    Set<T> getAllCoordinates();

}
