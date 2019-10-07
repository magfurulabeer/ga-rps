package com.generalassembly;

public class HumanPlayer extends Player {
    @Override
    public boolean getIsComputer() {
        return false;
    }

    @Override
    public GestureType takeTurn() {
        IO.shared().lineBreak();
        String question = "Please enter Rock, Paper, or Scissors";
        String type = IO.shared().qa(question, true, "rock", "paper", "scissors");
        if(type == "rock" || type == "r") {
            return GestureType.ROCK;
        } else if(type == "paper" || type == "p") {
            return GestureType.PAPER;
        } else {
            return GestureType.SCISSORS;
        }
    }
}
