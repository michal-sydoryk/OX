package com.michalsydoryk.app.gameengine;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.boardchecker.BoardChecker;

import java.util.Queue;

public class Game {
    private final Board board;
    private final BoardChecker boardChecker;
    private final Players players;
    private final PlayersPoints playersPoints;
    private final PlayersSigns playersSigns;

    Game(Board board, BoardChecker boardChecker, Players players, PlayersPoints playersPoints, PlayersSigns playersSigns) {
        this.board = board;
        this.boardChecker = boardChecker;
        this.players = players;
        this.playersPoints = playersPoints;
        this.playersSigns = playersSigns;
    }
}
