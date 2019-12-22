package com.michalsydoryk.app.board;

import com.michalsydoryk.app.coordinates.Coordinates2D;
import com.michalsydoryk.app.coordinatescomparator.Coordinates2DComparator;
import com.michalsydoryk.app.sign.Sign;

import java.util.Set;
import java.util.TreeMap;

public class Board2D implements Board<Coordinates2D> {
    private static final int MAX_SIZE = Integer.MAX_VALUE;
    private static final int MIN_SIZE = 0;
    TreeMap<Coordinates2D, Sign> fields;
    private final int boardSize;
    private int combinationSize;

    public Board2D() {
        this.fields = new TreeMap(new Coordinates2DComparator());
        this.boardSize = MAX_SIZE;
    }

    public Board2D(int boardSize) {
        this.fields = new TreeMap(new Coordinates2DComparator());
        this.boardSize = boardSize;
    }

    public Board2D(int boardSize, int combinationSize) {
        this.fields = new TreeMap(new Coordinates2DComparator());
        this.boardSize = boardSize; //for indexing from 0
        this.combinationSize = combinationSize;
    }

    @Override
    public boolean addField(Coordinates2D coordinate, Sign sign){
        if(coordinatesInBoardSize(coordinate))
            if (fields.get(coordinate) == null) {
                fields.put(coordinate, sign);
                return true;
            }
        return false;
    }

    boolean coordinatesInBoardSize(Coordinates2D coordinates){
        int max = Math.max(coordinates.getX(), coordinates.getY());
        int min = Math.min(coordinates.getX(), coordinates.getY());
        return ((max <= boardSize) && (min >= MIN_SIZE));
    }

    @Override
    public Sign getSignFromField(Coordinates2D coordinate){
        Sign sign;
        if(coordinatesInBoardSize(coordinate)) {
            sign = fields.get(coordinate);
            if (sign != null)
                return sign;
        }
        return Sign.EMPTY;
    }

    @Override
    public Set<Coordinates2D> getAllCoordinates() {
        return fields.keySet();
    }

    @Override
    public int getCombinationSize() {
        return this.combinationSize;
    }

    @Override
    public int getSize() {
        return this.boardSize;
    }

}
