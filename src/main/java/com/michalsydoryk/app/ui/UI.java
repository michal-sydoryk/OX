package com.michalsydoryk.app.ui;

import com.michalsydoryk.app.board.Board;

/**
 * Interface that represents a User Interface
 * responsible for taking input form user and
 * printing output.
 */
public interface UI {
    /**
     * This method sets a BoardDrawer for given
     * board.
     * @param board board that will be used to print.
     */
    void setBoardDrawer(Board board);

    /**
     * This method takes input from user and produces
     * its String representation.
     * @return String representation of taken input.
     */
    String takeInput();

    /**
     * This method takes numerical (integer) input from
     * user and produces its int representation.
     * @return int representation of taken input.
     */
    int takeInputNumber();

    /**
     * This method users screen.
     */
    void clearScreen();

    /**
     * This method prints given String.
     * @param toPrint String needed to be print.
     */
    void print(String toPrint);

    /**
     * This method prints given String's.
     * @param toPrint1 String needed to be print.
     * @param toPrint2 String needed to be print.
     */
    void print(String toPrint1, String toPrint2);

    /**
     * This method prints empty board with given size.
     * @param boardSize board size in int.
     */
    void printEmptyBoard(int boardSize);

    /**
     * This method prints board.
     */
    void printBoard();

    /**
     * This method is needed to choose language.
     */
    void chooseLanguage();
}
