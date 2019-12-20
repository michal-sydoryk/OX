package com.michalsydoryk.app.board;

import com.michalsydoryk.app.board.exception.FieldIsNotEmptyException;
import com.michalsydoryk.app.board.exception.OutOfBoardBorderException;
import com.michalsydoryk.app.coordinates.Coordinates2D;
import com.michalsydoryk.app.coordinatescomparator.Coordinates2DComparator;
import com.michalsydoryk.app.sign.Sign;

import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Board2D implements Board<Coordinates2D> {
    private static final int MAX_SIZE = Integer.MAX_VALUE;
    private static final int MIN_SIZE = 0;
    TreeMap<Coordinates2D, Sign> fields;
    private int boardSize = MAX_SIZE;

    public Board2D() {
        this.fields = new TreeMap(new Coordinates2DComparator());
    }

    public Board2D(int boardSize) {
        this.fields = new TreeMap(new Coordinates2DComparator());
        this.boardSize = boardSize;
    }

    @Override
    public void addField(Coordinates2D coordinate, Sign sign) throws OutOfBoardBorderException, FieldIsNotEmptyException {
        if(coordinatesInBoardSize(coordinate))
            if(fields.get(coordinate) == null)
                fields.put(coordinate, sign);
            else
                throw new FieldIsNotEmptyException("Field is not Empty!");
        else throw new OutOfBoardBorderException("Coordinate [" + coordinate.getX()
                + " " + coordinate.getY() + "]" + " is out of board size: " + boardSize);
    }

    boolean coordinatesInBoardSize(Coordinates2D coordinates){
        int max = Math.max(coordinates.getX(), coordinates.getY());
        int min = Math.min(coordinates.getX(), coordinates.getY());
        return ((max <= boardSize) && (min >= MIN_SIZE));
    }

    @Override
    public Sign getSignFromField(Coordinates2D coordinate) {
        return fields.get(coordinate);
    }

    @Override
    public Queue<Coordinates2D> getAllField() {
        return null;
    }

}
