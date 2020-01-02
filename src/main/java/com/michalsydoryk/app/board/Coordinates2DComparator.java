package com.michalsydoryk.app.board;


import java.util.Comparator;

class Coordinates2DComparator implements Comparator<Coordinates2D> {

    @Override
    public int compare(Coordinates2D o1, Coordinates2D o2) {
        if(o1.getY() > o2.getY()) return 1;
        if(o1.getY() < o2.getY()) return -1;
        if (o1.getX() > o2.getX()) return 1;
        else if (o1.getX() < o2.getX()) return -1;
        else return 0;
    }
}
