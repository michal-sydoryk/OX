package com.michalsydoryk.app.player;

public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player: " + name;
    }
}
