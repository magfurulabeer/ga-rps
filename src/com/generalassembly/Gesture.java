package com.generalassembly;

public class Gesture {
    private GestureType type;

    private Gesture(GestureType type) {
        this.type = type;
    }

    public static Gesture rock() {
        return new Gesture(GestureType.ROCK);
    }

    public static Gesture paper() {
        return new Gesture(GestureType.PAPER);
    }

    public static Gesture scissors() {
        return new Gesture(GestureType.SCISSORS);
    }

    public int compareTo(Gesture g) {
        switch(this.type) {
            case ROCK:
                return against(g.type, GestureType.SCISSORS, GestureType.PAPER);
            case PAPER:
                return against(g.type, GestureType.ROCK, GestureType.SCISSORS);
            case SCISSORS:
                return against(g.type, GestureType.PAPER, GestureType.ROCK);
        }
        throw new RuntimeException("Gesture::compareTo - Invalid type for object");
    }

    private int against(GestureType g, GestureType winsTo, GestureType losesTo) {
        if(g == winsTo) {
            return 1;
        } else if(g == losesTo) {
            return -1;
        }
        return 0;
    }


}
