package com.michalsydoryk.app.player;

import com.michalsydoryk.app.sign.Sign;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                sign == player.sign;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sign);
    }
}
