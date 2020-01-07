package com.michalsydoryk.app.gameengine;

import com.michalsydoryk.app.sign.Sign;
import com.michalsydoryk.app.ui.ConsoleUI;
import com.michalsydoryk.app.ui.UI;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.mockito.Matchers.booleanThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Test
public class GameConfiguratorTest {
    private GameConfigurator gameConfigurator;

    public void canCreateGame() {
        //Given
        int boardSize = 5;
        int acceptBoardSize = 0;
        int combinationSize = 3;
        String player1 = "Player1";
        String player2 = "Player2";
        Players players = new Players();
        players.add(new Player(player1, Sign.CROSS));
        players.add(new Player(player2, Sign.NAUGHT));
        UI mockUI = mock(ConsoleUI.class);
        when(mockUI.takeInput()).thenReturn(player1, player2);
        when(mockUI.takeInputNumber()).thenReturn(boardSize, acceptBoardSize, combinationSize);
        gameConfigurator = new GameConfigurator(mockUI);
        //When
        Game game = gameConfigurator.createGame();
        Game expectedGame = new Game.GameBuilder().
                addBoard(boardSize).
                addBoardChecker(combinationSize).
                addPlayersAndPlayersPoints(players).
                addUI(mockUI).
                build();
        boolean equalsResult = game.equals(expectedGame);
        //Then
        Assert.assertTrue(equalsResult, "Crated game is not same as expected!");
    }
}
