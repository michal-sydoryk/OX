package com.michalsydoryk.app.board;

import com.michalsydoryk.app.sign.Sign;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public final class Board2D implements Board<Coordinates2D> {
    final TreeMap<Coordinates2D, Sign> fields;
    private final int boardSize;
    private BigDecimal numberOfFilledFields;

    public static class Builder{
        private int boardSize = MAX_SIZE;

        public Builder boardSize(int value){
            boardSize = value;
            return this;
        }

        public Board2D build(){
            return new Board2D(this);
        }
    }

    private Board2D(Builder builder){
        this.fields = new TreeMap(new Coordinates2DComparator());
        this.boardSize = builder.boardSize;
        this.numberOfFilledFields = new BigDecimal(0);
    }

    @Override
    public boolean addField(Coordinates2D coordinate, Sign sign){
        if(coordinatesInBoardSize(coordinate))
            if (fields.get(coordinate) == null) {
                fields.put(coordinate, sign);
                numberOfFilledFields = numberOfFilledFields.add(new BigDecimal(1));
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
    public int getSize() {
        return this.boardSize;
    }

    @Override
    public boolean isFull() {
        return numberOfFilledFields.equals(new BigDecimal(boardSize).pow(2));
    }


    @Override
    public void clean() {
        numberOfFilledFields = new BigDecimal(0);
        fields.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board2D board2D = (Board2D) o;
        return boardSize == board2D.boardSize &&
                Objects.equals(fields, board2D.fields) &&
                Objects.equals(numberOfFilledFields, board2D.numberOfFilledFields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fields, boardSize, numberOfFilledFields);
    }
}
