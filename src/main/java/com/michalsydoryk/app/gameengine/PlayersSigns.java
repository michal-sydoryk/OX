package com.michalsydoryk.app.gameengine;

import com.michalsydoryk.app.player.Player;
import com.michalsydoryk.app.sign.Sign;

import java.util.*;

public class PlayersSigns {
    private Map<Player, Sign> playerSignMap;

    public PlayersSigns(Players players) {
        playerSignMap = new HashMap<>();

        Deque<Player> playersDeque = players.getPlayerDeque();
        Deque<Sign> signDeque = new LinkedList<>(Arrays.asList(Sign.values()));

        for(Player player: playersDeque){
            playerSignMap.put(player, signDeque.pollFirst());
        }
    }

    Sign getSign(Player player){
        return playerSignMap.get(player);
    }

}
