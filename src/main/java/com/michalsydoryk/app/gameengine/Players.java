package com.michalsydoryk.app.gameengine;

import com.michalsydoryk.app.player.Player;

import java.util.Deque;
import java.util.LinkedList;

class Players {
    private final Deque<Player> playerDeque;

    Players() {
        this.playerDeque = new LinkedList<>();
    }

    void add(Player player){
        this.playerDeque.add(player);
    }

    void setFirsPlayer(Player player){
        playerDeque.remove(player);
        playerDeque.addFirst(player);
    }

    void changeOrder(){
        Player player = playerDeque.pollFirst();
        playerDeque.addLast(player);
    }


}
