package com.michalsydoryk.app.gameengine;

import com.michalsydoryk.app.board.Board;
import com.michalsydoryk.app.board.Board2D;
import com.michalsydoryk.app.sign.Sign;
import com.michalsydoryk.app.ui.UI;

public class GameConfigurator {
    UI ui;

    public GameConfigurator(UI ui) {
        this.ui = ui;
    }

    public void start(){
        Players players = createPlayers();
        int boardSize = addBoardSize();
        int combinationSize = addCombinationSize();

        gameConfiguration.board = new Board2D.Builder()
                .boardSize(boardSize)
                .combinationSize(combinationSize)
                .build();

        ui.setBoardDrawer(gameConfiguration.board);
    }

    private int addCombinationSize() {
        ui.print("combination_size_info");
        int combinatonSize;

        while (true){
            combinatonSize = ui.takeInputNumber();

            if(combinatonSize >= Board.MIN_SIZE && combinatonSize <= boardSize)
                return combinatonSize;
            else
                ui.print("wrong_combination_size");
        }
    }

    private int addBoardSize() {
        ui.print("choose_board_size_info");
        ui.printEmptyBoard(Board.MIN_SIZE);

        int boardSize = 3;
        int number;

        while(true){
            ui.print("enter_a_number_then_confirm");
            number = ui.takeInputNumber();
            ui.print(String.valueOf(number));

            if(number == 0) break;

            if(number >= Board.MIN_SIZE && number <= 40) { //change for max size Board.MAX_SIZE
                boardSize = number;
                ui.printEmptyBoard(boardSize);
            }
            else
                ui.print("wrong_board_size");

        }

        return boardSize;
    }


    private Players createPlayers(){
        Players players = new Players();
        players.add(addPlayer(Sign.CROSS));
        players.add(addPlayer(Sign.NAUGHT));
        return players;
    }

    private Player addPlayer(Sign sign){
        ui.clearScreen();
        ui.print("enter_player_name");

        String playerName = ui.takeInput();

        if (isValidName(playerName)) return new Player(playerName, sign);

        ui.print("wrong_length_of_player_name");

        return addPlayer(sign);
    }

    private boolean isValidName(String playerName){
        int maxLengthOfPlayerName = 20;
        if(playerName.length() > maxLengthOfPlayerName) return false;
        return true;
    }

    public GameConfiguration getGameConfiguration() {
        return gameConfiguration;
    }


}
