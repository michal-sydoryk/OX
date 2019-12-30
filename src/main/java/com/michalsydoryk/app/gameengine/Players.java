package com.michalsydoryk.app.gameengine;

import com.michalsydoryk.app.player.Player;

import java.util.Deque;
import java.util.LinkedList;

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

    void changeOrder(){
        Player player = playerDeque.pollFirst();
        playerDeque.addLast(player);
    }

    Player getFirstPlayer(){
        
    }

    public Deque<Player> getPlayerDeque() {
        return new LinkedList<>(playerDeque);
    }
}
