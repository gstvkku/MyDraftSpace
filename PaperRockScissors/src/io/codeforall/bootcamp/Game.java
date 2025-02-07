package io.codeforall.bootcamp;

public class Game {

    private final Players PLAYER1;
    private final Players PLAYER2;
    private int player1Score;
    private int player2Score;
    private int roundsCounting;
    private int rounds;

    public Game(Players player1, Players player2, int rounds) {
        this.PLAYER1 = player1;
        this.PLAYER2 = player2;
        this.rounds = rounds;
    }

    public void roundsResult1() {
        this.roundsCounting++;
        this.player1Score++;
        System.out.println(PLAYER1.playerName + " won the " + this.roundsCounting + " round!");
    }

    public void roundsResult2() {
        this.roundsCounting++;
        this.player2Score++;
        System.out.println(PLAYER2.playerName + " won the " + this.roundsCounting + " round!");
    }

    public void MoveSelection() {
        System.out.println("Get ready!");
        PLAYER1.defineMove();
        PLAYER2.defineMove();
        System.out.println("Player 1: " + PLAYER1.playerName + " chose " + PLAYER1.getMove());
        System.out.println("Player 2: " + PLAYER2.playerName + " chose " + PLAYER2.getMove());
    }

    public void play() {
        if (this.rounds != 0) {
            System.out.println("Lets start the game! :)");
            while (this.roundsCounting <= this.rounds || this.player1Score == this.player2Score) {
                MoveSelection();
                if (PLAYER1.getMove() == PLAYER2.getMove()) {
                    this.roundsCounting++;
                    System.out.println("Round " + this.roundsCounting + ": Tie!");
                } else if (PLAYER1.getMove() == Moves.ROCK && PLAYER2.getMove() == Moves.SCISSORS ||
                        PLAYER1.getMove() == Moves.PAPER && PLAYER2.getMove() == Moves.ROCK ||
                        PLAYER1.getMove() == Moves.SCISSORS && PLAYER2.getMove() == Moves.PAPER) {
                    roundsResult1();
                } else {
                    roundsResult2();
                }
            }
            if (player1Score > player2Score) {
                System.out.println(PLAYER1.playerName + " is the winner!");
            } else {
                System.out.println(PLAYER2.playerName + " is the winner!");
            }
            System.out.println("END OF GAME :)");
        }
    }
}