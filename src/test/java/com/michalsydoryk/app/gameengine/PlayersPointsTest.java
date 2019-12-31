package com.michalsydoryk.app.gameengine;

import com.michalsydoryk.app.player.Player;
import com.michalsydoryk.app.points.Points;
import com.michalsydoryk.app.points.PointsValue;
import com.michalsydoryk.app.sign.Sign;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Map;

@Test
public class PlayersPointsTest {
    private final Player player1 = new Player("Player1", Sign.NAUGHT);
    private final Player player2 = new Player("Player2", Sign.CROSS);

    private Players players;

    private void PlayersInitialization(){
        players = new Players();
        players.add(player1);
        players.add(player2);

    }

    public void shouldBeAbleToCreatePlayersPointsWithPointNumbersEquals0(){
        //given
        PlayersInitialization();
        BigDecimal expectedValue = new BigDecimal(0);
        //when
        PlayersPoints playersPoints = new PlayersPoints(players);
        Map<Player, Points> playerPointsMap = playersPoints.getPlayerPointsMap();
        BigDecimal value = playerPointsMap.get(player1).getValue();
        //then
        Assert.assertEquals(value, expectedValue, "Players Points are created with different value than 0!");
    }

    public void shouldBeAbleToAddWinPointsForPlayer(){
        //given
        PlayersInitialization();
        PlayersPoints playersPoints = new PlayersPoints(players);
        BigDecimal expectedValue = new BigDecimal(3);
        //when
        playersPoints.addWinPoints(player1);
        BigDecimal pointsVale = playersPoints.getPlayerPointsMap().get(player1).getValue();
        //then
        Assert.assertEquals(pointsVale, expectedValue, "Can not add win points to player points");
    }

    public void shouldBeAbleToAddDrawPointsForPlayers(){
        //given
        PlayersInitialization();
        PlayersPoints playersPoints = new PlayersPoints(players);
        BigDecimal expectedValue = new BigDecimal(1);
        //when
        playersPoints.addDrawPoints();
        BigDecimal pointsValePlayer1 = playersPoints.getPlayerPointsMap().get(player1).getValue();
        BigDecimal pointsValePlayer2 = playersPoints.getPlayerPointsMap().get(player1).getValue();
        //then
        Assert.assertEquals(pointsValePlayer1, expectedValue, "Can not add draw points to players points");
        Assert.assertEquals(pointsValePlayer2, expectedValue, "Can not add draw points to players points");
    }

    public void shouldReturnTrueIfAnyPlayerHasRequiredNumberOfPoints() {
        //Given
        PlayersInitialization();
        PlayersPoints playersPoints = new PlayersPoints(players);
        playersPoints.addWinPoints(player1);
        playersPoints.addWinPoints(player1);
        playersPoints.addWinPoints(player2);
        playersPoints.addDrawPoints();
        int requiredPointsNumber = 7;
        //When
        boolean result = playersPoints.onePlayerHasRequiredNumberOfPoints(requiredPointsNumber);
        //Then
        Assert.assertTrue(result);
    }

    public void shouldReturnFalseIfAnyPlayerHasNoRequiredNumberOfPoints() {
        //Given
        PlayersInitialization();
        PlayersPoints playersPoints = new PlayersPoints(players);
        playersPoints.addWinPoints(player1);
        playersPoints.addWinPoints(player1);
        playersPoints.addWinPoints(player2);
        playersPoints.addDrawPoints();
        int requiredPointsNumber = 8;
        //When
        boolean result = playersPoints.onePlayerHasRequiredNumberOfPoints(requiredPointsNumber);
        //Then
        Assert.assertFalse(result);
    }

    public void shouldBeAbleToGetPlayerWithBiggestPointNumber() {
        //Given
        PlayersInitialization();
        PlayersPoints playersPoints = new PlayersPoints(players);
        playersPoints.addWinPoints(player1);
        playersPoints.addWinPoints(player1);
        //When
        Player playerWithBiggestPointNumber = playersPoints.getPlayerWithBiggestPointNumber();
        //Then
        Assert.assertEquals(playerWithBiggestPointNumber, player1, "There is player with Biggest point number");
    }

    public void shouldReturnTrueIfThereIsGameWinner() {
        //Given
        PlayersInitialization();
        PlayersPoints playersPoints = new PlayersPoints(players);
        playersPoints.addWinPoints(player1);
        //When
        boolean result = playersPoints.haveGameWinner();
        //Then
        Assert.assertTrue(result, "Can not get to know is there a game winner or not!");
    }

    public void shouldFalseTrueIfPlayersHaveSameNumberPoints() {
        //Given
        PlayersInitialization();
        PlayersPoints playersPoints = new PlayersPoints(players);
        playersPoints.addDrawPoints();
        playersPoints.addDrawPoints();
        //When
        boolean result = playersPoints.haveGameWinner();
        //Then
        Assert.assertFalse(result, "Can not get to know is there a game winner ot not!");
    }


}
