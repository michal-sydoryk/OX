package com.michalsydoryk.app.coordinates;

import java.util.Objects;

public class Coordinates2D implements Coordinates {
    private int x;
    private int y;

    public Coordinates2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates2D that = (Coordinates2D) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
