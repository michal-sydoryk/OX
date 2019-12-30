package com.michalsydoryk.app.gameengine;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.boardchecker.BoardChecker;
import com.michalsydoryk.app.player.Player;
import com.michalsydoryk.app.ui.UI;

import java.util.Deque;
import java.util.Queue;

public class Game {
    private final Board board;
    private final BoardChecker boardChecker;
    private final Players players;
    private final PlayersPoints playersPoints;
    private final PlayersSigns playersSigns;

    private UI ui;

    Game(Board board, BoardChecker boardChecker, Players players, PlayersPoints playersPoints, PlayersSigns playersSigns, UI ui) {
        this.board = board;
        this.boardChecker = boardChecker;
        this.players = players;
        this.playersPoints = playersPoints;
        this.playersSigns = playersSigns;
        this.ui = ui;
    }

    public void start() {
        chooseOrder();
    }

    private void chooseOrder() {
        ui.print("choose_order_info");

        Deque<Player> playerDeque = players.getPlayerDeque();
        ui.print("1 - ", playerDeque.peekFirst().toString());
        ui.print("2 - ", playerDeque.peekLast().toString());


        int number = ui.takeInputNumber();
        switch (number){
            case 1: players.setFirsPlayer(playerDeque);

        }
    }

}
