package com.michalsydoryk.app.ui;

/**
 * Interface needed to print board.
 * @param <Q> this type will be a board representation.
 */
interface BoardDrawer<Q> {
    /**
     * This method change Board to board representation in
     * demanded type.
     * @return board representation in demanded type.
     */
    Q draw();
}
