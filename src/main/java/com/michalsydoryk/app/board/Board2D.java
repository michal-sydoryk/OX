package com.michalsydoryk.app.board;

import com.michalsydoryk.app.coordinates.Coordinates2D;
import com.michalsydoryk.app.coordinatescomparator.Coordinates2DComparator;
import com.michalsydoryk.app.sign.Sign;

import java.util.Set;
import java.util.TreeMap;

public final class Board2D implements Board<Coordinates2D> {
    private static final int MAX_SIZE = Integer.MAX_VALUE;
    private static final int MIN_INDEX = 0;
    final TreeMap<Coordinates2D, Sign> fields;
    private final int boardSize;
    private final int combinationSize;

    private Board2D(TreeMap<Coordinates2D, Sign> fields, int boardSize, int combinationSize) {
        this.fields = fields;
        this.boardSize = boardSize;
        this.combinationSize = combinationSize;
    }

    public static class Builder{
        private TreeMap<Coordinates2D, Sign> fields = new TreeMap();
        private int boardSize = 3;
        private int combinationSize = 3;

        public Builder boardSize(int value){
            boardSize = value;
            return this;
        }
        public Builder combinationSize(int value){
            combinationSize = value;
            return this;
        }

        public Board2D build(){
            return new Board2D(this);
        }
    }

    private Board2D(Builder builder){
        this.fields = builder.fields;
        this.boardSize = builder.boardSize;
        this.combinationSize = builder.combinationSize;
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
        return ((max <= boardSize) && (min >= MIN_INDEX));
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
