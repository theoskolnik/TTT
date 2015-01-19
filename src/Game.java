import java.io.IOException;

/**
 * Created by tskolnik on 1/15/15.
 */
public class Game {

    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private Board board;

    public Game(Board board, Player player1, Player player2, Player currentPlayer) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = currentPlayer;
    }

    public void start() throws IOException {
        while(!gameIsOver()) {
            play();
        }
    }

    public void play() throws IOException {
            board.print();
            currentPlayer.move();
            swapPlayers();
            board.print();
            currentPlayer.move();
    }

    private void swapPlayers() {
        if(currentPlayer.equals(player1)) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean gameIsOver() {
        return board.allSpacesTaken();
    }
}
