package com.generalassembly;

public abstract class Player {
    protected int score;

    public Player() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }

    public abstract boolean getIsComputer();
    public abstract GestureType takeTurn();
}
