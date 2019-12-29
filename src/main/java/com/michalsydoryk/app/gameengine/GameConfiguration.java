package com.michalsydoryk.app.gameengine;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.boardchecker.BoardChecker;

import java.util.Locale;
import java.util.ResourceBundle;

class GameConfiguration {
    //for board
    private ResourceBundle resourceBundle;
    int boardSize;
    int combinationSize;

    public GameConfiguration(String locale) {
        this.resourceBundle = ResourceBundle.getBundle("OXLabels", Locale.forLanguageTag(locale));
    }

    void setBoardSize(int boardSize) throws WrongBoardSizeException {
        if (boardSize < Board.MIN_SIZE || boardSize > Board.MAX_SIZE)
            throw new WrongBoardSizeException(resourceBundle.getString("wrong_board_size"));
    }


}
