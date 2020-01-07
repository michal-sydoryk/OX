package com.michalsydoryk.app.gameengine;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

class Players {
    private final Deque<Player> playerDeque;
    private Player playerHowStartsEarlierGame;

    Players() {
        this.playerDeque = new LinkedList<>();
    }

    void add(Player player){
        this.playerDeque.add(player);
    }

    void setFirstPlayer(Player player){
        playerDeque.remove(player);
        playerDeque.addFirst(player);
        playerHowStartsEarlierGame = player;
    }

    void nextRoundOrder(){
        playerDeque.remove(playerHowStartsEarlierGame);
        playerDeque.addLast(playerHowStartsEarlierGame);
        playerHowStartsEarlierGame = playerDeque.getFirst();
    }


    Player getActive(){
        return playerDeque.peekFirst();
    }


    Deque<Player> getPlayerDeque() {
        return new LinkedList<>(playerDeque);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players = (Players) o;
        return Objects.equals(playerDeque, players.playerDeque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerDeque, playerHowStartsEarlierGame);
    }

}
