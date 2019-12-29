package com.michalsydoryk.app.gameengine;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Board2D;
import com.michalsydoryk.app.boardchecker.Board2DChecker;

public class GameBuilder {

    public static Game build(GameConfiguration gameConfiguration){
        Board board = new Board2D.Builder()
                .boardSize(gameConfiguration.boardSize)
                .combinationSize(gameConfiguration.combinationSize)
                .build();
        Game game = new Game(board, new Board2DChecker(board),
                gameConfiguration.players, new PlayersPoints(gameConfiguration.players),
                new PlayersSigns(gameConfiguration.players));
        return game;
    }
}
