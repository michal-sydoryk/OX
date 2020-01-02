package com.michalsydoryk.app.gameengine;

import com.michalsydoryk.app.sign.Sign;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class PlayersTest {
    private final Player player1 = new Player("Player1", Sign.NAUGHT);
    private final Player player2 = new Player("Player2", Sign.CROSS);


    public void shouldBeAbleToSetActivePlayerThatWhoWasAddedFirstToPlayers() {
        //Given
        Players players = new Players();
        players.add(player1);
        players.add(player2);
        //When
        players.setFirstPlayer(player1);
        //Then
        Assert.assertEquals(players.getActive(), player1, "Given players are not the same!");
    }

    public void shouldBeAbleToSetActivePlayerThatWhoWasAddedSecondToPlayers() {
        Players players = new Players();
        players.add(player2);
        players.add(player1);
        //When
        players.setFirstPlayer(player1);
        //Then
        Assert.assertEquals(players.getActive(), player1, "Given players are not the same!");
    }

    public void shouldBeAbleToChcangeOrderOfPlayers() {
        //Given
        Players players = new Players();
        players.add(player1);
        players.add(player2);
        //When
        players.setFirstPlayer(player1);
        players.nextRoundOrder();
        //Then
        Assert.assertNotEquals(players.getActive(), player1, "Players are equals!");
    }
}
