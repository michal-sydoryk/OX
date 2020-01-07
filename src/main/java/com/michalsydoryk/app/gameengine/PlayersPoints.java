package com.michalsydoryk.app.gameengine;

import java.math.BigDecimal;
import java.util.*;

class PlayersPoints {
    private Map<Player, Points> playerPointsMap;

    PlayersPoints(Players players) {
        playerPointsMap = new HashMap<>();

        Deque<Player> playersDeque = players.getPlayerDeque();
        for(Player player: playersDeque){
            playerPointsMap.put(player, new Points());
        }
    }

    void addWinPoints(Player player){
        playerPointsMap.get(player).add(PointsValue.WIN);
    }

    void addDrawPoints(){
        for(Points points: playerPointsMap.values()){
            points.add(PointsValue.DRAW);
        }
    }

    boolean onePlayerHasRequiredNumberOfPoints(int requiredPointsNumber){
        for(Player player: playerPointsMap.keySet()){
            if (playerPointsMap.get(player).getValue().equals(new BigDecimal(requiredPointsNumber))) return true;
        }
        return false;
    }

    Player getPlayerWithBiggestPointNumber(){
        Deque<Player> playerDeque = new LinkedList<>(playerPointsMap.keySet());
        Player playerWithBiggestPointNumber = playerDeque.pollFirst();

        for (Player player: playerDeque){
            if(checkIfPlayerHasMorePoints(player, playerWithBiggestPointNumber)) playerWithBiggestPointNumber = player;
        }
        return playerWithBiggestPointNumber;
    }

    private boolean checkIfPlayerHasMorePoints(Player player1, Player player2){
        int comparationValue = playerPointsMap.get(player1).getValue().compareTo(playerPointsMap.get(player2).getValue());
        if (comparationValue == 1)return true;
        return false;

    }

    boolean haveGameWinner(){
        List<Points> pointsList = new ArrayList(playerPointsMap.values());
        Points pointsToCompare = pointsList.get(0);
        pointsList.remove(pointsToCompare);
        for (int i = 0; i < pointsList.size(); i++) {
            if (!pointsToCompare.equals(pointsList.get(i))) return true;
        }
        return false;
    }

    Map<Player, Points> getPlayerPointsMap() {
        return new HashMap<>(playerPointsMap);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayersPoints that = (PlayersPoints) o;
        return Objects.equals(playerPointsMap, that.playerPointsMap);
    }
}
