package com.michalsydoryk.app.player;

import com.michalsydoryk.app.sign.Sign;

public class Player {
    private final String name;
    private final Sign sign;

    public Player(String name, Sign sign) {
        this.name = name;
        this.sign = sign;
    }

    @Override
    public String toString() {
        return name + " " + sign.toString();
    }

    public Sign getSign() {
        return sign;
    }
}
