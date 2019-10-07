package com.generalassembly;

public class ComputerPlayer extends Player {
    @Override
    public boolean getIsComputer() {
        return true;
    }

    @Override
    public GestureType takeTurn() {
        int num = (int) (Math.random() * 2);
        if(num == 0) {
            return GestureType.ROCK;
        } else if(num == 1) {
            return GestureType.PAPER;
        } else {
            return GestureType.SCISSORS;
        }
    }
}
