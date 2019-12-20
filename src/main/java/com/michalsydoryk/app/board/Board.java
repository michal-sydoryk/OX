package com.michalsydoryk.app.board;

import com.michalsydoryk.app.sign.Sign;

import java.util.Set;

public interface Board<T> {
    boolean addField(T coordinates, Sign sign);
    Sign getSignFromField(T coordinates);
    Set<T> getAllCoordinates();
    int getCombinationSize();
    int getSize();
}
