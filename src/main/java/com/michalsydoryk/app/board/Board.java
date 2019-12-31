package com.michalsydoryk.app.board;

import com.michalsydoryk.app.sign.Sign;

import java.util.Set;

public interface Board<T> {
    int MAX_SIZE = Integer.MAX_VALUE;
    int MIN_SIZE = 3;
    int MIN_INDEX = 0;

    boolean addField(T coordinates, Sign sign);
    Sign getSignFromField(T coordinates);
    Set<T> getAllCoordinates();
    int getCombinationSize();
    int getSize();
}
