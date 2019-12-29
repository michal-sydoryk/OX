package com.michalsydoryk.app.ui;

import com.michalsydoryk.app.boarddrawer.BoardDrawer;

import java.util.ResourceBundle;

public interface UI {
    void setBoardDrawer(BoardDrawer boardDrawer);
    void setResourceBundle(ResourceBundle resourceBundle);
    String takeInput();
    void clearScreen();
    void print(String toPrint);
    void printEmptyBoard(int boardSize);
    void printBoard();
}
