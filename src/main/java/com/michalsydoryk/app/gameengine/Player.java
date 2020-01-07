package com.michalsydoryk.app.gameengine;

import com.michalsydoryk.app.sign.Sign;

import java.util.Objects;

class Player {
    private final String name;
    private final Sign sign;

    Player(String name, Sign sign) {
        this.name = name;
        this.sign = sign;
    }

    @Override
    public String toString() {
        return name + " " + sign.toString();
    }

    Sign getSign() {
        return sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                sign == player.sign;
    }
}
