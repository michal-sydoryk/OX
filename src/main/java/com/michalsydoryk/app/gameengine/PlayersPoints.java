package com.michalsydoryk.app.gameengine;

import com.michalsydoryk.app.player.Player;
import com.michalsydoryk.app.points.Points;
import com.michalsydoryk.app.points.PointsValue;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlayersPoints {
    private Map<Player, Points> playerPointsMap;

    public PlayersPoints(Players players) {
        playerPointsMap = new HashMap<>();

        Deque<Player> playersDeque = players.getPlayerDeque();
        for(Player player: playersDeque){
            playerPointsMap.put(player, new Points());
        }
    }

    void addWinPoints(Player player){
        playerPointsMap.get(player).add(PointsValue.WIN);
    }

    void addLosePoints(Player player){
        playerPointsMap.get(player).add(PointsValue.LOSE);
    }

    void addDrawPoints(Player player){
        playerPointsMap.get(player).add(PointsValue.DRAW);
    }

    Points getPoints(Player player){
        return playerPointsMap.get(player);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Set<Player> playerSet = playerPointsMap.keySet();
        for(Player player: playerSet){
            stringBuilder.append(player.toString());
            stringBuilder.append(" -> ");
            stringBuilder.append(playerPointsMap.get(player).toString());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
