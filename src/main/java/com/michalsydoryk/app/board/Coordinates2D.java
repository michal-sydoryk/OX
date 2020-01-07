package com.michalsydoryk.app.board;

/**
 * This class represents 2 dimensional coordinates.
 */
public class Coordinates2D {
    private final int x;
    private final int y;

    public Coordinates2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates2D that = (Coordinates2D) o;
        return x == that.x &&
                y == that.y;
    }
}
