package com.generalassembly;

public class Game {
    private Player player1;
    private Player player2;
    private History history;
    private int currentGameCount;

    public Game() {
        this.currentGameCount = 1;
        this.history = new History();
    }

    public void run() {
        introduction();
        createPlayers();
        presentMenu();
    }

    public void introduction() {
        IO.shared().out(("Welcome to Java - Rock Paper Scissors!"));
        IO.shared().out("The only game where the rock isn't throwable, the paper won't overflow your stack, and the scissors don't have null pointers.");
        IO.shared().lineBreak();
    }

    public void createPlayers() {
        String playerType = IO.shared().qa("Is the first player a human or a computer?",
                true,
                "human", "computer");
        player1 = playerType == "human" ? new HumanPlayer() : new ComputerPlayer();
        IO.shared().lineBreak();


        playerType = IO.shared().qa("Is the second player a human or a computer?",
                true,
                "human", "computer");
        player2 = playerType == "human" ? new HumanPlayer() : new ComputerPlayer();
    }

    public void runRound() {
        IO.shared().lineBreak();
        String round = "Round " + String.valueOf(currentGameCount);
        IO.shared().out(round);
        IO.shared().lineBreak();

        GestureType p1 = player1.takeTurn();
        GestureType p2 = player2.takeTurn();

        int player1DidWin = p1.compareTo(p2);
        String play1 = "Player 1 plays " + p1.toString().toLowerCase();
        String play2 = "Player 2 plays " + p2.toString().toLowerCase();
        IO.shared().out(play1);
        IO.shared().out(play2);

        String result;
        if(player1DidWin == 1) {
            result = "Player 1 wins!";
            player1.incrementScore();
        } else if(player1DidWin == -1) {
            result = "Player 2 wins!";
            player2.incrementScore();
        } else {
            result = "It's a draw!";
        }

        IO.shared().out(result);
        history.saveResults(round, play1, play2, result);
        printScore();
        currentGameCount++;
    }

    private void printScore() {
        IO.shared().lineBreak();
        IO.shared().out("Player 1: " + String.valueOf(player1.getScore()) + " | Player 2: " + String.valueOf(player2.getScore()));
    }

    private void presentMenu() {
        IO.shared().lineBreak();
        IO.shared().out("MAIN MENU");
        IO.shared().out("=====");
        String menu = "1. Type 'play' to play.\n" +
                "2. Type 'history' to view your game history.\n" +
                "3. Type 'quit' to stop playing.";
        String value = IO.shared().qa(menu, true, "play", "history", "quit", "1", "2", "3");
        switch(value) {
            case "1":
            case "play":
                runRound();
                presentMenu();
                break;
            case "2":
            case "history":
                history.print();
                presentMenu();
                break;
            case "3":
            case "quit":
                System.exit(0);
        }
    }
}
