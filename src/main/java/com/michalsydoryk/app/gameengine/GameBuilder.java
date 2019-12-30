package com.michalsydoryk.app.gameengine;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.boardchecker.Board2DChecker;
import com.michalsydoryk.app.ui.UI;

public class GameBuilder {

    public static Game build(GameConfiguration gameConfiguration , UI ui){
        Board board = gameConfiguration.board;
        ui.setBoardDrawer(board);
        Game game = new Game(board,
                new Board2DChecker(board),
                gameConfiguration.players,
                new PlayersPoints(gameConfiguration.players),
                new PlayersSigns(gameConfiguration.players),
                ui);
        return game;
    }
}
