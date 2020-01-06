package com.michalsydoryk.app.ui;

import com.michalsydoryk.app.board.Board;

import java.util.ResourceBundle;

public interface UI {
    void setBoardDrawer(Board board);
    String takeInput();
    int takeInputNumber();
    void clearScreen();
    void print(String toPrint);
    void print(String toPrint1, String toPrint2);
    void printEmptyBoard(int boardSize);
    void printBoard();
    void chooseLanguage();
}
